package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.ObjectCode;
import br.com.furb.compiler.semantic.SymbolTable;

public class LogicalNegationOperatorAction extends ActionSemantic {
	public LogicalNegationOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		Stack<String> types = this.getSymbolTable().getTypes();
		String type = types.pop();
		
		if (type != "bool") {
			throw new SemanticError(
				"Operador 'not' só pode ser aplicado sobre operandos de tipo 'bool'",
				token.getPosition()
			);
		}
		
		types.push("bool");
		return new ObjectCode(
			"ldc.i4.1",
			"xor"
		).toString();
	}
}
