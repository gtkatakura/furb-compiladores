package br.com.furb.compiler.lexical.impl.gals;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.compiler.lexical.Lexical;
import br.com.furb.compiler.lexical.Token;

public class LexicoAdapter implements Lexical {

	private LexicalAnalyser lexico;
	private List<Token> tokens;

	public LexicoAdapter(String input) throws LexicalError {
		this.lexico = new LexicalAnalyser(input);
		this.tokens = this.buildTokens(lexico);
	}

	public List<Token> getTokens() {
		return this.tokens;
	}

	private List<Token> buildTokens(LexicalAnalyser lexico) throws LexicalError {
		List<Token> tokens = new ArrayList<Token>();
		TokenImpl token = null;

		while ((token = lexico.nextToken()) != null) {
			tokens.add(token);
		}

		return tokens;
	}
}
