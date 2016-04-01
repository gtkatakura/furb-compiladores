package br.com.furb.compiler.view;

/**
 * Contrato de definição das partes que compõem a interface do compilador
 * 
 * @author alesson.bernardo
 */
public interface IView {

	void setEditor(IEditor editor);

	void setMessageArea(IMessageArea messageArea);

	void setStatusBar(IStatusBar statusBar);

	void setToolBar(IToolBar toolBar);

}
