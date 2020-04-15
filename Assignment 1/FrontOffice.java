package asmt01ec;

/**
 * SFSU CSC220 Data Structures
 * **************************** PLEASE DO NOT CHANGE THIS FILE ***********
 * @author Duc Ta PLUS
 */
public abstract class FrontOffice extends Person {

    private Club baseballClub;
    
    protected FrontOffice() {
    }
    
    protected FrontOffice(String firstName, String lastName, Club baseballClub) {
        super(firstName, lastName);
        this.baseballClub = baseballClub;
    }
    
    public abstract String toStringAboutInfo (); 
}
