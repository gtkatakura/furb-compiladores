package br.com.furb.compiler.syntactic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.furb.compiler.analysis.lexical.AnalysisError;
import br.com.furb.compiler.analysis.lexical.LexicalAnalyser;
import br.com.furb.compiler.analysis.semantic.SemanticAnalyser;
import br.com.furb.compiler.analysis.syntatic.SyntaticAnalyser;

public class SyntaticTest {

	public String getErrorMessage(String input) {
		try {
			LexicalAnalyser lexico = new LexicalAnalyser();
			SyntaticAnalyser sintatico = new SyntaticAnalyser();
			SemanticAnalyser semantico = new SemanticAnalyser();

			lexico.setInput(input);
			sintatico.parse(lexico, semantico);
			return null;
		} catch (AnalysisError error) {
			return error.getMessage();
		}
	}

	@Test
	public void testConstanteStringInvalida() {
		String input = ("main module\n" + "{\n" + "out (\"digite um valor para lado: );\n" + "in (i_lado)\n"
				+ "i_area <- i_lado * i_lado;\n" + "out (i_area);\n" + "}");

		String result = this.getErrorMessage(input);
		assertEquals(result, "Erro na linha 3 - constante string inv�lida");
	}

	@Test
	public void testEsperadoPontoVirgula() {
		String input = ("main module\n" + "{\n" + "out (\"digite um valor para lado: \");\n" + "in (i_lado)\n"
				+ "i_area <- i_lado * i_lado;\n" + "out (i_area);\n" + "}");

		String message = this.getErrorMessage(input);
		assertEquals(message, "Erro na linha 5 - encontrado i_area esperado ;");
	}

	@Test
	public void testEsperadoIdentificador() {
		String input = ("main module {\ni_teste <- i_teste2;");

		String message = this.getErrorMessage(input);
		System.out.println(message);
		assertEquals(message, "Erro na linha 1 - encontrado ; esperado identificador");
	}

}
