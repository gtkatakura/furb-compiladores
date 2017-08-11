package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public class PushRelationalOperatorAction extends SemanticAction {
	public PushRelationalOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		this.getSymbolTable().getRelationalOperators().push(token.getLexeme());
		return null;
	}

}
