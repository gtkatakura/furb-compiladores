package br.com.furb.compiler.semantic.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import br.com.furb.compiler.semantic.SymbolTable;

public enum EActionSemantics {
	Number1(1, AddExpression.class),
	Number2(2, SubtractExpression.class),
	Number3(3, MultiplyExpression.class),
	Number4(4, DivideExpression.class),
	Number5(5, AllocateInt.class),
	Number6(6, AllocateFloat.class),
	Number12(12, HeaderCode.class),
	Number13(13, FooterCode.class),
	Number19(19, AllocateString.class),
	Number21(21, AllocateIdentifier.class),
	Number22(22, DeclareVariable.class),
	Number25(25, StoreValueInVariable.class);
	
	private int action;
	private Class<? extends ActionSemantic> classe;
	
	public int getAction() {
		return this.action;
	}
	
	public ActionSemantic buildActionSemantic(SymbolTable symbolTable) {
		try {
			return this.classe.getConstructor(SymbolTable.class).newInstance(symbolTable);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	EActionSemantics(int action, Class<? extends ActionSemantic> classe) {
		this.action = action;
		this.classe = classe;
	}
	
	public static EActionSemantics find(int action) {
		return Arrays.asList(EActionSemantics.values()).stream()
			.filter(record -> record.getAction() == action)
			.findAny()
			.get();
	}
}
