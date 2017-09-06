package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.model.lexical.Token;
import br.com.furb.compiler.model.semantic.SymbolTable;
import br.com.furb.compiler.model.semantic.Type;
import static br.com.furb.compiler.model.semantic.Type.BOOLEAN;

public final class RelationalOperatorAction extends SemanticAction {
	
	public RelationalOperatorAction(SymbolTable symbolTable) {
		super(symbolTable);
	}

	@Override
	public String execute(Token token) throws SemanticError {
		SymbolTable symbolTable = this.getSymbolTable();
		Stack<Type> types = symbolTable.getTypes();
		Type type1 = types.pop();
		Type type2 = types.pop();
		
		if (type1 != type2) {
			throw new SemanticError(
				"Tipos incompat�veis em express�o relacional",
				token.getPosition()
			);
		}
		
		types.push(BOOLEAN);
		
		switch (symbolTable.getRelationalOperators().pop()) {
		case "=":
			return "ceq\n";
		case ">":
			return "cgt\n";
		case "<":
			return "clt\n";
		case "!=":
			return (
				"ceq\n" +
				"ldc.i4.1\n" +
		 		"xor\n"
			);
		case ">=":
			return (
			 	"clt\n" +
			 	"ldc.i4.1\n" +
				"xor\n"
		 	);
		case "<=":
			return (
			 	"cgt\n" +
			 	"ldc.i4.1\n" +
				"xor\n"
		 	);
		}

		return null;
	}

}