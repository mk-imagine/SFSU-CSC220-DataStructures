package asmt01;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class President extends FrontOffice {

    private final String POSITION = "President of Baseball Operations";
    
    public President() {
    }

    public President(String firstName, String lastName, Club baseballClub) {
        super(firstName, lastName, baseballClub);
    }

    @Override
    public String toStringAboutInfo() {
        return this.toString() + ", " + this.POSITION + " --- I oversee and control all club things.";
    }
}
