package questionnaire.answer;

import java.awt.Dimension;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NumericalAnswer extends Answer {
	
	/**
	 * 
	 * @param answer the answer of the question
	 */
	public NumericalAnswer(String answer) {
		super(answer);
	}

	/**
	 * 
	 * @return the description of the type of answer
	 */
	public String typeToString() {
		return "Numerical";
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
		        return true;

		    } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException ex) {
		    	return false;
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
		JSpinner spinner = new JSpinner(/*new SpinnerNumberModel(50,0,100,1)*/);
		JSpinner.NumberEditor spinnerEditor = new JSpinner.NumberEditor(spinner);
		spinner.setPreferredSize(new Dimension(200, 40));
		spinner.setEditor(spinnerEditor);
		spinnerEditor.getModel().setStepSize(1);
		spinnerEditor.getModel().setValue(0);
		spinner.addChangeListener(new SpinnerChangeListenner());
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().addKeyListener(new SpinnerKeyListener());
		panel.add(spinner);
		return panel;
	}
	
	public class SpinnerChangeListenner implements ChangeListener {

		/**
		 * 
		 * change the proposition the user made on graphic interface
		 * everytime he select an other value
		 */
		public void stateChanged(ChangeEvent e) {
			NumericalAnswer.super.propositionGraphic = "" + ((JSpinner) e.getSource()).getValue();
		}

	}
	
	public class SpinnerKeyListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * 
		 * change the proposition the user made on graphic interface
		 * everytime he write an other value
		 */
		public void keyReleased(KeyEvent e) {
			NumericalAnswer.super.propositionGraphic = ((JTextField) e.getSource()).getText();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}
