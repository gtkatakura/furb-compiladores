package br.com.furb.compiler.semantic;

import java.util.Stack;

public class SymbolTable {
	private Identifier identifier;
	private Stack<String> types;
	
	public SymbolTable() {
		this.types = new Stack<String>();
	}
	
	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public Stack<String> getTypes() {
		return this.types;
	}
}
