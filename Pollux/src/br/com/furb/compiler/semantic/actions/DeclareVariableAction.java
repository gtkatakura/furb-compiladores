package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class DeclareVariableAction extends ActionSemantic {
	public DeclareVariableAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		Identifier identifier = this.getSymbolTable().getIdentifiers().pop();
		return ".locals (" + identifier.getType() + " " + identifier + ")\n";
	}
}
