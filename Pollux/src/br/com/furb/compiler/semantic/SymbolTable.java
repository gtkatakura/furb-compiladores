package br.com.furb.compiler.semantic;

import java.util.Stack;

public class SymbolTable {
	private Stack<Identifier> identifiers;
	private Stack<String> types;
	
	public SymbolTable() {
		this.identifiers = new Stack<Identifier>();
		this.types = new Stack<String>();
	}
	
	public Stack<Identifier> getIdentifiers() {
		return this.identifiers;
	}
	
	public Stack<String> getTypes() {
		return this.types;
	}
}
