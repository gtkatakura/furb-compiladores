package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class MultiplicationOperatorAction extends BinaryOperatorAction {
	public MultiplicationOperatorAction(SymbolTable symbolTable) {
		super(symbolTable, '*');
	}

	public String execute(Token token) throws SemanticError {
		super.execute(token);
		return "mul\n";
	}
}
