package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateRotuleAction extends SemanticAction {
	public AllocateRotuleAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) throws SemanticError {
		String rotule = this.getSymbolTable().createRotule();
		return rotule + ":\n";
	}
}