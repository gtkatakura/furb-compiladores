package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class RelationalOperation extends ActionSemantic {
	public RelationalOperation(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		SymbolTable symbolTable = this.getSymbolTable();
		Stack<String> types = symbolTable.getTypes();
		String type1 = types.pop();
		String type2 = types.pop();
		
		if (type1 != type2) {
			throw new SemanticError(
				"Tipos incompatíveis em expressão relacional",
				token.getPosition()
			);
		}
		
		types.push("bool");
		
		switch (symbolTable.getRelationalOperators().pop()) {
		case "=":
			return "ceq\n";
		case ">":
			return "cgt\n";
		case "<":
			return "clt\n";
		}

		return null;
	}

}