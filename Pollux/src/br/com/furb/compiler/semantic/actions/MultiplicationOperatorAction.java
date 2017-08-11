package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class MultiplicationOperatorAction extends BinaryOperatorAction {
	public MultiplicationOperatorAction(SymbolTable symbolTable) {
		super(symbolTable, '*');
	}

	public String execute(TokenImpl token) throws SemanticError {
		super.execute(token);
		return "mul\n";
	}
}
