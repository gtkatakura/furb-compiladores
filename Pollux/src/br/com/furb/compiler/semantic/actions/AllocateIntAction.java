package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.TokenImpl;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateIntAction extends SemanticAction {
	public AllocateIntAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(TokenImpl token) {
		this.getSymbolTable().getTypes().push("int64");
		return "ldc.i8 " + token.getLexeme() + "\n";
	}
}
