package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.Type;

public class DeclareVariableAction extends ActionSemantic {

	private static final String VECTOR_DECLARATION = "newarr [mscorlib]Sytem.%s";
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
		String closeDeclaration = ")\n";

		Integer size = identifier.getSize();
		if (size != null) {
			return formatVectorDeclaration(identifier, declaration, closeDeclaration);
		}
		return (declaration + " " + identifier + closeDeclaration);
	}

	public String formatVectorDeclaration(Identifier id, String declaration, String closeDeclaration) {
		return new StringBuilder(declaration).append(VECTOR_BRACKETS) //
				.append(" ").append(id).append(closeDeclaration) //
				.append("ldc.i8 ").append(id.getSize()).append("\n") //
				.append(buildNewArrayFunctionCallFor(id.getType())).append("\n") //
				.append("stloc ").append(id).append("\n") //
				.toString();
	}

	public String buildNewArrayFunctionCallFor(Type type) {
		return String.format(VECTOR_DECLARATION, type.getCorrespondingClass());
	}
}
