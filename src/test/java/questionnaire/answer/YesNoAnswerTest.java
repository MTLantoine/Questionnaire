package questionnaire.answer;

import static org.junit.Assert.*;

import org.junit.*;

public class YesNoAnswerTest extends AnswerTest {

	public Answer createAnswer() {
		return new YesNoAnswer(super.yesnoProposition);
	}
	
	@Test
	public void getTypeAnswerTest() {
		assertTrue(super.answer.getTypeAnswer() instanceof YesNoAnswer);
	}
	
	@Test
	public void getAnswerTest() {
		assertEquals("oui", super.answer.getAnswer());
	}

}
