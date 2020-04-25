package questionnaire.choices;

public interface Choices {
	
	/**
	 * 
	 * @param proposition the proposition the user made
	 * @return <code>true</code> if the proposition is in the choices enum, <code>false</code> else
	 */
	public boolean isIn(String proposition);

}
