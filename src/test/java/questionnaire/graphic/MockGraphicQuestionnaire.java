package questionnaire.graphic;

import javax.swing.*;

import questionnaire.question.*;

public class MockGraphicQuestionnaire extends GraphicQuestionnaire {
	
	private int cmpt;

	public MockGraphicQuestionnaire(Questionnaire questionnaire) {
		super(questionnaire);
		this.cmpt = 0;
	}
	
	public int getCmpt() {
		return this.cmpt;
	}
	
	public void fillTheGrid(JFrame grid) {
		this.cmpt++;		
	}
	
	public void askAll() {
		this.cmpt++;
	}

}
