package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class LogicalNegationOperatorAction extends SemanticAction {
	public LogicalNegationOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) throws SemanticError {
		Stack<String> types = this.getSymbolTable().getTypes();
		String type = types.pop();
		
		if (type != "bool") {
			throw new SemanticError(
				"Operador 'not' s� pode ser aplicado sobre operandos de tipo 'bool'",
				token.getPosition()
			);
		}
		
		types.push("bool");
		return (
			"ldc.i4.1\n" +
			"xor\n"
		);
	}
}
