package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.model.semantic.Type;
import static br.com.furb.compiler.model.semantic.Type.BOOLEAN;

public final class LogicalNegationOperatorAction extends SemanticAction {
	
	public LogicalNegationOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		Stack<Type> types = this.getSymbolTable().getTypes();
		Type type = types.pop();
		
		if (type != BOOLEAN) {
			throw new SemanticError(
				"Operador 'not' s� pode ser aplicado sobre operandos de tipo 'bool'",
				token.getPosition()
			);
		}
		
		types.push(BOOLEAN);
		return (
			"ldc.i4.1\n" +
			"xor\n"
		);
	}
}
