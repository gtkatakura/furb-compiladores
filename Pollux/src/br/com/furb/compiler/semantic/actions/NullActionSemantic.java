package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class NullActionSemantic extends ActionSemantic {
	public NullActionSemantic(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		return null;
	}

}
