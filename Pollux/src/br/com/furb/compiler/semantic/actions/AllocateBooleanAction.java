package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public abstract class AllocateBooleanAction extends SemanticAction {
	public AllocateBooleanAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		this.getSymbolTable().getTypes().push("bool");
		return null;
	}
}