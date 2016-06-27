package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateIdentifier extends ActionSemantic {
	public AllocateIdentifier(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		SymbolTable symbolTable = this.getSymbolTable();
		Identifier identifier = new Identifier(token.getLexeme());

		symbolTable.getIdentifiers().push(identifier);
		symbolTable.getTypes().push(identifier.getType());
		return null;
	}

}
