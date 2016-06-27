package br.com.furb.compiler.semantic;

import br.com.furb.compiler.lexical.impl.gals.Token;

public class HeaderCode implements ActionSemantic {
	public String buildObjectCode(Token token) {
		return (
			".assembly extern mscorlib {}\n" +
			".assembly codigo_objeto {}\n" +
			".module codigo_objeto.exe\n" +
			".class public _Principal {\n" +
				".method static public void _principal() {\n" +
					".entrypoint\n"
		);
	}
}
