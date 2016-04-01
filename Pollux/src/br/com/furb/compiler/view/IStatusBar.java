package br.com.furb.compiler.view;

import java.awt.Component;

public interface IStatusBar {

	Component build();

	void notModified(String file);

	void modified(String file);

}