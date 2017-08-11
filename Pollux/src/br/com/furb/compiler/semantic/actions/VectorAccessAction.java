package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.TokenImpl;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class VectorAccessAction extends SemanticAction {

	public VectorAccessAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(TokenImpl token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getLastAllocated();
		return "ldloc " + identifier + "\n";
	}
}
