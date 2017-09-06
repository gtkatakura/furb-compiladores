package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import static br.com.furb.compiler.model.semantic.Type.BOOLEAN;

public abstract class AllocateBooleanAction extends SemanticAction {
	public AllocateBooleanAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		this.getSymbolTable().getTypes().push(BOOLEAN);
		return null;
	}
}