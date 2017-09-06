package br.com.furb.compiler.semantic.actions;

import static br.com.furb.compiler.model.semantic.Type.FLOAT;
import static br.com.furb.compiler.model.semantic.Type.INT;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.model.semantic.Type;;

public abstract class BinaryOperatorAction extends SemanticAction {

	private final char operator;

	public BinaryOperatorAction(SymbolTable symbolTable, char operator) {
		super(symbolTable);
		this.operator = operator;
	}

	public String execute(Token token) throws SemanticError {
		Stack<Type> types = this.getSymbolTable().getTypes();
		Type type1 = types.pop();
		Type type2 = types.pop();

		if (!isTypeValid(type1) || !isTypeValid(type2)) {
			throw new SemanticError(
					"Operador '" + this.operator + "' só pode ser aplicado sobre operandos de tipo 'int' e/ou 'float'",
					token.getPosition());
		}

		if (type1 == FLOAT || type2 == FLOAT) {
			types.push(FLOAT);
		} else {
			types.push(INT);
		}
		return null;
	}

	private boolean isTypeValid(Type type) {
		return type == FLOAT || type == INT;
	}
}
