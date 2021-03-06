package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import static br.com.furb.compiler.model.semantic.Type.STRING;

public final class AllocateStringAction extends SemanticAction {
	
	public AllocateStringAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		this.getSymbolTable().getTypes().push(STRING);
		return "ldstr " + token.getLexeme() + "\n";
	}
}
