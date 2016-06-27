package br.com.furb.compiler.semantic;

import br.com.furb.compiler.lexical.impl.gals.Token;

public class AllocateFloat implements ActionSemantic {
	public String buildObjectCode(Token token) {
		return "ldc.r8 " + this.formatLexeme(token.getLexeme()) + "\n";
	}
	
	private String formatLexeme(String lexeme) {
		return lexeme.replace(",", ".");
	}
}
