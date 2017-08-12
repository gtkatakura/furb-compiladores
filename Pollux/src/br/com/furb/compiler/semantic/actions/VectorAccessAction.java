package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.Identifier;
import br.com.furb.compiler.model.semantic.SymbolTable;

public final class VectorAccessAction extends SemanticAction {

	public VectorAccessAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getLastAllocated();
		return "ldloc " + identifier + "\n";
	}
}
