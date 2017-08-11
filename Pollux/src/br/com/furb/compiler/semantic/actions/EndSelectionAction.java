package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class EndSelectionAction extends SemanticAction {
	public EndSelectionAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		String rotule = this.getSymbolTable().getRotules().pop();
		
		return rotule + ":\n";
	}
}