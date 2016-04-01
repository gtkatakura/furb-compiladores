package br.com.furb.compiler.view;

/**
 * Contrato de defini��o das partes que comp�em a interface do compilador
 * 
 * @author alesson.bernardo
 */
public interface IView {

	void setEditor(IEditor editor);

	void setMessageArea(IMessageArea messageArea);

	void setStatusBar(IStatusBar statusBar);

	void setToolBar(IToolBar toolBar);

}
