package br.com.furb.compiler.model.semantic;

public enum Type {
	INT("int64"),
	FLOAT("float64", "Double"),
	STRING("string"),
	BOOLEAN("bool", "Boolean");

	private final String primitiveName;
	private final CorrespondingClass correspondingClass;

	private Type(String primitiveName) {
		this(primitiveName, new CorrespondingClass(primitiveName));
	}
	
	private Type(String primitiveName, String correspondingClass) {
		this(primitiveName, new CorrespondingClass(correspondingClass));
	}
	
	private Type(String primitiveName, CorrespondingClass correspondingClass) {
		this.primitiveName = primitiveName;
		this.correspondingClass = correspondingClass;
	}
	
	public String getPrimitiveName() {
		return this.primitiveName;
	}

	public CorrespondingClass getCorrespondingClass() {
		return this.correspondingClass;
	}
}
