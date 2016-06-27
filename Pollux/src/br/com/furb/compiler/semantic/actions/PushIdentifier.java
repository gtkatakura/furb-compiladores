package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class PushIdentifier extends ActionSemantic {
	public PushIdentifier(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		Identifier identifier = new Identifier(token.getLexeme());
		this.getSymbolTable().getIdentifiers().push(identifier);
		return null;
	}

}
