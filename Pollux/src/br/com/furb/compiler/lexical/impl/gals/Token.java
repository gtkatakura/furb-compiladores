package br.com.furb.compiler.lexical.impl.gals;

import br.com.furb.compiler.lexical.Kind;
import br.com.furb.compiler.lexical.IToken;

public class Token implements IToken {
	private Kind kind;
	private String lexeme;
	private int line;

	public Token(Kind kind, String lexeme, int line) {
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
	
	public int getPosition()
    {
        return line;
    }

	public int getLine() {
		return line;
	}
}
