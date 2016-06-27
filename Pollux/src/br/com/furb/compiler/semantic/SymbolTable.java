package br.com.furb.compiler.semantic;

import java.util.Stack;

public class SymbolTable {
	private Stack<Identifier> identifiers;
	private Stack<String> types;
	private Stack<String> relationalOperators;
	
	public SymbolTable() {
		this.identifiers = new Stack<Identifier>();
		this.types = new Stack<String>();
		this.relationalOperators = new Stack<String>();
	}
	
	public Stack<Identifier> getIdentifiers() {
		return this.identifiers;
	}
	
	public Stack<String> getTypes() {
		return this.types;
	}
	
	public Stack<String> getRelationalOperators() {
		return this.relationalOperators;
	}
}
