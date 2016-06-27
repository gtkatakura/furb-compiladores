package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class FooterCode extends ActionSemantic {
	public FooterCode(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		return (
					"ret\n" +
				"}\n" +
			"}"
		);
	}
}