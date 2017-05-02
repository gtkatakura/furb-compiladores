package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.Type;

public class DeclareVariableAction extends ActionSemantic {

	private static final String VECTOR_DECLARATION = "newarr [mscorlib]System.%s";
	private static final String VECTOR_BRACKETS = "[] ";

	public DeclareVariableAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		SymbolTable symbolTable = this.getSymbolTable();
		Identifier identifier = symbolTable.getStackIdentifiers().pop();

		if (symbolTable.getIdentifiers().containsKey(identifier.toString())) {
			throw new SemanticError(identifier.toString() + " j� declarado", token.getPosition());
		}
		symbolTable.getIdentifiers().put(identifier.toString(), identifier);

		return buildDeclarationFor(identifier);
	}

	private String buildDeclarationFor(Identifier identifier) {
		String declaration = ".locals (" + identifier.getTypeDescription();
		String closeDeclaration = ")";

		if (identifier.getSize() != null) {
			return formatVectorDeclaration(identifier, declaration, closeDeclaration);
		}
		
		declaration += " " + identifier + closeDeclaration;
		
		if (identifier.getTypeDescription() == "int64") {
			return (
				declaration + "\n" +
				"ldc.i8 0\n" +
				"stloc " + identifier.toString()
			);
		} else if (identifier.getTypeDescription() == "float64") {
			return (
				declaration + "\n" +
				"ldc.r8 0.0\n" +
				"stloc " + identifier.toString()
			);
		}
		
		return declaration;
	}

	public String formatVectorDeclaration(Identifier id, String declaration, String closeDeclaration) {
		return new StringBuilder(declaration).append(VECTOR_BRACKETS) //
				.append(" ").append(id).append(closeDeclaration).append("\n") //
				.append("ldc.i8 ").append(id.getSize()).append("\n") //
				.append(buildNewArrayFunctionCallFor(id.getType())).append("\n") //
				.append("stloc ").append(id) //
				.toString();
	}

	public String buildNewArrayFunctionCallFor(Type type) {
		return String.format(VECTOR_DECLARATION, type.getCorrespondingClass());
	}
}
