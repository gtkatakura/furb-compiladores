package br.com.furb.compiler.semantic;

import br.com.furb.compiler.lexical.impl.gals.Token;

public interface ActionSemantic {
	String buildObjectCode(Token token);
}
