package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class FooterAction extends SemanticAction {
	public FooterAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		return (
					"ret\n" +
				"}\n" +
			"}"
		);
	}
}
