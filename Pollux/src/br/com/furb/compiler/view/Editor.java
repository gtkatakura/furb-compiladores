package br.com.furb.compiler.view;

import java.awt.event.KeyListener;

/**
 * Define um editor de c�digo
 * 
 * @author alesson.bernardo
 */
public interface Editor extends BuildableComponent {

	void update(String content);

	void clean();

	String getContent();

	String getSelectedContent();

	void paste(String content);

	int getSelectionStart();

	void addKeyListener(KeyListener listener);
}