package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateStringAction extends SemanticAction {
	public AllocateStringAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		this.getSymbolTable().getTypes().push("string");
		return "ldstr " + token.getLexeme() + "\n";
	}
}
