package questionnaire.answer;

import java.util.List;

import javax.swing.*;

import questionnaire.question.*;

public abstract class Answer {

	/** the one and only questionnaire factory */
	public static final QuestionnaireFactory FACTORY = new QuestionnaireFactory();
	
	/** the answer of the question */
	private String answer;
	
	/** the proposition the user made on graphic interface */
	protected String propositionGraphic;
	
	/**
	 * 
	 * @param answer the answer of the question
	 */
	public Answer(String answer) {
		this.answer = answer;
		this.propositionGraphic = "";
	}

	/**
	 * 
	 * @return the type of the answer
	 */
	public Answer getTypeAnswer() {
		return this;
	}

	/**
	 * 
	 * @return the answer of the question
	 */
	public String getAnswer() {
		return this.answer;
	}

	/**
	 * 
	 * @param newAnswer the new answer to replace the old one
	 */
	public void setAnswer(String newAnswer) {
		this.answer = newAnswer;
	}

	/**
	 * 
	 * @param proposition the proposition wrote by the user
	 * @return <code>true</code> if the type of the proposition is correct, <code>false</code> else
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public abstract Boolean isCorrectType(String proposition) throws NoSuchMethodException, SecurityException;

	/**
	 * 
	 * @param proposition the proposition wrote by the user
	 * @return <code>true</code> if the proposition is the good answer, <code>false</code> else
	 */
	public boolean isCorrectAnswer(String proposition) {
		return (proposition.toLowerCase().equals(this.getAnswer().toLowerCase()));
	}

	/**
	 * 
	 * @return the description of the type of answer
	 */
	public abstract String typeToString();

	/**
	 * 
	 * @return the list of all possible answers
	 */
	protected abstract List<String> getListAnswers();
	
	/**
	 * 
	 * @return a panel for the corresponding answer
	 */
	public abstract JPanel getGraphicAnswer();
	
	/**
	 * 
	 * @return the proposition the user made on the graphic interface
	 */
	public String getPropositionGraphic() {
		return this.propositionGraphic;
	}
	
}
