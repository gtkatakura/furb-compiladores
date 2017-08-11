package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateFloatAction extends SemanticAction {
	public AllocateFloatAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		this.getSymbolTable().getTypes().push("float64");
		return "ldc.r8 " + this.formatLexeme(token.getLexeme()) + "\n";
	}
	
	private String formatLexeme(String lexeme) {
		return lexeme.replace(",", ".");
	}
}
