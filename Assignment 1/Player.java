package asmt01ec;

/**
 * SFSU CSC220 Data Structures
 * **************************** PLEASE DO NOT CHANGE THIS FILE ***********
 * @author Duc Ta PLUS
 */
public class Player extends Person {

    private String position;
    private String bats;
    private String throwz;
    private int yearMLBDebut;
    private Club club;
    private int number;

    public Player() {
    }

    public Player(String firstName, String lastName,
            String position, String bats, String throwz,
            int yearMLBDebut, Club club, int number) {

        super(firstName, lastName);
        this.position = position;
        this.bats = bats;
        this.throwz = throwz;
        this.yearMLBDebut = yearMLBDebut;
        this.club = club;
        this.number = number;
    }

    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName() + ", " + this.number + "";
    }

    public String toStringPlayerInfo() {
        String returnString;
        returnString = "\n---"
                + "\nPlayer: \t" + super.toString()
                + "\nClub: \t\t" + this.club.getCurrentOfficialName()
                + "\nPosition: \t" + this.position
                + "\nNumber: \t" + this.number
                + "\nBats: \t\t" + this.bats
                + "\nThrows: \t" + this.throwz
                + "\nMLB Debut: \t" + this.yearMLBDebut;
        return returnString;
    }
}
