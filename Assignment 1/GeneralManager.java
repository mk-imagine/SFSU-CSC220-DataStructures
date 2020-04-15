package asmt01ec;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class GeneralManager extends FrontOffice {

    private final String POSITION = "General Manager";

    //private Club baseballClub;

    public GeneralManager() {

    }

    public GeneralManager(String firstName, String lastName, Club baseballClub) {
        super(firstName, lastName, baseballClub);
    }

    @Override
    public String toStringAboutInfo() {
        return this.toString() + ", " + this.POSITION + " --- I control player transactions and bear the primary responsibility "
                + "on behalf of the ball club during contract discussions with players.";
    }
}
