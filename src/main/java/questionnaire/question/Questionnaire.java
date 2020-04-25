package questionnaire.question;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class Questionnaire {

	/** the list of questions in the questionnaire */
	private List<Question> listQuestions;
	
	/** the score of the player */
	private int score;

	/**
	 * 
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	public Questionnaire() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		this.listQuestions = new ArrayList<Question>();
		this.score = 0;
	}
	
	/**
	 * 
	 * @return the list of questions in the questionnaire
	 */
	public List<Question> getListQuestions() {
		return this.listQuestions;
	}
	
	/**
	 * 
	 * @param question the question to add in the list of questions
	 */
	public void addQuestion(Question question) {
		this.listQuestions.add(question);
	}
	
	/**
	 * 
	 * @param point the number of points to add to the score
	 */
	public void incScore(int point) {
		this.score += point;
	}
	
	/**
	 * 
	 * @return the score of the player
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * 
	 * @return a sentence of what is the score of the player
	 */
	public String getScoreToString() {
		return this.getScore() + " point" + this.plurialString();
	}
	
	/**
	 * 
	 * @return the letter s if there is more than one point on the score
	 */
	public String plurialString() {
		if (this.getScore() > 1) {
			return "s";
		}
		return "";
	}
	
	/**
	 * 
	 * asks all the question while there is a question
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public void askAll() throws NoSuchMethodException, SecurityException {
		boolean isCorrectType;
		String proposition = null;
		Scanner sc = new Scanner(System.in);
		for (Question question : this.getListQuestions()) {
			isCorrectType = false;
			while (isCorrectType == false) {
				System.out.println(question.getQuestion());
				System.out.println("(" + question.getAnswer().typeToString() + ")");
				proposition = sc.nextLine();
				if (question.getAnswer().isCorrectType(proposition)) {
					isCorrectType = true;
				} else {
					System.out.println();
					System.out.println("The format of your answer is incorrect...");
					System.out.println();
				}
			}
			
			if (question.getAnswer().isCorrectAnswer(proposition)) {
				System.out.println("Correct (" + question.getNbPointToString() + ")");
				this.incScore(question.getNbPoint());
			} else {
				System.out.println("Incorrect, the good answer is : " + question.getAnswer().getAnswer());
			}
		}
		sc.close();
		System.out.println();
		System.out.println("Your score is : " + this.getScoreToString() + ".");
	}
	
}
