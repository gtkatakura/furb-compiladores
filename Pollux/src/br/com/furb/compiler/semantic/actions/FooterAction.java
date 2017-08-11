package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public class FooterAction extends SemanticAction {
	public FooterAction(SymbolTable symbolTable) {
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
