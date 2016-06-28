package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class LogicalOrOperatorAction extends ActionSemantic {
	public LogicalOrOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		Stack<String> types = this.getSymbolTable().getTypes();
		String type1 = types.pop();
		String type2 = types.pop();
		
		if (type1 != "bool" || type2 != "bool") {
			throw new SemanticError(
				"Operador 'or' só pode ser aplicado sobre operandos de tipo 'bool'",
				token.getPosition()
			);
		}

		types.push("bool");
		return "or\n";
	}
}

