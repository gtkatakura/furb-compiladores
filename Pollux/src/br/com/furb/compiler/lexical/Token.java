package br.com.furb.compiler.lexical;

public interface Token {

	Kind getKind();

	String getLexeme();

	int getLine();

	int getPosition();

}
