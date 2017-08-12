package br.com.furb.compiler.model.lexical;

public interface Token {

	Kind getKind();

	String getLexeme();

	int getLine();

	int getPosition();

}
