package br.com.furb.compiler.semantic;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

import br.com.furb.compiler.analysis.lexical.LexicalAnalyser;
import br.com.furb.compiler.analysis.lexical.LexicalError;
import br.com.furb.compiler.analysis.semantic.SemanticAnalyser;
import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.analysis.syntatic.SyntaticAnalyser;
import br.com.furb.compiler.analysis.syntatic.SyntaticError;

public class SemanticTest {
	
	public String verificaMensagemDeErro(String programaFonte) {
		try {
			LexicalAnalyser lexico = new LexicalAnalyser();
			SyntaticAnalyser sintatico = new SyntaticAnalyser();
			SemanticAnalyser semantico = new SemanticAnalyser();

			lexico.setInput(programaFonte);
			sintatico.parse(lexico, semantico);
			return null;
		} catch (SyntaticError | LexicalError | SemanticError error) {
			return error.getMessage();
		}
	}
	
	private void verificaMensagemDeErro(String[] programaFonte, String mensagemDeErroEsperado) {
		String mensagem = verificaMensagemDeErro(String.join("\n", programaFonte));
		assertEquals(mensagemDeErroEsperado, mensagem);
	}
	
	private String cabecalho() {
		String[] codigoObjeto = new String[] {
			".assembly extern mscorlib {}",
			".assembly codigo_objeto {}",
			".module codigo_objeto.exe",
			".class public _Principal {",
				".method static public void _principal() {",
				 	".entrypoint"
		};
		
		return String.join("\n", codigoObjeto);
	}
	
	private String rodape() {
		String[] codigoObjeto = new String[] {
					"ret",
			 	"}",
		 	"}"
		};
		
		return String.join("\n", codigoObjeto);
	}
	
	private void verificaCodigoGerado(String programaFonte, String codigoObjetoEsperado) throws LexicalError, SyntaticError, SemanticError {
		LexicalAnalyser lexico = new LexicalAnalyser();
		SyntaticAnalyser sintatico = new SyntaticAnalyser();
		SemanticAnalyser semantico = new SemanticAnalyser();

		lexico.setInput(programaFonte);
		sintatico.parse(lexico, semantico);
	
		String codigo = cabecalho() + "\n" + codigoObjetoEsperado + "\n" + rodape();
		assertEquals(codigo, semantico.getObjectCode());
//		criarArquivoTest(codigo);
	 }
		 
	private void criarArquivoTest(String codigo) {
		File cd = new File("C:\\temp\\");
		if(!cd.exists()){
			try {
				cd.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File[] b = cd.listFiles((FilenameFilter) (dir, name) -> name.contains("remove"));
		if(b != null || b.length > 0){
			
			for (File file : cd.listFiles()) {
				file.delete();
			}
		}
		b = cd.listFiles((FilenameFilter) (dir, name) -> name.contains("teste"));
		String name = cd.getAbsolutePath()+"\\teste"+b.length+".txt";
		try {
			PrintWriter writer = new PrintWriter(name);
			String[] cod = codigo.split("\n");
			writer.write(codigo);
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void verificaCodigoGerado(String[] programaFonte, String[] codigoObjetoEsperado) throws LexicalError, SyntaticError, SemanticError {
		verificaCodigoGerado(
			String.join("\n", programaFonte),
			String.join("\n", codigoObjetoEsperado)
		);
	}
	
	@Test
	public void testDeclaraIntSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 0;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro",
		 	"ldc.i8 0",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraIntSetaValorPositivado() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- +1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro",
		 	"ldc.i8 1",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraIntSetaValorNegativado() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- -1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro",
		 	"ldc.i8 1",
		 	"ldc.i8 -1",
		 	"mul",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraFloatSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 0,0;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.r8 0.0",
		 	"stloc f_primeiro",
		 	"ldc.r8 0.0",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraFloatSetaValorNegativado() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- -1,0;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.r8 0.0",
		 	"stloc f_primeiro",
		 	"ldc.r8 1.0",
		 	"ldc.i8 -1",
		 	"mul",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraStringSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro;",
			"{",
				"s_primeiro <- \"Primeiro\";",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (string s_primeiro)",
		 	"ldstr \"Primeiro\"",
		 	"stloc s_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testEscreveStringSetaValor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro, s_segundo;",
			"{",
				"s_primeiro <- \"Primeiro\";",
				"s_segundo <- \"Segundo\";",
				"out(s_primeiro, s_segundo);",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (string s_primeiro)",
		 	".locals (string s_segundo)",
		 	"ldstr \"Primeiro\"",
		 	"stloc s_primeiro",
		 	"ldstr \"Segundo\"",
		 	"stloc s_segundo",
		 	"ldloc s_primeiro",
		 	"call void [mscorlib]System.Console::Write(string)",
		 	"ldloc s_segundo",
		 	"call void [mscorlib]System.Console::Write(string)"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraBooleanoSetaTrue() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- true;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.1",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDeclaraBooleanoSetaFalse() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- false;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.0",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testNegacaoBooleana() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- not false;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.0",
		 	"ldc.i4.1",
		 	"xor",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorRelacionalAnd() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- true and true;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.1",
		 	"ldc.i4.1",
		 	"and",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorRelacionalPr() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- true or false;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i4.1",
		 	"ldc.i4.0",
		 	"or",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorIgualdade() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- 1 = 1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.i8 1",
		 	"ceq",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorDiferente() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- 1 != 1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i8 1",
		 	"ldc.i8 1",
		 	"ceq",
		 	"ldc.i4.1",
			"xor",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorMaiorQue() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- 2 > 1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i8 2",
		 	"ldc.i8 1",
		 	"cgt",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorMaiorQueOuIgual() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- 2 >= 1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i8 2",
		 	"ldc.i8 1",
		 	"clt",
		 	"ldc.i4.1",
		 	"xor",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorMenorQueOuIgual() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- 2 <= 1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i8 2",
		 	"ldc.i8 1",
		 	"cgt",
		 	"ldc.i4.1",
		 	"xor",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testOperadorMenorQue() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- 2 < 1;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (bool b_primeiro)",
		 	"ldc.i8 2",
		 	"ldc.i8 1",
		 	"clt",
		 	"stloc b_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testEstruturaSelecaoIf() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_xpto;",
			"{",
				"if (2 = 2) isTrueDo : {",
			    	"i_xpto <- 1;",
			  	"}",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
			".locals (int64 i_xpto)",
		 	"ldc.i8 0",
		 	"stloc i_xpto",
			"ldc.i8 2",
		 	"ldc.i8 2",
		 	"ceq",
		 	"brfalse R0",
		 	"ldc.i8 1",
		 	"stloc i_xpto",
		 	"R0:"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testEstruturaSelecaoIfComplexa() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_xpto, i_abc;",
			"{",
				"i_xpto <- 2;",
				"i_abc <- 2;",
				"if (i_xpto = i_abc) isTrueDo : {",
			    	"out(\"i_xpto = i_abc\");",
			  	"} isFalseDo : {",
			  		"if (i_xpto = 2) isTrueDo : {",
			  			"out(\"i_xpto = 2\");",
			    	"} isFalseDo : {",
			        	"out(\"i_xpto != 2\");",
			    	"}",
			  	"}",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
			".locals (int64 i_xpto)",
		 	"ldc.i8 0",
		 	"stloc i_xpto",
			".locals (int64 i_abc)",
		 	"ldc.i8 0",
		 	"stloc i_abc",
			"ldc.i8 2",
		 	"stloc i_xpto",
		 	"ldc.i8 2",
		 	"stloc i_abc",
		 	"ldloc i_xpto",
		 	"ldloc i_abc",
		 	"ceq",
		 	"brfalse R0",
		 	"ldstr \"i_xpto = i_abc\"",
		 	"call void [mscorlib]System.Console::Write(string)",
		 	"br R1",
		 	"R0:",
		 	"ldloc i_xpto",
		 	"ldc.i8 2",
		 	"ceq",
		 	"brfalse R2",
		 	"ldstr \"i_xpto = 2\"",
		 	"call void [mscorlib]System.Console::Write(string)",
		 	"br R3",
		 	"R2:",
		 	"ldstr \"i_xpto != 2\"",
		 	"call void [mscorlib]System.Console::Write(string)",
		 	"R3:",
		 	"R1:"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testEstruturaSelecaoWhile() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_xpto;",
			"{",
				"while (i_xpto = 2) isTrueDo : {",
			    	"i_xpto <- 1;",
			  	"}",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
			".locals (int64 i_xpto)",
		 	"ldc.i8 0",
		 	"stloc i_xpto",
			"R0:",
		 	"ldloc i_xpto",
			"ldc.i8 2",
		 	"ceq",
		 	"brfalse R1",
		 	"ldc.i8 1",
		 	"stloc i_xpto",
		 	"br R0",
		 	"R1:"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSomaConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1 + 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"add",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSomaVariaveis() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro, i_segundo;",
			"{",
				"i_primeiro <- 1;",
				"i_segundo <- i_primeiro + i_primeiro;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
			".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro",
			".locals (int64 i_segundo)",
		 	"ldc.i8 0",
		 	"stloc i_segundo",
		 	"ldc.i8 1",
		 	"stloc i_primeiro",
		 	"ldloc i_primeiro",
		 	"ldloc i_primeiro",
		 	"add",
		 	"stloc i_segundo"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSomaIntComFloat() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 1 + 2,5;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.r8 0.0",
		 	"stloc f_primeiro",
		 	"ldc.i8 1",
		 	"ldc.r8 2.5",
		 	"add",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testSubtraiConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1 - 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"sub",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testMultiplicaConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1 * 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (int64 i_primeiro)",
		 	"ldc.i8 0",
		 	"stloc i_primeiro",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"mul",
		 	"stloc i_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDivideConstantes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 1 / 2;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.r8 0.0",
		 	"stloc f_primeiro",
		 	"ldc.i8 1",
		 	"ldc.i8 2",
		 	"conv.r8",
		 	"div",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testDivideTiposDiferentes() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : f_primeiro;",
			"{",
				"f_primeiro <- 1 / 2,5;",
			"}"
		};
		
		String[] codigoObjeto = new String[] {
		 	".locals (float64 f_primeiro)",
		 	"ldc.r8 0.0",
		 	"stloc f_primeiro",
		 	"ldc.i8 1",
		 	"ldc.r8 2.5",
		 	"div",
		 	"stloc f_primeiro"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjeto);
	}
	
	@Test
	public void testNegativarString() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- -\"Palavra\";",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Operador '-' s� pode ser aplicado sobre operandos de tipo 'int' e 'float'");
	}
	
	@Test
	public void testPositivarString() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- +\"Palavra\";",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Operador '+' s� pode ser aplicado sobre operandos de tipo 'int' e 'float'");
	}
	
	@Test
	public void testPositivarIdentificadorString() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro, i_primeiro;",
			"{",
				"s_primeiro <- \"Palavra\";",
				"i_primeiro <- +s_primeiro;",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Operador '+' s� pode ser aplicado sobre operandos de tipo 'int' e 'float'");
	}
	
	@Test
	public void testPositivarIdentificadorStrin() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : s_primeiro, i_primeiro;",
			"{",
				"s_primeiro <- 1 / \"Palavra\";",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Operador '/' s� pode ser aplicado sobre operandos de tipo 'int' e/ou 'float'");
	}

	@Test
	public void testVariavelIntRecebeFloat() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_primeiro;",
			"{",
				"i_primeiro <- 1,5;",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Tipos incompat�veis em comando de atribui��o");
	}
	
	@Test
	public void testNegandoNaoBooleano() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- not 1,5;",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Operador 'not' s� pode ser aplicado sobre operandos de tipo 'bool'");
	}
	
	@Test
	public void testOperadorRelacionalDiferente() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : b_primeiro;",
			"{",
				"b_primeiro <- 1 = 1,5;",
			"}"
		};
		
		verificaMensagemDeErro(programaFonte, "Tipos incompat�veis em express�o relacional");
	}
	
	@Test
	public void testLeituraTipoInteiro() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
			"main module : i_lado;",
			"{",
				"out (\"input some value: \");",
				"in (i_lado);",
				"out(i_lado);" ,
			 "}"
		};
		
		String[] codigoGerado = new String[] {
			".locals (int64 i_lado)",
		 	"ldc.i8 0",
		 	"stloc i_lado",
			"ldstr \"input some value: \"",
			"call void [mscorlib]System.Console::Write(string)",
			"call string [mscorlib]System.Console::ReadLine()",
			"call int64 [mscorlib]System.Int64::Parse(string)",
			"stloc i_lado",
			"ldloc i_lado",
			"call void [mscorlib]System.Console::Write(int64)",
		};
		
		verificaCodigoGerado(programaFonte, codigoGerado);
	} 
	
	@Test
	public void testLeituraTipoString() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[] {
				"main module : s_desc;",
				"{",
					"out (\"desc: \");",
					"in (s_desc);",
				 "}"
			};
		
		String[] codigoGerado = new String[] {
				".locals (string s_desc)",
				"ldstr \"desc: \"",
				"call void [mscorlib]System.Console::Write(string)",
				"call string [mscorlib]System.Console::ReadLine()",
				"stloc s_desc"	
		};
		
		verificaCodigoGerado(programaFonte, codigoGerado);
	}
	
	@Test
	public void testDeclaracaoVetor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[]{
			"main module : i_CH [6];",
			"{",
				"out(\"...\");",
			"}"
		};
		
		String[] codigoObjetoEsperado = new String[] {
			".locals (int64[]  i_CH)",
			"ldc.i8 6",
			"newarr [mscorlib]System.Int64",
			"stloc i_CH",
			"ldstr \"...\"",
			"call void [mscorlib]System.Console::Write(string)",
		};
		verificaCodigoGerado(programaFonte, codigoObjetoEsperado);
	}
	
	@Test
	public void testAtribuicaoEmVetor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[]{
			"main module : i_CH [2];",
			"{",
				"i_CH [0] <- 10;",
			"}"
		};
		
		String[] codigoObjetoEsperado = new String[] {
			".locals (int64[]  i_CH)",
			"ldc.i8 2",
			"newarr [mscorlib]System.Int64",
			"stloc i_CH",
			"ldloc i_CH",
			"ldc.i8 0",
			"ldc.i8 10",
			"stelem int64"
		};
		verificaCodigoGerado(programaFonte, codigoObjetoEsperado);
	}
	
	@Test
	public void testUsoVetor() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[]{
			"main module : i_CH [2];",
			"{",
				"i_CH [0] <- 10;",
				"out(i_CH [0]);",
			"}"
		};
		
		String[] codigoObjetoEsperado = new String[] {
			".locals (int64[]  i_CH)",
			"ldc.i8 2",
			"newarr [mscorlib]System.Int64",
			"stloc i_CH",
			"ldloc i_CH",
			"ldc.i8 0",
			"ldc.i8 10",
			"stelem int64",
			"ldloc i_CH",
			"ldc.i8 0",
			"ldelem int64",
			"call void [mscorlib]System.Console::Write(int64)"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjetoEsperado);
	}
	
	@Test
	public void testAcessoVetorComIdentificador() throws LexicalError, SyntaticError, SemanticError {
		String[] programaFonte = new String[]{
			"main module : i_CH [3], i_value;",
			"{",
				"i_value <- 1;",
				"i_CH [i_value] <- 10;",
				"out(i_CH [i_value]);",
			"}"
		};
		
		String[] codigoObjetoEsperado = new String[] {
			".locals (int64[]  i_CH)",
			"ldc.i8 3",
			"newarr [mscorlib]System.Int64",
			"stloc i_CH",
			".locals (int64 i_value)",
		 	"ldc.i8 0",
		 	"stloc i_value",
			"ldc.i8 1",
			"stloc i_value",
			"ldloc i_CH",
			"ldloc i_value",
			"ldc.i8 10",
			"stelem int64",
			"ldloc i_CH",
			"ldloc i_value",
			"ldelem int64",
			"call void [mscorlib]System.Console::Write(int64)"
		};
		
		verificaCodigoGerado(programaFonte, codigoObjetoEsperado);
	}
}