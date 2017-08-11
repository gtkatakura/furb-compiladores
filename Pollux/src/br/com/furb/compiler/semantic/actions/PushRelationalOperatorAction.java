package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class PushRelationalOperatorAction extends SemanticAction {
	public PushRelationalOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(TokenImpl token) {
		this.getSymbolTable().getRelationalOperators().push(token.getLexeme());
		return null;
	}

}
