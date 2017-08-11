package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class EndSelectionAction extends SemanticAction {
	public EndSelectionAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		String rotule = this.getSymbolTable().getRotules().pop();
		
		return rotule + ":\n";
	}
}