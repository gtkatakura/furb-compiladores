package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.model.semantic.Type;
import static br.com.furb.compiler.model.semantic.Type.*;

public final class DivisionOperatorAction extends BinaryOperatorAction {
	
	public DivisionOperatorAction(SymbolTable symbolTable) {
		super(symbolTable, '/');
	}

	public String execute(Token token) throws SemanticError {
		super.execute(token);
		Stack<Type> types = this.getSymbolTable().getTypes();

		if (types.pop() == INT) {
			types.push(FLOAT);
			return (
				"conv.r8\n" +
				"div\n"
			);
		};

		types.push(FLOAT);
		return "div\n";
	}
}
