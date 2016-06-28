package br.com.furb.compiler.syntactic;

import br.com.furb.compiler.lexical.impl.gals.AnalysisError;

public class SyntaticError extends AnalysisError
{
    public SyntaticError(String msg, int position)
	 {
        super(msg, position);
    }

    public SyntaticError(String msg)
    {
        super(msg);
    }
}
