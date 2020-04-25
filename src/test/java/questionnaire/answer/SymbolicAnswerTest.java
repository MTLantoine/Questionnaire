package questionnaire.answer;

import static org.junit.Assert.*;

import org.junit.*;

public class SymbolicAnswerTest extends AnswerTest {

	public Answer createAnswer() {
		return new SymbolicAnswer(super.symbolicProposition);
	}
	
	@Test
	public void getTypeAnswerTest() {
		assertTrue(super.answer.getTypeAnswer() instanceof SymbolicAnswer);
	}
	
	@Test
	public void getAnswerTest() {
		assertEquals("symbolic", super.answer.getAnswer());
	}
	
}
