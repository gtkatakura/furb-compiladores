package br.com.furb.compiler.view;

public interface StatusBar extends BuildableComponent {

	void notModified(String file);

	void modified(String file);

}