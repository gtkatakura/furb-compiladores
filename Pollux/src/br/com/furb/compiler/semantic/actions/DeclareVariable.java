package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class DeclareVariable extends ActionSemantic {
	public DeclareVariable(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		Identifier identifier = this.getSymbolTable().getIdentifier();
		return ".locals (" + identifier.getType() + " " + identifier + ")\n";
	}
}
