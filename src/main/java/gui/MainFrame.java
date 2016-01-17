package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

	private static final int WINDOW_WIDTH = 900;

	private static final int WINDOW_HEIGHT = 600;

	JTextField name;

	JTextField association;

	JTextField work;

	JTextField rank;

	JTextField contactChoice;

	JTextField squadRelation;

	JTextField firstMet;

	JTextArea detailedNotes;

	public MainFrame() {
		super("RP Contact Manager");
		this.setPreferredSize(new Dimension(900, 600));
		this.initContent();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
	}

	private void initContent() {
		JPanel content = new JPanel();
		content.setLayout(null);
		this.makeDescription(content);
		this.getContentPane().add(content, null);
	}

	private void makeDescription(JPanel content) {
		String[] labels =
				new String[] { "Name", "Association", "Work", "Rank", "Contact choices", "Squad relation", "First met",
						"Contact for" };

		for (int i = 0; i < labels.length; i++) {
			this.createLabel(labels[i], i, content);
		}

		int xOffset = 510;
		int yOffset = 10;
		int spacing = 30;
		int fullWidth = 370;
		int height = 25;
		this.name =
				(JTextField) this.createComponent(MainFrame.CreationMode.TEXTFIELD, content, null, xOffset, yOffset,
						fullWidth, height);
		this.association =
				(JTextField) this.createComponent(MainFrame.CreationMode.TEXTFIELD, content, null, xOffset, yOffset
						+ spacing, fullWidth, height);
		this.work =
				(JTextField) this.createComponent(MainFrame.CreationMode.TEXTFIELD, content, null, xOffset, yOffset + 2
						* spacing, fullWidth, height);
		this.rank =
				(JTextField) this.createComponent(MainFrame.CreationMode.TEXTFIELD, content, null, xOffset, yOffset + 3
						* spacing, fullWidth, height);
		this.contactChoice =
				(JTextField) this.createComponent(MainFrame.CreationMode.TEXTFIELD, content, null, xOffset, yOffset + 4
						* spacing, fullWidth, height);
		this.squadRelation =
				(JTextField) this.createComponent(MainFrame.CreationMode.TEXTFIELD, content, null, xOffset, yOffset + 5
						* spacing, fullWidth, height);
		this.firstMet =
				(JTextField) this.createComponent(MainFrame.CreationMode.TEXTFIELD, content, null, xOffset, yOffset + 6
						* spacing, fullWidth, height);

		this.detailedNotes = new JTextArea();
		JTextArea textArea = new JTextArea("TEST");
		textArea.setSize(400, 400);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setVisible(true);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scroll);
	}

	private void createLabel(String labelName, int yIndex, JPanel content) {
		short xOffset = 200;
		byte spacing = 30;
		short width = 300;
		byte height = 25;
		this.createComponent(MainFrame.CreationMode.LABEL, content, labelName + ":", xOffset, 10 + yIndex * spacing,
				width, height);
	}

	private JComponent createComponent(MainFrame.CreationMode mode, JPanel content, String name, int x, int y,
			int width, int height) {
		JComponent newComponent = null;
		switch (mode) {
			case LABEL:
				newComponent = new JLabel(name, SwingConstants.RIGHT);
				break;
			case TEXTFIELD:
				newComponent = new JTextField();
				break;
			default:
				throw new RuntimeException("Cannot handle CreationMode: " + mode);
		}

		newComponent.setLayout(null);
		newComponent.setBounds(x, y, width, height);
		content.add(newComponent);
		return newComponent;
	}

	private enum CreationMode {
		TEXTFIELD,
		LABEL
	}
}
