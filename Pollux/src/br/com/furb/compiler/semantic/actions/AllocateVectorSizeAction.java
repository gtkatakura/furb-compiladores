package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateVectorSizeAction extends ActionSemantic {

	public AllocateVectorSizeAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		int size = Integer.parseInt(token.getLexeme());
		Identifier identifier = getSymbolTable().getLastAllocated();
		identifier.setSize(size);
		return null;
	}
}
