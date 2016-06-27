package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateFloat extends ActionSemantic {
	public AllocateFloat(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		return "ldc.r8 " + this.formatLexeme(token.getLexeme()) + "\n";
	}
	
	private String formatLexeme(String lexeme) {
		return lexeme.replace(",", ".");
	}
}
