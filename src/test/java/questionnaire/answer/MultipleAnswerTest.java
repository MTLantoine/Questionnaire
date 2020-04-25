package questionnaire.answer;

import static org.junit.Assert.*;

import org.junit.*;

public class MultipleAnswerTest extends AnswerTest {

	public Answer createAnswer() {
		return new MultipleAnswer(super.multipleProposition);
	}
	
	@Test
	public void getTypeAnswerTest() {
		assertTrue(super.answer.getTypeAnswer() instanceof MultipleAnswer);
	}
	
	@Test
	public void getAnswerTest() {
		assertEquals("A ; B ; C ; D ; E", super.answer.getAnswer());
	}
	
	@Test
	public void isCorrectAnswerTest() {
		assertTrue(this.answer.isCorrectAnswer("A"));
		assertTrue(this.answer.isCorrectAnswer("B"));
		assertTrue(this.answer.isCorrectAnswer("C"));
		assertTrue(this.answer.isCorrectAnswer("D"));
		assertTrue(this.answer.isCorrectAnswer("E"));
		assertTrue(this.answer.isCorrectAnswer("a"));
		assertTrue(this.answer.isCorrectAnswer("b"));
		assertTrue(this.answer.isCorrectAnswer("c"));
		assertTrue(this.answer.isCorrectAnswer("d"));
		assertTrue(this.answer.isCorrectAnswer("e"));
	}
	
	@Test
	public void fillListAnswersTest() {
		/* le constructeur MultipleAnswer(String answer) appelle
		 * la fonction fillListAnswers() qui remplit la liste des réponses.
		 */
		assertEquals(5, super.answer.getListAnswers().size());
	}


}
