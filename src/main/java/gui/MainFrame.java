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
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		initContent();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
	}

	private void initContent() {
		JPanel content = new JPanel();
		content.setLayout(null);
		makeDescription(content);
		getContentPane().add(content, null);
	}

	private void makeDescription(JPanel content) {
		int xOffsetLabel = 370;
		int xOffsetTextfield = 510;
		int spacing = 30;
		int yOffset = 10;
		int widthLabel = 130;
		int widthTextfield = 370;
		int height = 25;

		String[] labels =
				new String[] { "Name", "Association", "Work", "Rank", "Contact choices", "Squad relation", "First met",
						"Contact for" };

		for (int i = 0; i < labels.length; i++) {
			createComponent(CreationMode.LABEL, content, labels[i] + ":", xOffsetLabel,
					10 + i * spacing, widthLabel, height);
		}

		name =
				(JTextField) createComponent(CreationMode.TEXTFIELD, content, null, xOffsetTextfield,
						yOffset, widthTextfield, height);
		association =
				(JTextField) createComponent(CreationMode.TEXTFIELD, content, null, xOffsetTextfield,
						yOffset + spacing, widthTextfield, height);
		work =
				(JTextField) createComponent(CreationMode.TEXTFIELD, content, null, xOffsetTextfield,
						yOffset + 2 * spacing, widthTextfield, height);
		rank =
				(JTextField) createComponent(CreationMode.TEXTFIELD, content, null, xOffsetTextfield,
						yOffset + 3 * spacing, widthTextfield, height);
		contactChoice =
				(JTextField) createComponent(CreationMode.TEXTFIELD, content, null, xOffsetTextfield,
						yOffset + 4 * spacing, widthTextfield, height);
		squadRelation =
				(JTextField) createComponent(CreationMode.TEXTFIELD, content, null, xOffsetTextfield,
						yOffset + 5 * spacing, widthTextfield, height);
		firstMet =
				(JTextField) createComponent(CreationMode.TEXTFIELD, content, null, xOffsetTextfield,
						yOffset + 6 * spacing, widthTextfield, height);

		detailedNotes = new JTextArea();
		detailedNotes.setWrapStyleWord(true);
		detailedNotes.setLineWrap(true);
		int width = WINDOW_WIDTH - 20 - xOffsetLabel;
		JScrollPane scroll =
				new JScrollPane(detailedNotes, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(xOffsetLabel, yOffset + 8 * spacing, width, 250);
		add(scroll);
	}

	private JComponent createComponent(CreationMode mode, JPanel content, String name, int x, int y,
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
