package asmt01ec;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class Student extends Person {

    public static final String SCHOOL_NAME = "San Francisco State University";
    private String schoolEmailAddress;
    private int numCards;
    private final ArrayList<Card> cards = new ArrayList();

    public Student() {
    }

    public Student(String firstName, String lastName, String schoolEmail) {
        super(firstName, lastName);
        this.schoolEmailAddress = schoolEmail;
    }
    
    /*
     * GETTERS
     */
        
    public String getSchoolEmailAddress() {
        return this.schoolEmailAddress;
    }
    
    public int getCardsSize() {
        return this.cards.size();
    }
    
    public String getCardsRecipient(int cardIndex) {
        return this.cards.get(cardIndex).getCardRecipient();
    }
    
    public String getCardsMessage(int cardIndex) {
        return this.cards.get(cardIndex).getCardMessage();
    }
    
    /*
     * SETTERS
     */
    
    public void addCard(Card card) {
        this.cards.add(card);
    }
    
    public void setSchoolEmailAddress(String schoolEmail) {
        this.schoolEmailAddress = schoolEmail;
    }
    
    /*
     * Display Methods
     */
    
    public void listCards() {
        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println("\t" + this.cards.get(i).toString());
        }
    }
}
