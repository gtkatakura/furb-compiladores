package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class EndSelectionAction extends ActionSemantic {
	public EndSelectionAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		String rotule = this.getSymbolTable().getRotules().pop();
		
		return rotule + ":";
	}
}