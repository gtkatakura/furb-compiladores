package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class NegativeExpression extends ActionSemantic {
	public NegativeExpression(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		String type = this.getSymbolTable().getTypes().lastElement();
		
		if (type != "float64" && type != "int64") {
			throw new SemanticError(
				"O Operador Unário (-) só aceita os tipos int e float.",
				token.getPosition()
			);
		}
		
		return (
			"ldc.i8 -1\n" +
			"mul\n"
		);
	}
}
