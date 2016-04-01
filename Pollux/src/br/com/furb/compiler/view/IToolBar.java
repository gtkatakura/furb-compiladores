package br.com.furb.compiler.view;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.KeyStroke;

public interface IToolBar {

	Component build();

	void addAction(KeyStroke keyStroke, Tool tool, Action action);

}
