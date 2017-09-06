package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import static br.com.furb.compiler.model.semantic.Type.INT;

public final class AllocateIntAction extends SemanticAction {

	public AllocateIntAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		this.getSymbolTable().getTypes().push(INT);
		return "ldc.i8 " + token.getLexeme() + "\n";
	}
}
