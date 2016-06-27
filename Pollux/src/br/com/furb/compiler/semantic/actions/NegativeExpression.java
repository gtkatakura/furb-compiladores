package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class NegativeExpression extends ActionSemantic {
	public NegativeExpression(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		Stack<String> types = this.getSymbolTable().getTypes();
		String type = types.pop();
		
		if (type != "bool") {
			throw new SemanticError(
				"Operador Un�rio (not) s� aceita express�es booleanas.",
				token.getPosition()
			);
		}
		
		types.push("bool");
		return "ldc.i4.1 xor\n";
	}
}
