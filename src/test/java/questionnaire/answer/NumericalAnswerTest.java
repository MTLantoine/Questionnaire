package questionnaire.answer;

import static org.junit.Assert.*;

import org.junit.*;

public class NumericalAnswerTest extends AnswerTest {

	public Answer createAnswer() {
		return new NumericalAnswer(super.numericalProposition);
	}
	
	@Test
	public void getTypeAnswerTest() {
		assertTrue(super.answer.getTypeAnswer() instanceof NumericalAnswer);
	}
	
	@Test
	public void getAnswerTest() {
		assertEquals("10", super.answer.getAnswer());
	}

}
