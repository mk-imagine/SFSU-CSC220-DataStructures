package asmt01ec;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * SFSU CSC220 Data Structures
 * **************************** PLEASE DO NOT CHANGE THIS FILE ***********
 * @author Duc Ta PLUS
 */
public class Messenger {

    public static void main(String[] args) {

        /* 
            SF Giants
         */
        int yearEstablished = 1883;
        String[] owners = {"San Francisco Baseball Associates LLC"};
        String[] colors = {"Orange", "Black", "Gold", "Cream"};
        String currentOfficialName = "San Francisco Giants";
        String shortName = "SF Giants";
        String currentBallpark = "AT&T";
        int numWorldSeriesTitles = 8;
        int numNLPennants = 23;
        int numDivisionTitles = 8;
        int numWildCardBerths = 3;
        Club sfGiants = new Club();

        /*
            SF Giants Front Office
         */
        // President of Baseball Operations
        President presidentOfBaseballOperations
                = new President("Brian", "Sabean", sfGiants);
        // General Manager
        GeneralManager generalManager = new GeneralManager("Bobby", "Evans", sfGiants);
        // General
        Manager manager = new Manager("Bruce", "Bochy", sfGiants);

        /*
            SF Giants Club
         */
        sfGiants = new Club(yearEstablished, owners, colors,
                currentOfficialName, shortName, currentBallpark,
                numWorldSeriesTitles, numNLPennants, numDivisionTitles, numWildCardBerths,
                manager, generalManager, presidentOfBaseballOperations);

        /*
            SF Giants Players
         */
        // Buster Posey, Madison Bumgarner
        Player[] players = {
            new Player("Buster", "Posey", "Catcher", "Right", "Right", 2009, sfGiants, 28),
            new Player("Madison", "Bumgarner", "Starting Pitcher", "Right", "Left", 2009, sfGiants, 40),
            new Player("Shaun", "Anderson", "Starting Pitcher", "Right", "Right", 2019, sfGiants, 64),
            new Player("Tyler", "Austin", "First Baseman", "Right", "Right", 2016, sfGiants, 19),
            new Player("Tyler", "Beede", "Starting Pitcher", "Right", "Right", 2018, sfGiants, 38),
            new Player("Brandon", "Belt", "First Baseman", "Left", "Left", 2011, sfGiants, 9),
            new Player("Brandon", "Crawford", "Shortstop", "Left", "Right", 2011, sfGiants, 35),
            new Player("Steven", "Duggar", "Center Field", "Left", "Right", 2018, sfGiants, 6),
            new Player("Sam", "Dyson", "Relief Pitcher", "Right", "Right", 2012, sfGiants, 49),
            new Player("Trevor", "Gott", "Relief Pitcher", "Right", "Right", 2015, sfGiants, 58),
            new Player("Derek", "Holland", "Starting Pitcher", "Left", "Left", 2009, sfGiants, 45),
            new Player("Evan", "Longoria", "Third Baseman", "Right", "Right", 2008, sfGiants, 10),
            new Player("Mark", "Melancon", "Relief Pitcher", "Right", "Right", 2009, sfGiants, 41),
            new Player("Reyes", "Moronta", "Relief Pitcher", "Right", "Right", 2017, sfGiants, 54),
            new Player("Joe", "Panik", "Second Baseman", "Left", "Right", 2014, sfGiants, 12),
            new Player("Kevin", "Pillar", "Center Field", "Right", "Right", 2013, sfGiants, 1),
            new Player("Drew", "Pomeranz", "Starting Pitcher", "Right", "Left", 2011, sfGiants, 37),
            new Player("Dereck", "Rodriguez", "Starting Pitcher", "Right", "Right", 2018, sfGiants, 57),
            new Player("Jeff", "Samardzija", "Starting Pitcher", "Right", "Right", 2008, sfGiants, 29),
            new Player("Pablo", "Sandoval", "Third Baseman", "Left", "Right", 2008, sfGiants, 48),
            new Player("Will", "Smith", "Relief Pitcher", "Right", "Left", 2012, sfGiants, 13),
            new Player("Donovan", "Solano", "Second Baseman", "Right", "Right", 2012, sfGiants, 7),
            new Player("Stephen", "Vogt", "Catcher", "Left", "Right", 2012, sfGiants, 21),
            new Player("Tony", "Watson", "Relief Pitcher", "Left", "Left", 2011, sfGiants, 56),
            new Player("Mike", "Yastrzemski", "Left Field", "Left", "Left", 2019, sfGiants, 5),
        };

        // Add players to club
        sfGiants.addPlayers(players);

        /*
            Chat Sessions
         */
        
        // REMOVED FROM ORIGINAL
        // Player sfGiantsPlayer = sfGiants.getPlayers().get(0);
        // ChatSession chatBox = new ChatSession(sfGiants, sfGiantsPlayer);
        
        ChatSession chatBox = new ChatSession(sfGiants);
        getStdOutStdErr();
        chatBox.runChatSession();

        /*
            A few tests:
         */
        System.out.println("");
        System.out.println("---test INTERFACE");
        // sfGiantsPlayer.sayHello();
        // sfGiantsPlayer.sayHello(manager.getFirstName());

        System.out.println("---test ABSTRACT CLASS");
        System.out.println(presidentOfBaseballOperations.toStringAboutInfo());
        System.out.println(generalManager.toStringAboutInfo());
        System.out.println(manager.toStringAboutInfo());

        /*
        System.out.println("---test CLASS ASSOCIATION");
        if (sfGiantsPlayer instanceof Person) {
            System.out.println("YES!");
        }
        if (presidentOfBaseballOperations instanceof Person) {
            System.out.println("YES!");
        }
        if (generalManager instanceof Person) {
            System.out.println("YES!");
        }
        if (manager instanceof Person) {
            System.out.println("YES!");
        }
        */

        System.out.println("---test QUIZ");
        chatBox.getQuiz().printQuiz();
        
        System.out.println("---test LOG FILE");
        System.out.println(chatBox.getLog().getLogFileRelativePath());
        System.out.println(chatBox.getLog().getLogFileName());

        System.out.println("---test LOG");
        chatBox.getLog().getLogData().forEach((line) -> {
            System.out.println(line);
        });
    }
    
    private static void getStdOutStdErr() {
        try {
            FileOutputStream stdOutFile = new FileOutputStream("src/asmt01ec/standardOut.log");
            FileOutputStream stdErrFile = new FileOutputStream("src/asmt01ec/standardErr.log");

            StdOutStdErr allStdOut = new StdOutStdErr(System.out, stdOutFile);
            StdOutStdErr allStdErr = new StdOutStdErr(System.err, stdErrFile);

            PrintStream stdOut = new PrintStream(allStdOut);
            PrintStream stdErr = new PrintStream(allStdErr);

            System.setOut(stdOut);
            System.setErr(stdErr);

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());

        }

        System.out.println("A copy of what I print in the console goes to \"standardOut.log\"");
        System.err.println("ERROR: Error messages are copied to \"standardErr.log\"");
    }
}