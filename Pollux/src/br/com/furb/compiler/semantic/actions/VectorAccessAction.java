package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class VectorAccessAction extends ActionSemantic {

	public VectorAccessAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getLastAllocated();
		return "ldloc " + identifier + "\n";
	}
}
