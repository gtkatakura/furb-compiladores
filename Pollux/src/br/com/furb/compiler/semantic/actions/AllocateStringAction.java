package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateStringAction extends ActionSemantic {
	public AllocateStringAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		this.getSymbolTable().getTypes().push("string");
		return "ldstr " + token.getLexeme();
	}
}
