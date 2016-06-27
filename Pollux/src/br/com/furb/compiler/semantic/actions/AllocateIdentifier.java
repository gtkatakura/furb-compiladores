package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateIdentifier extends ActionSemantic {
	public AllocateIdentifier(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		this.getSymbolTable().setIdentifier(token.getLexeme());
		return null;
	}

}
