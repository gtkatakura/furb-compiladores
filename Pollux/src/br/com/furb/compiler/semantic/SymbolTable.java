package br.com.furb.compiler.semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	private Stack<Identifier> stackIdentifiers;
	private Map<String, Identifier> identifiers;
	private Stack<String> types;
	private Stack<String> relationalOperators;
	private Stack<String> rotules;
	private int lastRotule = 0;

	public SymbolTable() {
		this.stackIdentifiers = new Stack<Identifier>();
		this.identifiers = new HashMap<String, Identifier>();
		this.types = new Stack<String>();
		this.relationalOperators = new Stack<String>();
		this.rotules = new Stack<String>();
	}

	public Stack<Identifier> getStackIdentifiers() {
		return this.stackIdentifiers;
	}

	public Identifier getLastAllocated() {
		return getStackIdentifiers().peek();
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

	public Stack<String> getRotules() {
		return this.rotules;
	}

	public String createRotule() {
		String rotule = "R" + this.lastRotule;
		this.rotules.push(rotule);
		lastRotule++;
		return rotule;
	}
}
