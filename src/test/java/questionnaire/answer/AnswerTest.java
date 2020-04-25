package questionnaire.answer;

import static org.junit.Assert.*;

import javax.swing.*;

import org.junit.*;

public abstract class AnswerTest {
	
	protected Answer answer;
	protected abstract Answer createAnswer();
	protected String symbolicProposition;
	protected String numericalProposition;
	protected String qcmProposition;
	protected String multipleProposition;
	protected String yesnoProposition;
	private MockAnswer mockAnswer;
	
	@Before
	public void initObjects() {
		this.symbolicProposition = "symbolic";
		this.numericalProposition = "10";
		this.qcmProposition = "A | B | C | D | E";
		this.multipleProposition = "A ; B ; C ; D ; E";
		this.yesnoProposition = "oui";
		this.answer = this.createAnswer();
		this.mockAnswer = new MockAnswer(null);
	}
	
	@Test
	public void setAnswerTest() {
		this.answer.setAnswer("nouvelle reponse");
		assertEquals("nouvelle reponse", this.answer.getAnswer());
	}
	
	@Test
	public void isCorrectAnswerTest() {
		assertTrue(this.answer.isCorrectAnswer(this.answer.getAnswer()));
	}
	
	@Test
	public void isNotCorrectAnswerTest() {
		assertFalse(this.answer.isCorrectAnswer("wrong answer"));
	}
	
	@Test
	public void isCorrectTypeTest() throws NoSuchMethodException, SecurityException {
		assertTrue(this.answer.isCorrectType(this.answer.getAnswer()));
	}
	
	@Test
	public void getGraphicAnswerTest() {
		assertEquals(0, this.mockAnswer.getCmpt());
		this.mockAnswer.getGraphicAnswer();
		assertEquals(1, this.mockAnswer.getCmpt());
	}
	
	@Test
	public void getPropositionGraphicTest() {
		assertEquals("", this.answer.getPropositionGraphic());
	}

}
