package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.lexical.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class AllocateVectorSizeAction extends SemanticAction {

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
