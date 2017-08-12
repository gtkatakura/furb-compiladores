package br.com.furb.compiler.semantic.actions;

import static br.com.furb.compiler.model.semantic.Type.FLOAT;
import static br.com.furb.compiler.model.semantic.Type.INT;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;;

public abstract class BinaryOperatorAction extends SemanticAction {

	private final char operator;

	public BinaryOperatorAction(SymbolTable symbolTable, char operator) {
		super(symbolTable);
		this.operator = operator;
	}

	public String execute(Token token) throws SemanticError {
		Stack<String> types = this.getSymbolTable().getTypes();
		String type1 = types.pop();
		String type2 = types.pop();

		if (!isTypeValid(type1) || !isTypeValid(type2)) {
			throw new SemanticError(
					"Operador '" + this.operator + "' só pode ser aplicado sobre operandos de tipo 'int' e/ou 'float'",
					token.getPosition());
		}

		if (type1 == FLOAT.value || type2 == FLOAT.value) {
			types.push(FLOAT.value);
		} else {
			types.push(INT.value);
		}
		return null;
	}

	private boolean isTypeValid(String type) {
		return type == FLOAT.value || type == INT.value;
	}
}
