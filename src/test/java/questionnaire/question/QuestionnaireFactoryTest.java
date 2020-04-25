package questionnaire.question;

import static org.junit.Assert.*;

import java.io.*;
import java.lang.reflect.*;

import org.junit.Test;

import questionnaire.answer.*;

public class QuestionnaireFactoryTest extends QuestionnaireLibraryTest {

	@Test
	public void createQuestionnaireTest() {
		assertEquals(0, this.mockQuestionnaireFactory.getCmpt());
		this.mockQuestionnaireFactory.createQuestionnaire(this.fileName);
		assertEquals(1, this.mockQuestionnaireFactory.getCmpt());
	}
	
	@Test
	public void createQuestionTest() {
		try {
			this.questionToCreate = this.questionnaireFactory.createQuestion(this.questionText, this.answer, "4", "QCMAnswer");
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(this.questionToCreate instanceof Question);
	}
	
	@Test
	public void buildAnswerTest() {
		try {
			this.answerToCreate = this.questionnaireFactory.buildAnswer(this.answer, "QCMAnswer");
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(this.answerToCreate instanceof Answer);
		assertTrue(this.answerToCreate instanceof QCMAnswer);
		assertFalse(this.answerToCreate instanceof MultipleAnswer);
	}
}
