package br.com.furb.compiler.semantic;

public enum Type {

	INT("int64"), //

	FLOAT("float64") {

		@Override
		public String getCorrespondingClass() {
			return "Double";
		}

	}, //

	STRING("string"), //

	BOOLEAN("bool") {

		@Override
		public String getCorrespondingClass() {
			return "Boolean";
		}

	};

	private final String description;

	private Type(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getCorrespondingClass() {
		return capitalize(description) + lowerCharsFrom(1, description);
	}

	private String capitalize(String value) {
		return String.valueOf(value.charAt(0)).toUpperCase();
	}

	private String lowerCharsFrom(int index, String value) {
		return value.substring(index).toLowerCase();
	}
}
