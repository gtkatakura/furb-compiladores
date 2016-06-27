package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateTrueAction extends AllocateBooleanAction {
	public AllocateTrueAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		super.execute(token);
		return "ldc.i4.1\n";
	}
}
