package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;
import br.com.furb.compiler.semantic.Type;

public class DeclareVariableAction extends ActionSemantic {

	private static final String VECTOR_DECLARATION = "newarr [mscorlib] Sytem.%s";
	private static final String VECTOR_BRACKETS = "[ ] ";

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
		StringBuilder declaration = new StringBuilder(".locals (");
		declaration.append(identifier.getTypeDescription()).append(" ");

		String closeDeclaration = ")\n";
		if (identifier.isVector()) {
			declaration.append(formatVectorDeclaration(identifier, closeDeclaration));
		} else {
			declaration.append(identifier).append(closeDeclaration);
		}
		return declaration.toString();
	}

	public String formatVectorDeclaration(Identifier id, String pieceOfCode) {
		return new StringBuilder(VECTOR_BRACKETS) //
				.append(id) //
				.append(pieceOfCode) //
				.append(buildNewArrayFunctionCallFor(id.getType())) //
				.toString();
	}

	public String buildNewArrayFunctionCallFor(Type type) {
		return String.format(VECTOR_DECLARATION, type.getCorrespondingClass());
	}
}
