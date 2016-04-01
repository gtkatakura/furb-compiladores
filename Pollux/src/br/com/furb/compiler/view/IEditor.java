package br.com.furb.compiler.view;

import java.awt.Component;
import java.awt.event.KeyListener;

/**
 * Define um editor de código
 * 
 * @author alesson.bernardo
 */
public interface IEditor {

	Component build();

	void update(String content);

	void clean();

	String getContent();

	String getSelectedContent();

	void paste(String content);

	int getSelectionStart();

	void addKeyListener(KeyListener listener);
}