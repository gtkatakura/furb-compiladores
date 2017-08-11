package br.com.furb.compiler.lexical.impl.gals;

import java.util.Arrays;

import br.com.furb.compiler.lexical.IKind;

public enum EKind implements IKind {
	DOLLAR(1, "s�mbolo especial"),
	VIRGULA(2, "s�mbolo especial"),
	DOIS_PONTOS(3, "s�mbolo especial"),
	PONTO_E_VIRGULA(4, "s�mbolo especial"),
	ABRE_COLCHETES(5, "s�mbolo especial"),
	FECHA_COLCHETES(6, "s�mbolo especial"),
	ABRE_PARENTESES(7, "s�mbolo especial"),
	FECHA_PARENTESES(8, "s�mbolo especial"),
	ABRE_CHAVES(9, "s�mbolo especial"),
	FECHA_CHAVES(10, "s�mbolo especial"),
	MAIS(11, "s�mbolo especial"),
	MENOS(12, "s�mbolo especial"),
	ASTERISCO(13, "s�mbolo especial"),
	BARRA(14, "s�mbolo especial"),
	ATRIBUIR(15, "s�mbolo especial"),
	IGUAL(16, "s�mbolo especial"),
	DIFERENTE(17, "s�mbolo especial"),
	MENOR(18, "s�mbolo especial"),
	MENORIGUAL(19, "s�mbolo especial"),
	MAIOR(20, "s�mbolo especial"),
	MAIORIGUAL(21, "s�mbolo especial"),
	PALAVRA_RESERVADA(22, "palavra reservada inv�lida"),
	IDENTIFICADOR_DE_INT(23, "identificador"),
	IDENTIFICADOR_DE_FLOAT(24, "identificador"),
	IDENTIFICADOR_DE_STRING(25, "identificador"),
	IDENTIFICADOR_DE_BOOL(26, "identificador"),
	CONSTANTE_INT(27, "constante int"),
	CONSTANTE_FLOAT(28, "constante float"),
	CONSTANTE_STRING(29, "constante string"),
	AND(30, "palavra reservada"),
	FALSE(31, "palavra reservada"),
	IF(32, "palavra reservada"),
	IN(33, "palavra reservada"),
	ISFALSEDO(34, "palavra reservada"),
	ISTRUEDO(35, "palavra reservada"),
	MAIN(36, "palavra reservada"),
	MODULE(37, "palavra reservada"),
	NOT(38, "palavra reservada"),
	OR(39, "palavra reservada"),
	OUT(40, "palavra reservada"),
	TRUE(41, "palavra reservada"),
	WHILE(42, "palavra reservada");
	
	private int id;
	private String descricao;
	
	private EKind(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId(){
		return id;
	}

	public String getDescription(){
		return descricao;
	}

	public static EKind getClasseById(int id){
		return Arrays.asList(EKind.values()).stream()
			.filter(classe -> classe.getId() == id)
			.findFirst()
			.get();
	}
	

}