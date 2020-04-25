package questionnaire.answer;

import java.util.*;

import javax.swing.*;

public class MockAnswer extends Answer {
	
	private int cmpt;

	public MockAnswer(String answer) {
		super(answer);
		this.cmpt = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean isCorrectType(String proposition) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String typeToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<String> getListAnswers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JPanel getGraphicAnswer() {
		this.cmpt++;
		return null;
	}
	
	public int getCmpt() {
		return this.cmpt;
	}

}
