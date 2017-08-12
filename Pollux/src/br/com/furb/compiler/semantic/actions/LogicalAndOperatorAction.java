package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class LogicalAndOperatorAction extends SemanticAction {
	
	public LogicalAndOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		Stack<String> types = this.getSymbolTable().getTypes();
		String type1 = types.pop();
		String type2 = types.pop();
		
		if (type1 != "bool" || type2 != "bool") {
			throw new SemanticError(
				"Operador 'and' s� pode ser aplicado sobre operandos de tipo 'bool'",
				token.getPosition()
			);
		}

		types.push("bool");
		return "and\n";
	}
}

