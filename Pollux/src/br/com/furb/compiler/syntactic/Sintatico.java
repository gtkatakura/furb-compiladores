package br.com.furb.compiler.syntactic;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.TokenKind;
import br.com.furb.compiler.lexical.impl.gals.LexicalError;
import br.com.furb.compiler.gals.Constants;
import br.com.furb.compiler.lexical.impl.gals.LexicalAnalyser;
import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.SemanticAnalyser;
import br.com.furb.compiler.lexical.impl.gals.Token;

public class Sintatico implements Constants {
	private Stack stack = new Stack();
	private Token currentToken;
	private Token previousToken;
	private LexicalAnalyser scanner;
	private SemanticAnalyser semanticAnalyser;

	private static final boolean isTerminal(int x) {
		return x < FIRST_NON_TERMINAL;
	}

	private static final boolean isNonTerminal(int x) {
		return x >= FIRST_NON_TERMINAL && x < FIRST_SEMANTIC_ACTION;
	}

	private static final boolean isSemanticAction(int x) {
		return x >= FIRST_SEMANTIC_ACTION;
	}

	private boolean step() throws LexicalError, SyntaticError, SemanticError {
		if (currentToken == null) {
			int pos = 0;
			if (previousToken != null)
				pos = previousToken.getPosition() + previousToken.getLexeme().length();

			currentToken = new Token(TokenKind.getClasseById(DOLLAR), "$", pos);
		}

		int x = ((Integer) stack.pop()).intValue();
		int a = currentToken.getKind().getId();

		if (x == EPSILON) {
			return false;
		} else if (isTerminal(x)) {
			if (x == a) {
				if (stack.empty())
					return true;
				else {
					previousToken = currentToken;
					currentToken = scanner.nextToken();
					return false;
				}
			} else {
				String message = "encontrado " + currentToken.getLexeme() + " " + PARSER_ERROR[x];
				throw new SyntaticError(message, currentToken.getPosition());
			}
		} else if (isNonTerminal(x)) {
			if (pushProduction(x, a))
				return false;
			else {
				String message = "encontrado " + currentToken.getLexeme() + " " + PARSER_ERROR[x];
				throw new SyntaticError(message, currentToken.getPosition());
			}
		} else // isSemanticAction(x)
		{
			semanticAnalyser.executeAction(x - FIRST_SEMANTIC_ACTION, previousToken);
			return false;
		}
	}

	private boolean pushProduction(int topStack, int tokenInput) {
		int p = PARSER_TABLE[topStack - FIRST_NON_TERMINAL][tokenInput - 1];
		if (p >= 0) {
			int[] production = PRODUCTIONS[p];
			// empilha a produ��o em ordem reversa
			for (int i = production.length - 1; i >= 0; i--) {
				stack.push(new Integer(production[i]));
			}
			return true;
		} else
			return false;
	}

	public void parse(LexicalAnalyser scanner, SemanticAnalyser semanticAnalyser) throws LexicalError, SyntaticError, SemanticError {
		this.scanner = scanner;
		this.semanticAnalyser = semanticAnalyser;

		stack.clear();
		stack.push(new Integer(DOLLAR));
		stack.push(new Integer(START_SYMBOL));

		currentToken = scanner.nextToken();

		while (!step())
			;
	}
}
