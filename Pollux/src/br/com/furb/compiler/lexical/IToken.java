package br.com.furb.compiler.lexical;

public interface IToken {
	public IKind getKind();
	public String getLexeme();
	public int getLine();
}
