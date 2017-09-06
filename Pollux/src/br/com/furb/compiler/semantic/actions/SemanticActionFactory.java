package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.semantic.SymbolTable;

public final class SemanticActionFactory {
	private SymbolTable symbolTable;
	
	public SemanticActionFactory(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}
	
	public SemanticAction create(int id) {
		return SemanticActions.find(id)
			.map(action -> action.build(this.symbolTable))
			.orElse(new BlankAction(this.symbolTable));
	}
}
