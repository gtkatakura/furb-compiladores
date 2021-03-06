package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import static br.com.furb.compiler.model.semantic.Type.FLOAT;

public final class AllocateFloatAction extends SemanticAction {
	public AllocateFloatAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		this.getSymbolTable().getTypes().push(FLOAT);
		return "ldc.r8 " + this.formatLexeme(token.getLexeme()) + "\n";
	}

	private String formatLexeme(String lexeme) {
		return lexeme.replace(",", ".");
	}
}
