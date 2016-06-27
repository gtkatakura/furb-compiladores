package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateIdentifierAction extends ActionSemantic {
	public AllocateIdentifierAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		Identifier identifier = this.getSymbolTable().getIdentifiers().pop();
		this.getSymbolTable().getTypes().push(identifier.getType());
		return "ldloc " + identifier + "\n";
	}

}
