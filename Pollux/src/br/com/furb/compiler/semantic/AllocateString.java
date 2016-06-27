package br.com.furb.compiler.semantic;

import br.com.furb.compiler.lexical.impl.gals.Token;

public class AllocateString implements ActionSemantic {
	public String buildObjectCode(Token token) {
		return "ldstr " + token.getLexeme() + "\n";
	}
}
