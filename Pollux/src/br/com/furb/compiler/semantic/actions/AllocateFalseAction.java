package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateFalseAction extends AllocateBooleanAction {
	public AllocateFalseAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		super.execute(token);
		return "ldc.i4.0";
	}
}
