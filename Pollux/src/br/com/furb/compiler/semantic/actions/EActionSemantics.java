package br.com.furb.compiler.semantic.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import br.com.furb.compiler.semantic.SymbolTable;

public enum EActionSemantics {
	Number1(1, AdditionOperator.class),
	Number2(2, SubtractionOperator.class),
	Number3(3, MultiplicationOperator.class),
	Number4(4, DivisionOperator.class),
	Number5(5, AllocateInt.class),
	Number6(6, AllocateFloat.class),
	Number7(7, UnaryPlusOperator.class),
	Number8(8, UnaryNegationOperator.class),
	Number9(9, RelationalOperation.class),
	Number10(10, PushRelationalOperator.class),
	Number11(11, OutAction.class),
	Number12(12, HeaderCode.class),
	Number13(13, FooterCode.class),
	Number16(16, AllocateTrue.class),
	Number17(17, AllocateFalse.class),
	Number18(18, LogicalNegationOperator.class),
	Number19(19, AllocateString.class),
	Number21(21, PushIdentifier.class),
	Number22(22, DeclareVariable.class),
	Number24(24, AllocateIdentifier.class),
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
			.orElse(null);
	}
}
