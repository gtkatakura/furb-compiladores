package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class StoreValueInVariable extends ActionSemantic {
	public StoreValueInVariable(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		Identifier identifier = this.getSymbolTable().getIdentifier();
		return "stloc " + identifier + "\n";
	}

}
