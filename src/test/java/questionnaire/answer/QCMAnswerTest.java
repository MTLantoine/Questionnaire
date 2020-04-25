package questionnaire.answer;

import static org.junit.Assert.*;

import org.junit.*;

public class QCMAnswerTest extends AnswerTest {

	public Answer createAnswer() {
		return new QCMAnswer(super.qcmProposition);
	}
	
	@Test
	public void getTypeAnswerTest() {
		assertTrue(super.answer.getTypeAnswer() instanceof QCMAnswer);
	}
	
	@Test
	public void getAnswerTest() {
		assertEquals("A", super.answer.getAnswer());
	}


}
