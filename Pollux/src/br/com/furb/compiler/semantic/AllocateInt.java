package br.com.furb.compiler.semantic;

import br.com.furb.compiler.lexical.impl.gals.Token;

public class AllocateInt implements ActionSemantic {
	public String buildObjectCode(Token token) {
		return "ldc.i8 " + token.getLexeme() + "\n";
	}
}
