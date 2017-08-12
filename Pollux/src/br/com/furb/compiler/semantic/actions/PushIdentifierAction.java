package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.Identifier;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class PushIdentifierAction extends SemanticAction {

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
