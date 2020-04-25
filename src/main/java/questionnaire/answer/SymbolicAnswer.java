package questionnaire.answer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.*;

import javax.swing.*;

public class SymbolicAnswer extends Answer {
	
	/**
	 * 
	 * @param answer the answer of the question
	 */
	public SymbolicAnswer(String answer) {
		super(answer);
	}

	/**
	 * 
	 * @return the description of the type of answer
	 */
	public String typeToString() {
		return "Symbolic";
	}

	@SuppressWarnings("unused")
	/**
	 * 
	 * @param proposition the proposition wrote by the user
	 * @return <code>true</code> if the type of the proposition is correct, <code>false</code> else
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public Boolean isCorrectType(String proposition) throws NoSuchMethodException, SecurityException {
		Class<?> cls = Integer.class;
		Method method = cls.getDeclaredMethod("valueOf", String.class);
		

		if (method != null) {
		    try {
		        Object obj = method.invoke(null, proposition);       
		        return false;

		    } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException ex) {
		    	return true;
		    }
		}
		return false;
	}

	@Override
	/**
	 * 
	 * @return the list of all possible answers
	 */
	protected List<String> getListAnswers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @return a panel for the corresponding answer
	 */
	public JPanel getGraphicAnswer() {
		JPanel panel = new JPanel();
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(200, 24));
		text.setSize(100, 100);
		text.addKeyListener(new TextFieldListener());
		panel.add(text, BorderLayout.SOUTH);
		return panel;
	}
	
	public class TextFieldListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * 
		 * change the proposition the user made on graphic interface
		 * everytime he writes an other text
		 */
		public void keyReleased(KeyEvent e) {
			SymbolicAnswer.super.propositionGraphic = ((JTextField) e.getSource()).getText();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	
}
