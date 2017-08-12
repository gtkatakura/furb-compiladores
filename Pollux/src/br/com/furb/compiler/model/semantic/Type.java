package br.com.furb.compiler.model.semantic;

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

	public final String value;

	private Type(String value) {
		this.value = value;
	}

	public String getCorrespondingClass() {
		return capitalize(value) + lowerCharsFrom(1, value);
	}

	private String capitalize(String value) {
		return String.valueOf(value.charAt(0)).toUpperCase();
	}

	private String lowerCharsFrom(int index, String value) {
		return value.substring(index).toLowerCase();
	}
}
