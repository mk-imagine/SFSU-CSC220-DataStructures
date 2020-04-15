package asmt01ec;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class Manager extends FrontOffice {

    private final String POSITION = "Manager";
    //private Club baseballClub; UNNECESSARY declaration -- inherited from FrontOffice

    public Manager() {

    }

    public Manager(String firstName, String lastName, Club baseballClub) {
        super(firstName, lastName, baseballClub);
    }

    @Override
    public String toStringAboutInfo() {
        return this.toString() + ", " + this.POSITION + " --- I am the a head coach who is responsible for overseeing and "
                + "making final decisions on all aspects of "
                + "on-field team strategy, lineup selection, "
                + "training and instruction.";
    }
}
