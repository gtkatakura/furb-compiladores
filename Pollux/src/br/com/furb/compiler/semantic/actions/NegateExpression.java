package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class NegateExpression extends ActionSemantic {
	public NegateExpression(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		String type = this.getSymbolTable().getTypes().lastElement();
		
		if (type != "float64" && type != "int64") {
			throw new SemanticError(
				"O Operador Un�rio (-) s� aceita os tipos int e float.",
				token.getPosition()
			);
		}
		
		return (
			"ldc.i8 -1\n" +
			"mul\n"
		);
	}
}
