package br.com.furb.compiler.lexical;

public interface IToken {

	Kind getKind();

	String getLexeme();

	int getLine();
}
