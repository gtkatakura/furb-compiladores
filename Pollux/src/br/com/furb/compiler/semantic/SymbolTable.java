package br.com.furb.compiler.semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	private Stack<Identifier> stackIdentifiers;
	private Map<String, Identifier> identifiers;
	private Stack<String> types;
	private Stack<String> relationalOperators;
	
	public SymbolTable() {
		this.stackIdentifiers = new Stack<Identifier>();
		this.identifiers = new HashMap<String, Identifier>();
		this.types = new Stack<String>();
		this.relationalOperators = new Stack<String>();
	}
	
	public Stack<Identifier> getStackIdentifiers() {
		return this.stackIdentifiers;
	}
	
	public Map<String, Identifier> getIdentifiers() {
		return this.identifiers;
	}
	
	public Stack<String> getTypes() {
		return this.types;
	}
	
	public Stack<String> getRelationalOperators() {
		return this.relationalOperators;
	}
}
