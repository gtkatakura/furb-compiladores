package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.ObjectCode;
import br.com.furb.compiler.semantic.SymbolTable;

public class DivisionOperatorAction extends BinaryOperatorAction {
	public DivisionOperatorAction(SymbolTable symbolTable) {
		super(symbolTable, '/');
	}

	public String execute(Token token) throws SemanticError {
		super.execute(token);
		Stack<String> types = this.getSymbolTable().getTypes();

		if (types.pop() == "int64") {
			types.push("float64");
			return new ObjectCode(
				"conv.r8",
				"div"
			).toString();
		};

		types.push("float64");
		return "div";
	}
}
