package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.ObjectCode;
import br.com.furb.compiler.semantic.SymbolTable;

public class FooterAction extends ActionSemantic {
	public FooterAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		return new ObjectCode(
					"ret",
				"}",
			"}"
		).toString();
	}
}
