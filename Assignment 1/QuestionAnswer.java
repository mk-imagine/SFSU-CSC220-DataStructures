package asmt01;

/**
 * SFSU CSC220 Data Structures
 * **************************** PLEASE DO NOT CHANGE THIS FILE ***********
 * @author Duc Ta PLUS
 */
class QuestionAnswer {

    private String question;
    private String answer;

    public QuestionAnswer() {

    }

    public QuestionAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    @Override
    public String toString() {
        return this.question + "\n" + this.answer;
    }
}
