package questionnaire.question;

public class MockQuestionnaireFactory extends QuestionnaireFactory {
	
	private int cmpt = 0;
	
	public int getCmpt() {
		return this.cmpt;
	}
	
	public Questionnaire createQuestionnaire(String fileName) {
		this.cmpt++;
		return null;
	}

}
