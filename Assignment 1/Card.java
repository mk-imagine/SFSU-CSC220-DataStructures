package asmt01ec;

/**
 * SFSU CSC220 Data Structures
 * 
 * @author Duc Ta PLUS
 */
public class Card {

    private Student student;
    private String cardRecipient;
    private String cardMessage;

    public Card () {
        
    }
    
    public Card (Student student, String cardRecipient, String cardMessage) {
        this.student = student;
        this.cardRecipient = cardRecipient;
        this.cardMessage = cardMessage;
    }
    
    /*
     * GETTERS
     */
    
    public String getCardRecipient() {
        return this.cardRecipient;
    }
    
    public String getCardMessage() {
        return this.cardMessage;
    }
    
    @Override
    public String toString() {
        String returnString;
        returnString = "From: " + this.student.toString()
                + " \t Recipient: " + this.cardRecipient
                + " \t Message: " + this.cardMessage;
        return returnString;
    }
}
