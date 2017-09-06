package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.Identifier;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.model.semantic.Type;

public final class StoreValueInVariableAction extends SemanticAction {
	
	public StoreValueInVariableAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getStackIdentifiers().pop();
		Type type = this.getSymbolTable().getTypes().pop();

		if (!this.getSymbolTable().getIdentifiers().containsKey(identifier.toString())) {
			throw new SemanticError(identifier.toString() + " n�o declarado", token.getPosition());
		}

		if (identifier.getType() != type) {
			throw new SemanticError("Tipos incompat�veis em comando de atribui��o", token.getPosition());
		}

		if (identifier.isVector()) {
			return "stelem " + identifier.getTypeDescription() + "\n";
		}

		return "stloc " + identifier + "\n";
	}
}
