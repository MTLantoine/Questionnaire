package questionnaire.question;

import static org.junit.Assert.*;

import org.junit.*;

public class QuestionTest extends QuestionnaireLibraryTest {
	@Test
	public void getQuestionTest() {
		assertEquals("Quel est le deuxième jour de la semaine ?", this.question.getQuestion());
	}
	
	@Test
	public void getAnswerTest() {
		assertEquals(this.qcmAnwser, this.question.getAnswer());
	}
	
	@Test
	public void getNbPointTest() {
		assertEquals(4, this.question.getNbPoint());
	}
	
	@Test
	public void setNbPointTest() {
		assertEquals(4, this.question.getNbPoint());
		this.question.setNbPoint(147);
		assertEquals(147, this.question.getNbPoint());
	}
	
	@Test
	public void getNbPointToString() {
		assertEquals("4 points", this.question.getNbPointToString());
		this.question.setNbPoint(0);
		assertEquals("0 point", this.question.getNbPointToString());
		this.question.setNbPoint(1);
		assertEquals("1 point", this.question.getNbPointToString());
	}


}
