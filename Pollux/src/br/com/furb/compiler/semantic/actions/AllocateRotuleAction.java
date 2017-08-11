package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;

public class AllocateRotuleAction extends SemanticAction {
	public AllocateRotuleAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		String rotule = this.getSymbolTable().createRotule();
		return rotule + ":\n";
	}
}