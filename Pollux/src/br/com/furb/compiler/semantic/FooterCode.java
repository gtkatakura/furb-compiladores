package br.com.furb.compiler.semantic;

import br.com.furb.compiler.lexical.impl.gals.Token;

public class FooterCode implements ActionSemantic {
	public String buildObjectCode(Token token) {
		return (
					"ret\n" +
				"}\n" +
			"}"
		);
	}
}
