package br.com.furb.compiler.model.lexical;

public final class TokenImpl implements Token {

	private final Kind kind;
	private final String lexeme;
	private final int line;

	public TokenImpl(Kind kind, String lexeme, int line) {
		this.kind = kind;
		this.lexeme = lexeme;
		this.line = line;
	}

	public Kind getKind() {
		return kind;
	}

	public String getLexeme() {
		return kind.getId() == 1 ? "fim do programa" : lexeme;
	}

	public int getPosition() {
		return line;
	}

	public int getLine() {
		return line;
	}
}
