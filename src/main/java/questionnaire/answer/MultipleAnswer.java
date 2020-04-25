package questionnaire.answer;

import java.util.*;

public class MultipleAnswer extends SymbolicAnswer {
	
	/** the list of all possible answers */
	private List<String> listAnswers;
	
	/**
	 * 
	 * @param answer the answer of the question
	 */
	public MultipleAnswer(String answer) {
		super(answer);
		this.listAnswers = new ArrayList<String>();
		this.fillListAnswers();
	}
	
	/**
	 * 
	 * @return the description of the type of answer
	 */
	public String typeToString() {
		return super.typeToString() + " : " + this.getNumberOfPossibleAnswers() + " possible answers";
	}
	
	/**
	 * 
	 * fill the list of all the possible answers
	 */
	public void fillListAnswers() {
		String[] words = super.getAnswer().split(" ; ");
		for (String word : words) {
			this.listAnswers.add(word.toLowerCase());
		}
	}
	
	/**
	 * 
	 * @return the list of all possible answers
	 */
	public List<String> getListAnswers() {
		return this.listAnswers;
	}
	
	/**
	 * 
	 * @return the number of possible answers
	 */
	public int getNumberOfPossibleAnswers() {
		return this.listAnswers.size();
	}
	
	/**
	 * 
	 * @param proposition the proposition wrote by the user
	 * @return <code>true</code> if the proposition is the good answer, <code>false</code> else
	 */
	public boolean isCorrectAnswer(String proposition) {
		super.setAnswer("All those answers are correct :\n" + super.getAnswer());
		return (this.listAnswers.contains(proposition.toLowerCase()));
	}
	
}
