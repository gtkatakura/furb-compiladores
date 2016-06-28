package br.com.furb.compiler.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.furb.compiler.semantic.SemanticTest;
import br.com.furb.compiler.syntactic.SyntaticTest;

/**
 * Agrupador de testes do compilador 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ //
		SemanticTest.class, //
		SyntaticTest.class //
})
public class CompilerAllTests {

}
