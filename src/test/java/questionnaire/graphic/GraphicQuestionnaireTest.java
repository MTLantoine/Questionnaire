package questionnaire.graphic;

import static org.junit.Assert.*;

import javax.swing.*;

import org.junit.*;

import questionnaire.question.*;

public class GraphicQuestionnaireTest extends QuestionnaireLibraryTest {

	@Test
	public void getQuestionnaireTest() {
		assertEquals(this.questionnaire, this.graphicQuestionnaire.getQuestionnaire());
	}
	
	@Test
	public void setUpValidateBtn() {
		this.graphicQuestionnaire.setUpValidateBtn("Mon Message");
		assertEquals("Mon Message", this.graphicQuestionnaire.getTheValidateButton().getText());
	}
	
	@Test
	public void getTheValidateButtonTest() {
		assertTrue(this.graphicQuestionnaire.getTheValidateButton() instanceof JButton);
		assertEquals("Valider vos réponses.", this.graphicQuestionnaire.getTheValidateButton().getText());
	}

	@Test
	public void fillTheGridTest() {
		assertEquals(0, this.mockGraphicQuestionnaire.getCmpt());
		this.mockGraphicQuestionnaire.fillTheGrid(new JFrame());
		assertEquals(1, this.mockGraphicQuestionnaire.getCmpt());
	}
	
	@Test
	public void askAllTest() {
		assertEquals(0, this.mockGraphicQuestionnaire.getCmpt());
		this.mockGraphicQuestionnaire.askAll();
		assertEquals(1, this.mockGraphicQuestionnaire.getCmpt());
	}

}
