package br.com.furb.compiler.view;

/**
 * Contrato de defini��o das partes que comp�em a interface do compilador
 * 
 * @author alesson.bernardo
 */
public interface View {

	void setEditor(Editor editor);

	void setMessageArea(MessageArea messageArea);

	void setStatusBar(StatusBar statusBar);

	void setToolBar(ToolBar toolBar);

}
