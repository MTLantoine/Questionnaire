package questionnaire.graphic;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import questionnaire.question.*;

public class GraphicQuestionnaire {
	
	/** the chosen questionnaire */
	private Questionnaire questionnaire;
	
	/** the main window of the interface */
	private JFrame grid;
	
	/** the submit button */
	private JButton validateBtn;
	
	/**
	 * 
	 * @param questionnaire the chosen questionnaire
	 */
	public GraphicQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
		this.setUpValidateBtn("Valider vos réponses.");
	}
	
	/**
	 * 
	 * @return the chosen questionnaire
	 */
	public Questionnaire getQuestionnaire() {
		return this.questionnaire;
	}
	
	/**
	 * 
	 * initialize the submit button and
	 * add an action listener on it
	 */
	public void setUpValidateBtn(String msg) {
		this.validateBtn = new JButton(msg);
		this.validateBtn.addActionListener(new ValidateListener());
	}
	
	/**
	 * 
	 * @return the submit button
	 */
	public JButton getTheValidateButton() {
		return this.validateBtn;
	}
	
	/**
	 * 
	 * @return the main window of the interface
	 */
	public JFrame getGrid() {
		return this.grid;
	}
	
	/**
	 * 
	 * @return the interface created with its panels inside
	 */
	public JFrame createGrid() {		
		JFrame f = new JFrame("Questionnaire");
		f.addWindowListener(new CloseWindowEvent());
		f.setLocation(500, 200);
		f.setSize(1000, 700);
		this.fillTheGrid(f);
		f.pack();
		f.setVisible(true);
		return f;
	}
	
	/**
	 * 
	 * @param grid the grid containing the panels of questions
	 */
	public void fillTheGrid(JFrame grid) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(this.getQuestionnaire().getListQuestions().size(), 2));
		Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
		for (Question question : this.questionnaire.getListQuestions()) {
			JLabel leftLabel = new JLabel(" " + question.getQuestion());
			JPanel leftPanel = new JPanel();
			leftPanel.add(leftLabel);
			leftPanel.setBorder(border);
			leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.LINE_AXIS));
			panel.add(leftPanel);
			JPanel rightPanel = question.getAnswer().getGraphicAnswer();
			rightPanel.setBorder(border);
			panel.add(rightPanel);
		}
		grid.add(panel);
		grid.add(this.getTheValidateButton(), BorderLayout.SOUTH);
	}
	
	/**
	 * 
	 * launch the creation of the interface and execute it
	 */
	public void askAll() {	
		this.grid = this.createGrid();
	}
	
	private class CloseWindowEvent extends WindowAdapter {
	
		/**
		 * 
		 * finish the executed program 
		 */
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
		
	}
	
	public class ValidateListener implements ActionListener {

		/**
		 * 
		 * count every correct answer and open a new window containing the user's score
		 */
		public void actionPerformed(ActionEvent e) {
			int score = 0;
			int max = 0;
			for (Question question : GraphicQuestionnaire.this.getQuestionnaire().getListQuestions()) {
				max += question.getNbPoint();
				if (question.getAnswer().isCorrectAnswer(question.getAnswer().getPropositionGraphic())) {
					score += question.getNbPoint();
				}
			}
		    JOptionPane.showMessageDialog(null, "Votre score final est de : " + score + "/" + max + " point" + (score > 1 ? "s" : "") + " !");
		}

	}

}
