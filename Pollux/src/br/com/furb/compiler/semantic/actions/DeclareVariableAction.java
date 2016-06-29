package br.com.furb.compiler.semantic.actions;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.Identifier;
import br.com.furb.compiler.semantic.SymbolTable;

public class DeclareVariableAction extends ActionSemantic {
	public DeclareVariableAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	public String execute(Token token) throws SemanticError {
		SymbolTable symbolTable = this.getSymbolTable();
		Identifier identifier = symbolTable.getStackIdentifiers().pop();
		
		if (symbolTable.getIdentifiers().containsKey(identifier.toString())) {
			throw new SemanticError(
				identifier.toString() + " j� declarado",
				token.getPosition()
			);
		}

		symbolTable.getIdentifiers().put(identifier.toString(), identifier);
		return ".locals (" + identifier.getTypeDescription() + " " + identifier + ")\n";
	}
}
