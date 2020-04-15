package asmt01;

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
            new Player("Madison", "Bumgarner", "Starting Pitcher", "Right", "Left", 2009, sfGiants, 40)
        };

        // Add players to club
        sfGiants.addPlayers(players);

        /*
            Chat Sessions
         */
        Player sfGiantsPlayer = sfGiants.getPlayers().get(0);
        ChatSession chatBox = new ChatSession(sfGiants, sfGiantsPlayer);
        chatBox.runChatSession();

        /*
            A few tests:
         */
        System.out.println("");
        System.out.println("---test INTERFACE");
        sfGiantsPlayer.sayHello();
        sfGiantsPlayer.sayHello(manager.getFirstName());

        System.out.println("---test ABSTRACT CLASS");
        System.out.println(presidentOfBaseballOperations.toStringAboutInfo());
        System.out.println(generalManager.toStringAboutInfo());
        System.out.println(manager.toStringAboutInfo());

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
}
