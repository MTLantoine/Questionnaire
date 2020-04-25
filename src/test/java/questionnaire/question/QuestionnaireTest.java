package questionnaire.question;

import static org.junit.Assert.*;

import org.junit.*;

public class QuestionnaireTest extends QuestionnaireLibraryTest {
	
	@Test
	public void getListQuestionsTest() {
		assertTrue(this.questionnaire.getListQuestions().isEmpty());
	}
	
	@Test
	public void addQuestionTest() {
		assertTrue(this.questionnaire.getListQuestions().isEmpty());
		this.questionnaire.addQuestion(this.question);
		assertEquals(1, this.questionnaire.getListQuestions().size());
	}
	
	@Test
	public void incScoreTest() {
		assertEquals(0, this.questionnaire.getScore());
		this.questionnaire.incScore(7);
		assertEquals(7, this.questionnaire.getScore());
	}

	@Test
	public void getScoreTest() {
		assertEquals(0, this.questionnaire.getScore());
	}
	
	@Test
	public void getScoreToStringTest() {
		assertEquals("0 point", this.questionnaire.getScoreToString());
		this.questionnaire.incScore(7);
		assertEquals("7 points", this.questionnaire.getScoreToString());
	}
	
	@Test
	public void askAllTest() {
		assertEquals(0, this.mockQuestionnaire.getCmpt());
		this.mockQuestionnaire.askAll();
		assertEquals(1, this.mockQuestionnaire.getCmpt());
	}

}
