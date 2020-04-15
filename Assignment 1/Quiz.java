package asmt01ec;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class Quiz {

    private final String topic;
    private final ArrayList<QuestionAnswer> questionAnswer;
    private String studentPrompt;
    private String clubPrompt;
    
    // Default Questions
    
    
    public Quiz() {
        this.questionAnswer = new ArrayList();
        this.topic = "OOP & SF Giants";
    }
    
    public void makeDefaultQuiz(String studentPrompt, String clubPrompt) {
        this.studentPrompt = studentPrompt;
        this.clubPrompt = clubPrompt;
        this.questionAnswer.add(new QuestionAnswer(
                "Which type of class has 'protected' constructors?",
                "Abstract"));
        this.questionAnswer.add(new QuestionAnswer(
                "What type of method did Java 8 add to Interface?",
                "Default"));
        this.questionAnswer.add(new QuestionAnswer(
                "Giants in Spanish?",
                "Gigantes"));
    }
    
    public void printQuiz() {
        for (int i = 0; i < this.questionAnswer.size(); i++) {
            System.out.println(this.questionAnswer.get(i).getQuestion());
            System.out.println(this.questionAnswer.get(i).getAnswer());
            System.out.println();
        }
    }
    
    
    // Return true when all answers are correct.
    public boolean runQuiz() {
        Scanner input = new Scanner(System.in);
        String tmpAnswer;
        Boolean allCorrect = true;
        for (int i = 0; i < this.questionAnswer.size(); i++) {
            System.out.println(this.clubPrompt + this.questionAnswer.get(i).getQuestion());
            System.out.print(this.studentPrompt);
            tmpAnswer = (input.nextLine());
            if (tmpAnswer.toLowerCase() == null ? this.questionAnswer.get(i).getAnswer().toLowerCase() == null : tmpAnswer.toLowerCase().equals(this.questionAnswer.get(i).getAnswer().toLowerCase())) {
                System.out.println(this.clubPrompt + "Correct!");
            }
            else {
                System.out.println(this.clubPrompt + "Sorry, that answer is incorrect.");
                allCorrect = false;
            }
        }
        return allCorrect;
    }
}
