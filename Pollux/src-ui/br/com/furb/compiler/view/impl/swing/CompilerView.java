package br.com.furb.compiler.view.impl.swing;

import static br.com.furb.compiler.view.EditorTool.COMPILE;
import static br.com.furb.compiler.view.EditorTool.COPY;
import static br.com.furb.compiler.view.EditorTool.CUT;
import static br.com.furb.compiler.view.EditorTool.GENERATE_CODE;
import static br.com.furb.compiler.view.EditorTool.NEW_FILE;
import static br.com.furb.compiler.view.EditorTool.OPEN_FILE;
import static br.com.furb.compiler.view.EditorTool.PASTE;
import static br.com.furb.compiler.view.EditorTool.SAVE_FILE;
import static br.com.furb.compiler.view.EditorTool.TEAM;

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

import br.com.furb.compiler.analysis.lexical.LexicalAnalyser;
import br.com.furb.compiler.analysis.lexical.LexicalError;
import br.com.furb.compiler.analysis.semantic.SemanticAnalyser;
import br.com.furb.compiler.analysis.semantic.SemanticError;
import br.com.furb.compiler.analysis.syntatic.SyntaticAnalyser;
import br.com.furb.compiler.analysis.syntatic.SyntaticError;
import br.com.furb.compiler.io.SourceFile;
import br.com.furb.compiler.view.Editor;
import br.com.furb.compiler.view.MessageArea;
import br.com.furb.compiler.view.StatusBar;
import br.com.furb.compiler.view.ToolBar;
import br.com.furb.compiler.view.View;
import br.com.furb.compiler.view.EditorTool;
import br.com.furb.compiler.view.resources.IconProvider;

/**
 * Implementação da interface do compilador utilizando o framework
 * <tt>Swing</tt>.
 *
 * @author alesson.bernardo
 */
public class CompilerView implements View {

	private final JFrame window = new JFrame();
	private JPanel pnlContainer;

	private File source;
	private String currentContent = "";

	private ToolBar toolbar;
	private Editor editor;
	private MessageArea messageArea;
	private StatusBar statusBar;

	public CompilerView(ToolBar toolbar, Editor editor, MessageArea messageArea, StatusBar statusBar) {
		this.toolbar = toolbar;
		this.editor = editor;
		this.messageArea = messageArea;
		this.statusBar = statusBar;

		buildMainWindow();
	}

	@Override
	public void setEditor(Editor editor) {
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
	public void setMessageArea(MessageArea messageArea) {
		pnlContainer.add(messageArea.build(), BorderLayout.SOUTH);
	}

	@Override
	public void setStatusBar(StatusBar statusBar) {
		contentPane().add(statusBar.build(), BorderLayout.SOUTH);
	}

	@Override
	public void setToolBar(ToolBar toolBar) {
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
		toolbar.addAction(key, EditorTool.TEAM, new AbstractAction(TEAM.caption, IconProvider.TEAM.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				messageArea.update("Equipe: Alesson Bernardo, Gabriel Katakura, Leonardo Farias Bona.");
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
		toolbar.addAction(key, EditorTool.NEW_FILE, new AbstractAction(NEW_FILE.caption, IconProvider.NEW_FILE.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				newFile();
			}
		});
	}

	private void openFileAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK);
		toolbar.addAction(key, EditorTool.OPEN_FILE, new AbstractAction(OPEN_FILE.caption, IconProvider.OPEN_FILE.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				File file;
				try {
					file = chooseFile(source);
					source = file;
					currentContent = SourceFile.read(file);
					editor.update(currentContent);
					messageArea.clean();
					statusBar.notModified(source.toString());
				} catch (Exception e1) {
					// e1.printStackTrace();
				}
			}
		});
	}

	private void saveFileAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK);
		toolbar.addAction(key, EditorTool.SAVE_FILE, new AbstractAction(SAVE_FILE.caption, IconProvider.SAVE_FILE.get()) {

			public void actionPerformed(ActionEvent e) {
				try {
					if (source == null) {
						source = chooseFile(null);
						source = new File(source.getAbsolutePath() + ".txt");
					}
					String content = editor.getContent();
					currentContent = content;
					SourceFile.save(source, currentContent);
					messageArea.clean();
					statusBar.notModified(source.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
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
		toolbar.addAction(key, EditorTool.COPY, new AbstractAction(COPY.caption, IconProvider.COPY.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				copyToClipboard(editor.getSelectedContent());
			}
		});
	}

	private void pasteAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);
		toolbar.addAction(key, EditorTool.PASTE, new AbstractAction(PASTE.caption, IconProvider.PASTE.get()) {
			@Override
			public void actionPerformed(ActionEvent e) {
				paste();
			}
		});
	}

	private void cutAction() {
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK);
		toolbar.addAction(key, EditorTool.CUT, new AbstractAction(CUT.caption, IconProvider.CUT.get()) {
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
		toolbar.addAction(key, EditorTool.COMPILE, new AbstractAction(COMPILE.caption, IconProvider.COMPILE.get()) {
			@Override
			public void actionPerformed(ActionEvent event) {
				String input = editor.getContent();
				try {
					LexicalAnalyser lexico = new LexicalAnalyser();
					SyntaticAnalyser sintatico = new SyntaticAnalyser();
					SemanticAnalyser semantico = new SemanticAnalyser();

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
		toolbar.addAction(key, EditorTool.GENERATE_CODE,
				new AbstractAction(GENERATE_CODE.caption, IconProvider.GENERATE_CODE.get()) {
					@Override
					public void actionPerformed(ActionEvent e) {
						String input = editor.getContent();
						String objectCode = "";
						try {
							LexicalAnalyser lexico = new LexicalAnalyser();
							SyntaticAnalyser sintatico = new SyntaticAnalyser();
							SemanticAnalyser semantico = new SemanticAnalyser();

							lexico.setInput(input);
							sintatico.parse(lexico, semantico);
							objectCode = semantico.getObjectCode();
							try{
								if (source == null) {
									source = chooseFile(null);
									source = new File(source.getAbsolutePath() + ".txt");
								}
	
								if (source != null) {
									String content = editor.getContent();
									currentContent = content;
									SourceFile.save(source, currentContent);
									messageArea.clean();
									statusBar.notModified(source.toString());
									String nome = source.getName().substring(0, source.getName().lastIndexOf("."));
									File objectCodeFile = new File(source.getParent(), nome + ".il");
									SourceFile.save(objectCodeFile, objectCode);
									messageArea.update("Código objeto gerado com sucesso");
								}
							}catch (Exception e1) {
								
								
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

	private File chooseFile(File directory) throws Exception {
		final JFileChooser chooser = new JFileChooser(source);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setMultiSelectionEnabled(false);
		chooser.setCurrentDirectory(new File("C:\\Temp"));

		if (chooser.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		} else {
			throw new Exception("Processo cancelado");
		}
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
