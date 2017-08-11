package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.Identifier;
import br.com.furb.compiler.model.semantic.SymbolTable;

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
