package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public abstract class AllocateBooleanAction extends SemanticAction {
	public AllocateBooleanAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		this.getSymbolTable().getTypes().push("bool");
		return null;
	}
}