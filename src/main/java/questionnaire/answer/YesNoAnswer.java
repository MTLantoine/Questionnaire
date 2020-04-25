package questionnaire.answer;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import questionnaire.choices.*;

public class YesNoAnswer extends Answer {
	
	/** the group of checkboxes */
	private ButtonGroup group;

	/** the list of the radio buttons for a question in the graphic interface */
	private List<JRadioButton> listRadioButtons;
	
	/**
	 * 
	 * @param answer the answer of the question
	 */
	public YesNoAnswer(String answer) {
		super(answer);
		this.group = new ButtonGroup();
		this.listRadioButtons = new ArrayList<JRadioButton>();
	}

	/**
	 * 
	 * @return the description of the type of answer
	 */
	public String typeToString() {
		return "Oui/Non";
	}

	/**
	 * 
	 * @param proposition the proposition wrote by the user
	 * @return <code>true</code> if the type of the proposition is correct, <code>false</code> else
	 */
	public Boolean isCorrectType(String proposition) {
		return (YesNo.OUI.isIn(proposition) || YesNo.NON.isIn(proposition));
	}

	@Override
	/**
	 * 
	 * @return the list of all possible answers
	 */
	protected List<String> getListAnswers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @return a panel for the corresponding answer
	 */
	public JPanel getGraphicAnswer() {
		JPanel panel = new JPanel();
		JRadioButton oui;
		JRadioButton non;
		oui = new JRadioButton("Oui");
		oui.addActionListener(new RadioButtonListener());
		this.listRadioButtons.add(oui);
		non = new JRadioButton("Non");
		non.addActionListener(new RadioButtonListener());
		this.listRadioButtons.add(non);
		this.group.add(oui);
		panel.add(oui);
		this.group.add(non);
		panel.add(non);
		return panel;
	}
	
	public class RadioButtonListener implements ActionListener {

		/**
		 * 
		 * change the proposition the user made on graphic interface
		 * everytime he select an other radio button
		 */
		public void actionPerformed(ActionEvent e) {
			for (JRadioButton button : YesNoAnswer.this.listRadioButtons) {
				if (button.isSelected()) {
					YesNoAnswer.super.propositionGraphic = button.getText();
				}
			}
		}

	}
	
}
