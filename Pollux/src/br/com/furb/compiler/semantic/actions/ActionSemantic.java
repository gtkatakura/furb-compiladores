package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public abstract class ActionSemantic {
	
	private SymbolTable symbolTable;
	
	public SymbolTable getSymbolTable() {
		return this.symbolTable;
	}
	
	public ActionSemantic(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}

	public abstract String execute(Token token);
}
