package br.com.furb.compiler.semantic.actions;

import java.util.Stack;

import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.lexical.Token;
import br.com.furb.compiler.semantic.SymbolTable;

public class RelationalOperatorAction extends SemanticAction {
	public RelationalOperatorAction(SymbolTable symbolTable) {
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
				"Tipos incompat�veis em express�o relacional",
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