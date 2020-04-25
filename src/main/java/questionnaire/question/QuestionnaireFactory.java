package questionnaire.question;

import java.io.*;
import java.lang.reflect.*;

import questionnaire.answer.*;

public class QuestionnaireFactory {

	/**
	 * 
	 * @param fileName the file name
	 * @return a new questionnaire based on the file selected
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ClassNotFoundException
	 */
	public Questionnaire createQuestionnaire(String fileName) throws IOException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		Questionnaire questionnaire = new Questionnaire();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(fileName));
			String text;
			String answer;
			String nbPoints;
			String typeAnswer;
			while ((text = in.readLine()) != null) {
				answer = in.readLine();
				nbPoints = in.readLine();
				typeAnswer = in.readLine();
				if (answer == null || nbPoints == null || typeAnswer == null) {
					throw new IOException("Bad format.");
				}
				questionnaire.addQuestion(this.createQuestion(text, answer, nbPoints, typeAnswer));
			}
		} catch (FileNotFoundException e) {
			throw new IOException(e);
		} finally {
			in.close();
		}
		return questionnaire;
	}

	/**
	 * 
	 * @param text the question to ask
	 * @param answer the answer of the question
	 * @param points the number of points for this question
	 * @param typeAnswer the type of the answer
	 * @return a new question
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	public Question createQuestion(String text, String answer, String points, String typeAnswer) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		try {
			int nbPoints = Integer.parseInt(points);
			return new Question(text, Answer.FACTORY.buildAnswer(answer, typeAnswer), nbPoints);
		} catch(NumberFormatException e) {
			throw new IOException("Bad format.");
		}
	}

	/**
	 * 
	 * @param answer the answer of the question
	 * @param expectedType the type we want to put on the answer
	 * @return a new answer
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Answer buildAnswer(String answer, String expectedType) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Answer newAnswer = null;
		try {
			Class<?> c = Class.forName("questionnaire.answer." + expectedType);
			Constructor<?> constructor = c.getConstructor(String.class);
			newAnswer = (Answer) constructor.newInstance(answer);
			return newAnswer;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newAnswer;
	}
	
}
