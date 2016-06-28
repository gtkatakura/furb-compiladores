package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class DefineRotuleSelection extends ActionSemantic {
	public DefineRotuleSelection(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		String rotule = this.getSymbolTable().createRotule();
		
		if (token.getLexeme().equals("isTrueDo")) {
			return "brfalse " + rotule + "\n";
		}
		
		return "brtrue " + rotule + "\n";
	}
}