package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class PushIdentifierAction extends SemanticAction {
	public PushIdentifierAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) {
		String lexeme = token.getLexeme();
		Identifier identifier = getSymbolTable().getIdentifiers().get(lexeme);

		if (identifier == null) {
			identifier = new Identifier(lexeme);
		}

		this.getSymbolTable().getStackIdentifiers().push(identifier);
		return null;
	}
}
