package br.com.furb.compiler.view.impl.swing;

import static br.com.furb.compiler.view.Tool.COMPILE;
import static br.com.furb.compiler.view.Tool.COPY;
import static br.com.furb.compiler.view.Tool.CUT;
import static br.com.furb.compiler.view.Tool.GENERATE_CODE;
import static br.com.furb.compiler.view.Tool.NEW_FILE;
import static br.com.furb.compiler.view.Tool.OPEN_FILE;
import static br.com.furb.compiler.view.Tool.PASTE;
import static br.com.furb.compiler.view.Tool.SAVE_FILE;
import static br.com.furb.compiler.view.Tool.TEAM;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import br.com.furb.compiler.io.SourceUtils;
import br.com.furb.compiler.lexical.impl.gals.LexicalError;
import br.com.furb.compiler.lexical.impl.gals.Lexico;
import br.com.furb.compiler.lexical.impl.gals.SemanticError;
import br.com.furb.compiler.lexical.impl.gals.Semantico;
import br.com.furb.compiler.syntactic.Sintatico;
import br.com.furb.compiler.syntactic.SyntaticError;
import br.com.furb.compiler.view.IEditor;
import br.com.furb.compiler.view.IMessageArea;
import br.com.furb.compiler.view.IStatusBar;
import br.com.furb.compiler.view.IToolBar;
import br.com.furb.compiler.view.IView;
import br.com.furb.compiler.view.Tool;
import br.com.furb.compiler.view.resources.IconProvider;

/**
 * Implementação da interface do compilador utilizando o framework
 * <tt>Swing</tt>.
 *
 * @author alesson.bernardo
 */
public class CompilerView implements IView {

	private final JFrame window = new JFrame();
	private JPanel pnlContainer;

	private File source;
	private String currentContent = "";

	private IToolBar toolbar;
	private IEditor editor;
	private IMessageArea messageArea;
	private IStatusBar statusBar;

	public CompilerView(IToolBar toolbar, IEditor editor, IMessageArea messageArea, IStatusBar statusBar) {
		this.toolbar = toolbar;
		this.editor = editor;
		this.messageArea = messageArea;
		this.statusBar = statusBar;

		buildMainWindow();
	}

	@Override
	public void setEditor(IEditor editor) {
		pnlContainer.add(editor.build(), BorderLayout.CENTER);

		editor.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				String currentPath = source != null ? source.toString() : null;
				if (currentContent.equals(editor.getContent())) {
					statusBar.notModified(currentPath);
				} else {
					statusBar.modified(currentPath);
				}
			}
		});
	}

	@Override
	public void setMessageArea(IMessageArea messageArea) {
		pnlContainer.add(messageArea.build(), BorderLayout.SOUTH);
	}

	@Override
	public void setStatusBar(IStatusBar statusBar) {
		contentPane().add(statusBar.build(), BorderLayout.SOUTH);
	}

	@Override
	public void setToolBar(IToolBar toolBar) {
		contentPane().add(toolBar.build(), BorderLayout.WEST);
		configureActions();
	}

	private void buildMainWindow() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setMinimumSize(new Dimension(900, 610));
		contentPane().setLayout(new BorderLayout(0, 0));

		createPanelContainer();

		setToolBar(toolbar);
		setStatusBar(statusBar);
		setEditor(editor);
		setMessageArea(messageArea);

		window.setVisible(true);
	}

	private void configureActions() {
		addManipulationFileActions();
		addTextEditionActions();
		addCompilationActions();

		showTeamAction();
	}

	private void showTeamAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
		toolbar.addAction(key, Tool.TEAM, new AbstractAction(TEAM.caption, IconProvider.TEAM.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				messageArea.update("Equipe: Alesson Bernardo, Gabriel Katakura, Leonardo Bona.");
			}
		});
	}

	private void addManipulationFileActions() {
		newFileAction();
		openFileAction();
		saveFileAction();
	}

	private void newFileAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK);
		toolbar.addAction(key, Tool.NEW_FILE, new AbstractAction(NEW_FILE.caption, IconProvider.NEW_FILE.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
	}

	private void openFileAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK);
		toolbar.addAction(key, Tool.OPEN_FILE, new AbstractAction(OPEN_FILE.caption, IconProvider.OPEN_FILE.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = chooseFile(source);
				if (file != null) {
					source = file;
					currentContent = SourceUtils.read(file);
					editor.update(currentContent);
					messageArea.clean();
					statusBar.notModified(source.toString());
				}
			}
		});
	}

	private void saveFileAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK);
		toolbar.addAction(key, Tool.SAVE_FILE, new AbstractAction(SAVE_FILE.caption, IconProvider.SAVE_FILE.get()) {

			public void actionPerformed(ActionEvent e) {

				if (source == null) {
					source = chooseFile(null);
					source = new File(source.getAbsolutePath() + ".txt");
				}

				if (source != null) {
					String content = editor.getContent();
					currentContent = content;
					SourceUtils.save(source, currentContent);
					messageArea.clean();
					statusBar.notModified(source.toString());
				}
			}
		});
	}

	public void addTextEditionActions() {
		copyAction();
		pasteAction();
		cutAction();
	}

	private void copyAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK);
		toolbar.addAction(key, Tool.COPY, new AbstractAction(COPY.caption, IconProvider.COPY.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyToClipboard(editor.getSelectedContent());
			}
		});
	}

	private void pasteAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);
		toolbar.addAction(key, Tool.PASTE, new AbstractAction(PASTE.caption, IconProvider.PASTE.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				paste();
			}
		});
	}

	private void cutAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK);
		toolbar.addAction(key, Tool.CUT, new AbstractAction(CUT.caption, IconProvider.CUT.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				cut();
			}
		});
	}

	private void addCompilationActions() {
		compileAction();
		generateCodeAction();
	}

	private void compileAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0);
		toolbar.addAction(key, Tool.COMPILE, new AbstractAction(COMPILE.caption, IconProvider.COMPILE.get()) {
			@Override
			public void actionPerformed(ActionEvent event) {
				String input = editor.getContent();
				try {
					Lexico lexico = new Lexico();
					Sintatico sintatico = new Sintatico();
					Semantico semantico = new Semantico();

					lexico.setInput(input);
					sintatico.parse(lexico, semantico);

					messageArea.update("Programado compilado com sucesso");
				} catch (LexicalError | SyntaticError | SemanticError error) {
					int line = CompilerView.getNumberLine(input, error.getPosition());
					messageArea.update("Erro na linha " + line + " - " + error.getMessage());
				}

			}
		});

	}

	private static int getNumberLine(String input, int positionError) {
		int line = 1;
		char[] chars = input.toCharArray();

		for (int position = 0; position < chars.length; position++) {
			if (chars[position] == '\n') {
				line++;
			}

			if (position >= positionError) {
				return line;
			}
		}

		return line;
	}

	private void generateCodeAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0);
		toolbar.addAction(key, Tool.GENERATE_CODE,
				new AbstractAction(GENERATE_CODE.caption, IconProvider.GENERATE_CODE.get()) {
					@Override
					public void actionPerformed(ActionEvent e) {
						String input = editor.getContent();
						String objectCode = "";
						try {
							Lexico lexico = new Lexico();
							Sintatico sintatico = new Sintatico();
							Semantico semantico = new Semantico();

							lexico.setInput(input);
							sintatico.parse(lexico, semantico);
							objectCode = semantico.getObjectCode();
							if (source == null) {
								source = chooseFile(null);
								source = new File(source.getAbsolutePath() + ".txt");
							}

							if (source != null) {
								String content = editor.getContent();
								currentContent = content;
								SourceUtils.save(source, currentContent);
								messageArea.clean();
								statusBar.notModified(source.toString());
								String nome = source.getName().substring(0, source.getName().lastIndexOf("."));
								File objectCodeFile = new File(source.getParent(), nome + ".il");
								SourceUtils.save(objectCodeFile, objectCode);
								messageArea.update("Código objeto gerado com sucesso");
							} else {
								messageArea.update(
										"Arquivo fonte não foi salvo ainda, não é possível gerar o código objeto"); // VERIFICAR
																													// MENSAGEM
																													// CORRETA
							}
						} catch (LexicalError | SyntaticError | SemanticError error) {
							int line = CompilerView.getNumberLine(input, error.getPosition());
							messageArea.update("Erro na linha " + line + " - " + error.getMessage());
						}
					}
				});
	}

	private void createPanelContainer() {
		pnlContainer = new JPanel();
		pnlContainer.setLayout(new BorderLayout(0, 0));
		contentPane().add(pnlContainer, BorderLayout.CENTER);
	}

	private Container contentPane() {
		return window.getContentPane();
	}

	private void newFile() {
		source = null;
		currentContent = "";
		messageArea.clean();
		statusBar.notModified(null);
		editor.clean();
	}

	private File chooseFile(File directory) {
		final JFileChooser chooser = new JFileChooser(source);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		chooser.setCurrentDirectory(new File("C:\\Temp"));

		if (chooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}
		return null; // :(
	}

	private static void copyToClipboard(String text) {
		StringSelection selection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
	}

	private void paste() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable content = clipboard.getContents(null);

		if (content != null && content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
			try {
				String strContent = (String) content.getTransferData(DataFlavor.stringFlavor);
				editor.paste(strContent);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void cut() {
		String selectedText = editor.getSelectedContent();
		int length;
		if (selectedText != null && (length = selectedText.length()) > 0) {
			StringBuilder newContent = new StringBuilder();
			String content = editor.getContent();
			int caretPosition = editor.getSelectionStart();
			newContent.append(content.substring(0, caretPosition));
			newContent.append(content.substring(caretPosition + length));
			copyToClipboard(selectedText);
			editor.update(newContent.toString());
		}
	}
}
