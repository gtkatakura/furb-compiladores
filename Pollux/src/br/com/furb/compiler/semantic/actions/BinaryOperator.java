package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public abstract class BinaryOperator extends ActionSemantic {
	public BinaryOperator(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		Stack<String> types = this.getSymbolTable().getTypes();
		String type1 = types.pop();
		String type2 = types.pop();
		
		if (!isTypeValid(type1) || !isTypeValid(type2)) {
			throw new SemanticError(
				"Operadores Binários só aceitam operandos do tipo int e/ou float.",
				token.getPosition()
			);
		}

		if (type1 == "float64" || type2 == "float64") {
			types.push("float64");
		} else {
			types.push("int64");
		}

		return null;
	}
	
	private boolean isTypeValid(String type) {
		return type == "float64" || type == "int64";
	}
}

