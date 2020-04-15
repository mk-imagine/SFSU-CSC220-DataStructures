package asmt01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class Club {
    
    private int yearEstablished;
    private ArrayList<String> owners;
    private ArrayList<String> colors;
    private String currentOfficialName;
    private String shortName;
    private String currentBallpark;
    private int numWorldSeriesTitles;
    private int numNLPennants;
    private int numDivisionTitles;
    private int numWildCardBerths;
    private Manager manager;
    private GeneralManager generalManager;
    private President presidentOfBaseballOperations;
    private ArrayList<Player> players;
    
    public Club() {
    }

    // added public so constructor could be accessed by other classes
    public Club(int yearEstablished, String[] owners, String[] colors, String currentOfficialName, String shortName, String currentBallpark, 
            int numWorldSeriesTitles, int numNLPennants, int numDivisionTitles, int numWildCardBerths, Manager manager, GeneralManager generalManager, 
            President presidentOfBaseballOperations) {
        
        this.yearEstablished = yearEstablished;
        this.owners = new ArrayList<>(Arrays.asList(owners));
        this.colors = new ArrayList<>(Arrays.asList(colors));
        this.currentOfficialName = currentOfficialName;
        this.shortName = shortName;
        this.currentBallpark = currentBallpark;
        this.numWorldSeriesTitles = numWorldSeriesTitles;
        this.numNLPennants = numNLPennants;
        this.numDivisionTitles = numDivisionTitles;
        this.numWildCardBerths = numWildCardBerths;
        this.manager = manager;
        this.generalManager = generalManager;
        this.presidentOfBaseballOperations = presidentOfBaseballOperations;
    }
    
    
    
    /*
     * GETTERS
     */
    
    // Player[]
    public ArrayList<Player> getPlayers() {
        return this.players;
    }
    
    // Official Name of Club
    public String getCurrentOfficialName() {
        return currentOfficialName;
    }
    
    // Short Name of Club
    public String getShortName() {
        return this.shortName;
    }
    
    /*
     * SETTERS
     */
    
    public void addPlayers(Player[] players) {
        this.players = new ArrayList<>(Arrays.asList(players));
    }
    
    
    /*
     * DISPLAY METHODS
     */
    
    // List of Players in Club
    public void listPlayers() {
        System.out.println("Players:");
        this.players.forEach((player) -> {
            System.out.println(player + " ");
        });
    }
    
    /*
     * Convert ArrayList to StringBuilder Object
     */
    
    // List of contents of an ArrayList<String> as a StringBuilder Object without '[' and ']'
    private Object returnArrayListAsString(ArrayList<String> arrayList) {
        StringBuilder returnString = new StringBuilder(arrayList.toString());
        returnString.deleteCharAt(0);
        returnString.deleteCharAt(returnString.length() - 1);
        return returnString;
    }
    
    @Override
    public String toString() {
        String returnString;
        returnString = "\n---"
                + "\nClub: \t\t\t" + this.currentOfficialName
                + "\nShort Name: \t\t" + this.shortName
                + "\nEstablished in: \t" + this.yearEstablished
                + "\nColors: \t\t" + returnArrayListAsString(colors)
                + "\nBallpark: \t\t" + this.currentBallpark
                + "\nWorld Series Titles: \t" + this.numWorldSeriesTitles
                + "\nNL Pennants: \t\t" + this.numNLPennants
                + "\nDivision Titles: \t" + this.numDivisionTitles
                + "\nWild Card Berths: \t" + this.numWildCardBerths
                + "\nOwners: \t\t" + returnArrayListAsString(owners)
                + "\nPresident: \t\t" + this.presidentOfBaseballOperations
                + "\nGeneral Manager: \t" + this.generalManager
                + "\nManager: \t\t" + this.manager;
        return returnString;
    }
}
