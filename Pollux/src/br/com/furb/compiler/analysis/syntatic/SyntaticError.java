package br.com.furb.compiler.analysis.syntatic;

import br.com.furb.compiler.lexical.impl.gals.AnalysisError;

public class SyntaticError extends AnalysisError {

	private static final long serialVersionUID = 1L;

	public SyntaticError(String msg, int position) {
		super(msg, position);
	}

	public SyntaticError(String msg) {
		super(msg);
	}
}
