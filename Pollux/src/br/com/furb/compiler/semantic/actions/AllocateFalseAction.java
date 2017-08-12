package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class AllocateFalseAction extends AllocateBooleanAction {
	public AllocateFalseAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		super.execute(token);
		return "ldc.i4.0\n";
	}
}
