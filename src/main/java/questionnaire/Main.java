package questionnaire;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import questionnaire.graphic.GraphicQuestionnaire;
import questionnaire.question.*;

public class Main {
	
	static String fileName = "fichiers-questionnaire/";
	static Scanner sc = new Scanner(System.in);
	static int typeQuestionnaire;
	
	public static String selectFile() {
		File monRepertoire = new File(fileName);
		File[] f = monRepertoire.listFiles();
		String choice;
		Boolean accept = false;
		int realChoice = 0;
		while (!accept) {
			System.out.println("Parmis les questionnaires suivants, lequel voulez-voulez lancer ?");			
			System.out.println();
			for (int i = 0; i < f.length; i++) {
				System.out.println((i + 1) + " : " + f[i].getName());
			}
			System.out.println();
			choice = sc.nextLine();
			try {			
				realChoice = Integer.parseInt(choice);
				accept = true;
				if (realChoice > f.length || realChoice < 0) {
					accept = false;
					System.out.println("Veuillez renseigner un identifiant compris entre 1 et " + f.length);			
					System.out.println();
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez renseigner l'identifiant du fichier.");			
				System.out.println();
			}
		}
		System.out.println("Vous avez choisi : " + f[realChoice - 1].getName());
		System.out.println();
		accept = false;
		while (!accept) {
			System.out.println("Voulez-vous répondre sous forme textuelle [1] ou sous forme d'une interface graphique [2] ? ");
			int selected;
			choice = sc.nextLine();
			try {			
				selected = Integer.parseInt(choice);
				accept = true;
				typeQuestionnaire = selected;
				if (selected != 1 && selected != 2) {
					accept = false;
					System.out.println("Veuillez renseigner 1 ou 2.");			
					System.out.println();
				}
			} catch (NumberFormatException e) {
				System.out.println("Veuillez renseigner 1 ou 2.");			
				System.out.println();
			}
		}
		return f[realChoice - 1].getName();
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, IOException {
		
		
		QuestionnaireFactory questionnaireFactory = new QuestionnaireFactory();
		fileName += selectFile();
		System.out.println();
		Questionnaire questionnaire = questionnaireFactory.createQuestionnaire(fileName);
		GraphicQuestionnaire gQuestionnaire = new GraphicQuestionnaire(questionnaire);
		switch(typeQuestionnaire) {
		case 1:
			questionnaire.askAll();
			break;
		case 2:
			gQuestionnaire.askAll();
			break;
		}
	}
}
	