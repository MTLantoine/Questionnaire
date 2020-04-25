package questionnaire.question;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MockQuestionnaire extends Questionnaire {
	
	private int cmpt;

	public MockQuestionnaire()
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		super();
		this.cmpt = 0;
	}
	
	public int getCmpt() {
		return this.cmpt;
	}
	
	public void askAll() {
		this.cmpt++;
	}

}
