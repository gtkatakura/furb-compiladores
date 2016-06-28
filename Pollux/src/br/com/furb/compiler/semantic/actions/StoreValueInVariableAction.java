package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class StoreValueInVariableAction extends ActionSemantic {
	public StoreValueInVariableAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		Identifier identifier = this.getSymbolTable().getStackIdentifiers().pop();
		String type = this.getSymbolTable().getTypes().pop();
		
		if (identifier.getType() != type) {
			throw new SemanticError(
				"Tipos incompatíveis em comando de atribuição",
				token.getPosition()
			);
		}

		return "stloc " + identifier + "\n";
	}

}
