package br.com.furb.compiler.lexical.impl.gals;

import java.util.ArrayList;
import java.util.List;

import br.com.furb.compiler.lexical.Lexical;
import br.com.furb.compiler.lexical.IToken;

public class LexicoAdapter implements Lexical {

	private LexicalAnalyser lexico;
	private List<IToken> tokens;

	public LexicoAdapter(String input) throws LexicalError {
		this.lexico = new LexicalAnalyser(input);
		this.tokens = this.buildTokens(lexico);
	}

	public List<IToken> getTokens() {
		return this.tokens;
	}

	private List<IToken> buildTokens(LexicalAnalyser lexico) throws LexicalError {
		List<IToken> tokens = new ArrayList<IToken>();
		Token token = null;

		while ((token = lexico.nextToken()) != null) {
			tokens.add(token);
		}

		return tokens;
	}
}
