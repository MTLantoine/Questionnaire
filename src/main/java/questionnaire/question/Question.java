package questionnaire.question;

import questionnaire.answer.*;

public class Question {
	
	/** the asked question */
	private String question;
	
	/** the answer of the question */
	private Answer answer;
	
	/** the number of points for the question */
	private int nbPoint;
	
	/**
	 * 
	 * @param question the asked question
	 * @param answer the answer of the question
	 * @param nbPoints the number of points for the question
	 */
	public Question(String question, Answer answer, int nbPoints) {
		this.question = question;
		this.answer = answer;
		this.nbPoint = nbPoints;
	}
	
	/**
	 * 
	 * @return the asked question
	 */
	public String getQuestion() {
		return this.question;
	}
	
	/**
	 * 
	 * @return the answer of the question
	 */
	public Answer getAnswer() {
		return this.answer;
	}
	
	/**
	 * 
	 * @return the number of points for the question
	 */
	public int getNbPoint() {
		return this.nbPoint;
	}
	
	/**
	 * 
	 * @param newPoints the new points we want to replace the old one
	 */
	public void setNbPoint(int newPoints) {
		this.nbPoint = newPoints;
	}

	/**
	 * 
	 * @return a sentence of how many points the question has
	 */
	public String getNbPointToString() {
		return this.getNbPoint() + " point" + this.plurialString();
	}
	
	/**
	 * 
	 * @return the letter s if there is more than one point
	 */
	public String plurialString() {
		if (this.getNbPoint() > 1) {
			return "s";
		}
		return "";
	}
	
}
