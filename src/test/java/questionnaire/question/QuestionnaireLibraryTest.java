package questionnaire.question;

import java.io.*;
import java.lang.reflect.*;

import org.junit.*;

import questionnaire.answer.*;
import questionnaire.graphic.*;

public class QuestionnaireLibraryTest {
	
	protected Questionnaire questionnaire;
	protected MockQuestionnaire mockQuestionnaire;
	protected QuestionnaireFactory questionnaireFactory;
	protected MockQuestionnaireFactory mockQuestionnaireFactory;
	protected GraphicQuestionnaire graphicQuestionnaire;
	protected MockGraphicQuestionnaire mockGraphicQuestionnaire;
	protected String questionText;
	protected String answer;
	protected int nbPoints;
	protected QCMAnswer qcmAnwser;
	protected Question question;
	protected String fileName;
	protected Question questionToCreate;
	protected Answer answerToCreate;
	
	@Before
	public void initObjects() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		this.questionText = "Quel est le deuxième jour de la semaine ?";
		this.answer = "Mardi | Lundi | Mercredi | Jeudi | Vendredi | Samedi | Dimanche";
		this.nbPoints = 4;
		this.qcmAnwser = new QCMAnswer(this.answer);
		this.question = new Question(this.questionText, this.qcmAnwser, this.nbPoints);
		this.questionnaire = new Questionnaire();
		this.mockQuestionnaire = new MockQuestionnaire();
		this.questionnaireFactory = new QuestionnaireFactory();
		this.mockQuestionnaireFactory = new MockQuestionnaireFactory();
		this.graphicQuestionnaire = new GraphicQuestionnaire(this.questionnaire);
		this.mockGraphicQuestionnaire = new MockGraphicQuestionnaire(this.questionnaire);
		this.fileName = "fichiers-questionnaire/question_tolkien_2.txt";
	}
	
}
