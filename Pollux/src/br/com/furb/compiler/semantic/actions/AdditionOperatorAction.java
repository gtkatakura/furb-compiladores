package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class AdditionOperatorAction extends BinaryOperatorAction {
	public AdditionOperatorAction(SymbolTable symbolTable) {
		super(symbolTable, '+');
	}

	@Override
	public String execute(TokenImpl token) throws SemanticError {
		super.execute(token);
		return "add\n";
	}

}
