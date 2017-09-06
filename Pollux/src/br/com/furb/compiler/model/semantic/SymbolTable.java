package br.com.furb.compiler.model.semantic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {

	private final Stack<Identifier> stackIdentifiers;
	private final Map<String, Identifier> identifiers;
	private final Stack<Type> types;
	private final Stack<String> relationalOperators;
	private final Stack<String> rotules;

	private int lastRotule = 0;

	public SymbolTable() {
		this.stackIdentifiers = new Stack<>();
		this.identifiers = new HashMap<>();
		this.types = new Stack<>();
		this.relationalOperators = new Stack<>();
		this.rotules = new Stack<>();
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

	public Stack<Type> getTypes() {
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
