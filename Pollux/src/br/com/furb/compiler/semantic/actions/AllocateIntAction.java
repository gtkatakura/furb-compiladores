package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public class AllocateIntAction extends SemanticAction {
	public AllocateIntAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) {
		this.getSymbolTable().getTypes().push("int64");
		return "ldc.i8 " + token.getLexeme() + "\n";
	}
}
