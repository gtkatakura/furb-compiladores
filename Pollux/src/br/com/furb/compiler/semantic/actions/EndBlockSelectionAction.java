package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class EndBlockSelectionAction extends SemanticAction {
	public EndBlockSelectionAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		String rotule = this.getSymbolTable().getRotules().pop();
		String brRotule = this.getSymbolTable().createRotule();
		
		return (
			"br " + brRotule + "\n" +
		 	rotule + ":\n"
	 	);
	}
}