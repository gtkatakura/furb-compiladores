package br.com.furb.compiler.view;

import java.awt.Component;

public interface IMessageArea {

	Component build();

	void update(String message);

	void clean();

}
