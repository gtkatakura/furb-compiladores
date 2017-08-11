package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class EndBlockRepetitionAction extends SemanticAction {
	public EndBlockRepetitionAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		String rotule = this.getSymbolTable().getRotules().pop();
		String brRotule = this.getSymbolTable().getRotules().pop();
		
		return (
			"br " + brRotule + "\n" +
		 	rotule + ":\n"
	 	);
	}
}