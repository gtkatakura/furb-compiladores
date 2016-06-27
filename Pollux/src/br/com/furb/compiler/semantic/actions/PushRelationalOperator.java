package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class PushRelationalOperator extends ActionSemantic {
	public PushRelationalOperator(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		this.getSymbolTable().getRelationalOperators().push(token.getLexeme());
		return null;
	}

}
