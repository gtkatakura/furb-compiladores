package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public abstract class SemanticAction {

	private SymbolTable symbolTable;

	public SymbolTable getSymbolTable() {
		return this.symbolTable;
	}

	public SemanticAction(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}

	public abstract String execute(TokenImpl token) throws SemanticError;
}
