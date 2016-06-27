package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class UnaryNegationOperator extends ActionSemantic {
	public UnaryNegationOperator(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		String type = this.getSymbolTable().getTypes().lastElement();
		
		if (type != "float64" && type != "int64") {
			throw new SemanticError(
				"Operador '-' só pode ser aplicado sobre operandos de tipo 'int' e 'float'.",
				token.getPosition()
			);
		}
		
		return (
			"ldc.i8 -1\n" +
			"mul\n"
		);
	}
}
