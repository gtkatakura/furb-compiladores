package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class DivisionOperatorAction extends BinaryOperatorAction {
	
	public DivisionOperatorAction(SymbolTable symbolTable) {
		super(symbolTable, '/');
	}

	public String execute(Token token) throws SemanticError {
		super.execute(token);
		Stack<String> types = this.getSymbolTable().getTypes();

		if (types.pop() == "int64") {
			types.push("float64");
			return (
				"conv.r8\n" +
				"div\n"
			);
		};

		types.push("float64");
		return "div\n";
	}
}
