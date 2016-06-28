package br.com.furb.compiler.semantic.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import br.com.furb.compiler.semantic.SymbolTable;

public enum EActionSemantics {
	Number1(1, AdditionOperatorAction.class),
	Number2(2, SubtractionOperatorAction.class),
	Number3(3, MultiplicationOperatorAction.class),
	Number4(4, DivisionOperatorAction.class),
	Number5(5, AllocateIntAction.class),
	Number6(6, AllocateFloatAction.class),
	Number7(7, UnaryPlusOperatorAction.class),
	Number8(8, UnaryNegationOperatorAction.class),
	Number9(9, RelationalOperatorAction.class),
	Number10(10, PushRelationalOperatorAction.class),
	Number11(11, OutAction.class),
	Number12(12, HeaderAction.class),
	Number13(13, FooterAction.class),
	Number14(14, LogicalAndOperatorAction.class),
	Number15(15, LogicalOrOperatorAction.class),
	Number16(16, AllocateTrueAction.class),
	Number17(17, AllocateFalseAction.class),
	Number18(18, LogicalNegationOperatorAction.class),
	Number19(19, AllocateStringAction.class),
	Number21(21, PushIdentifierAction.class),
	Number22(22, DeclareVariableAction.class),
	Number24(24, AllocateIdentifierAction.class),
	Number25(25, StoreValueInVariableAction.class);
	
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
