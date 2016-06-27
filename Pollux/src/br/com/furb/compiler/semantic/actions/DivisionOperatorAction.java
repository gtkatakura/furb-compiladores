package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class DivisionOperatorAction extends BinaryOperatorAction {
	public DivisionOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		super.execute(token);
		Stack<String> types = this.getSymbolTable().getTypes();
		types.pop();
		types.push("float64");

		return "div\n";
	}
}
