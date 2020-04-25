package questionnaire.answer;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class QCMAnswer extends Answer {
	
	/** the new answer to replace the old one */
	private String newAnswer;
	
	/** the choices you can make to answer */
	private String choices;
	
	/** the list of the choices you can make to answer */
	private List<String> listChoices;

	/** the group of checkboxes */
	private ButtonGroup group;
	
	/** the list of the radio buttons for a question in the graphic interface */
	private List<JRadioButton> listRadioButtons;
	
	/**
	 * 
	 * @param answer the answer of the question
	 */
	public QCMAnswer(String answer) {
		super(answer);
		this.newAnswer = this.getTheAnswer();
		this.choices = this.getTheChoices();
		this.listChoices = new ArrayList<String>();
		this.addListChoices(super.getAnswer());
		super.setAnswer(this.newAnswer);
		this.group = new ButtonGroup();
		this.listRadioButtons = new ArrayList<JRadioButton>();
	}
	
	/**
	 * 
	 * @return the description of the type of answer
	 */
	public String typeToString() {
		return this.choices;
	}
	
	/**
	 * 
	 * @return the great answer among the list of choices to answer
	 */
	public String getTheAnswer() {
		String[] words = super.getAnswer().split(" \\| ");
		return words[0];
	}
	
	/**
	 * 
	 * @return the choices you can make to answer
	 */
	public String getTheChoices() {
		String choices = "";
		String[] choice = super.getAnswer().split(" \\| ");
		List<String> shuffleWords = new ArrayList<String>();
		shuffleWords = this.shuffleWords(choice);
		int cmpt = 0;
		for (String word : shuffleWords) {
			choices += word;
			cmpt++;
			if (cmpt < shuffleWords.size()) {
				choices += "   ";
			}
		}
		return choices;
	}
	
	/**
	 * 
	 * @param myList the list I want to shuffle
	 * @return a shuffled list
	 */
	public List<String> shuffleWords(String[] myList) {
		List<String> newArray = new ArrayList<String>();
		for (String part : myList) {
			newArray.add(part);
		}
		Collections.shuffle(newArray);
		return newArray;
	}
	
	/**
	 * 
	 * @param myList the list I want to shuffle
	 * @return a shuffled list
	 */
	public List<String> shuffleWords(List<String> myList) {
		List<String> newArray = new ArrayList<String>();
		for (String part : myList) {
			newArray.add(part);
		}
		Collections.shuffle(newArray);
		return newArray;
	}

	/**
	 * 
	 * @param proposition the proposition wrote by the user
	 * @return <code>true</code> if the type of the proposition is correct, <code>false</code> else
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public Boolean isCorrectType(String proposition) throws NoSuchMethodException, SecurityException {
		if (this.getListChoices().contains(proposition.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param myList the choices we want to add in the list of choices
	 */
	public void addListChoices(String myList) {
		String[] words = myList.split(" \\| ");
		for (String word : words) {
			this.listChoices.add(word.toLowerCase());
		}
	}
	
	/**
	 * 
	 * @return the list of the choices you can make to answer
	 */
	public List<String> getListChoices() {
		return this.listChoices;
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
	 * @return the group of buttons
	 */
	public ButtonGroup getTheButtonGroup() {
		return this.group;
	}

	/**
	 * 
	 * @return a panel for the corresponding answer
	 */
	public JPanel getGraphicAnswer() {
		JPanel panel = new JPanel();
		JRadioButton btn;
		List<String> array = new ArrayList<String>();
		array = this.shuffleWords(this.getListChoices());
		for (String choice : array) {
			btn = new JRadioButton(choice);
			btn.addActionListener(new RadioButtonListener());
			this.group.add(btn);
			this.listRadioButtons.add(btn);
			panel.add(btn);
		}
		return panel;
	}
	
	public class RadioButtonListener implements ActionListener {

		/**
		 * 
		 * change the proposition the user made on graphic interface
		 * everytime he select an other radio button
		 */
		public void actionPerformed(ActionEvent e) {
			for (JRadioButton button : QCMAnswer.this.listRadioButtons) {
				if (button.isSelected()) {
					QCMAnswer.super.propositionGraphic = button.getText();
				}
			}
		}

	}

}
