package br.com.furb.compiler.analysis.syntatic;

import java.util.Stack;

import br.com.furb.compiler.analysis.lexical.LexicalAnalyser;
import br.com.furb.compiler.analysis.lexical.LexicalError;
import br.com.furb.compiler.analysis.semantic.SemanticAnalyser;
import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.gals.Constants;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.lexical.TokenImpl;
import br.com.furb.compiler.model.lexical.TokenKind;

public class SyntaticAnalyser implements Constants {

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

			currentToken = new TokenImpl(TokenKind.getClassBy(DOLLAR), "$", pos);
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
			semanticAnalyser.execute(x - FIRST_SEMANTIC_ACTION, previousToken);
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

	public void parse(LexicalAnalyser scanner, SemanticAnalyser semanticAnalyser)
			throws LexicalError, SyntaticError, SemanticError {
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
