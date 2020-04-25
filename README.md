# Questionnaire

**Project made by**

MORTELIER ANTOINE and DEBACHY ALEXANDRE

**PROJECT IDEA**

Recreate a textual of a graphic questionnaire and answer to the questions !
You can make your own file of questions ; what you must do is :

* Create a text file that must respect the format :
  * Question
  * Answer
  * Number of points
  * Type of the answer
* Put it in the <fichiers-questionnaire> repository
* Launch the jar file and enjoy !

# Howto

## Before following the instructions bellow, do the following command :

>$ cd mortelier-debachy-coo/COO-TP4/

**Generate the game**

>$ git clone https://gitlab-etu.fil.univ-lille1.fr/mortelier/mortelier-debachy-coo.git

**Generate the javadoc**

>$ mvn javadoc:javadoc

**Generate the project**

>$ mvn package

**Execute the project**

>$ java -jar target/COO-TP4-1.0-SNAPSHOT.jar

**Get the UML**

* Answer UML

>$ mirage UML/answer_UML.png

or select the .png file in COO-TP4/UML/answer_UML.png

* Questionnaire UML

>$ mirage UML/questionnaire_UML.png

or select the .png file in COO-TP4/UML/questionnaire_UML.png
