package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateFalseAction extends AllocateBooleanAction {
	public AllocateFalseAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		super.execute(token);
		return "ldc.i4.0\n";
	}
}
