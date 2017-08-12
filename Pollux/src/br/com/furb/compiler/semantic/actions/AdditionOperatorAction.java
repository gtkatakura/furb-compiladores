package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class AdditionOperatorAction extends BinaryOperatorAction {
	public AdditionOperatorAction(SymbolTable symbolTable) {
		super(symbolTable, '+');
	}

	@Override
	public String execute(Token token) throws SemanticError {
		super.execute(token);
		return "add\n";
	}

}
