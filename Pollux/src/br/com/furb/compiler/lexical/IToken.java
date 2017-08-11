package br.com.furb.compiler.lexical;

public interface IToken {

	IKind getKind();

	String getLexeme();

	int getLine();
}
