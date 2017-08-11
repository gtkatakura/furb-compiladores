package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.model.semantic.SymbolTable;

public final class SemanticActionFactory {

	public static SemanticAction create(int id, SymbolTable symbolTable) {
		return SemanticActions.find(id).map(action -> action.build(symbolTable)) //
				.orElse(null);
	}
}
