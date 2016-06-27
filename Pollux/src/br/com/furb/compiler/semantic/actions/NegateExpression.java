package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class NegateExpression extends ActionSemantic {
	public NegateExpression(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		return (
			"ldc.i8 -1\n" +
			"mul\n"
		);
	}
}
