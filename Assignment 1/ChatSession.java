package asmt01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class ChatSession {

    // Text and Background Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    
    // Chat
    private static final DateTimeFormatter DATE_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy'/'MM'/'dd HH':'mm':'ss"); // pattern for timestamp
    private final String[] messages;
    private String startTime;
    private String endTime;
    private String tmpString;    

    // Club - Player - Student
    private final Club club;
    private final String clubPrompt;
    private final Player player;
    private final String playerPrompt;
    private final Student student;
    private String studentPrompt;
 
    // Quiz
    private final Quiz quiz;
    private Boolean allCorrect = true;
    
    // Log
    private static final String LOG_FILE_ABSOLUTE_PATH = "C:\\Users\\Mark\\Documents\\NetBeansProjects\\CSC 220.01\\src\\asmt01";
    private final ArrayList<String> logData;
    private String logFileRelativePath;
    private Log log;
        
    // Constructor
    public ChatSession() {
        this.club = new Club();
        this.player = new Player();
        this.clubPrompt = this.club.getShortName() + ": ";
        this.playerPrompt = this.player.toString() + ": ";
        this.student = new Student();
        this.studentPrompt = new String();
        this.messages = new String[17];
        this.quiz = new Quiz();
        this.startTime = new String();
        this.endTime = new String();
        this.logData = new ArrayList();
    }
    
    public ChatSession(Club club, Player player) {
        this.club = club;
        this.player = player;
        this.clubPrompt = this.club.getShortName() + ": ";
        this.playerPrompt = this.player.toString() + ": ";
        this.student = new Student();
        this.studentPrompt = new String();
        this.messages = new String[17];   
        this.quiz = new Quiz();
        this.startTime = new String();
        this.endTime = new String ();
        this.logData = new ArrayList();
    }
    
    // Getters
    
    Quiz getQuiz() {
        return this.quiz;
    }
    
    Log getLog() {
        return this.log;
    }
    
    
    // Session Initialization
    private void startChatSession() {
        
        // Set Messages
        this.messages[0] = " Chat session started.";
        this.messages[1] = "\n" + this.clubPrompt + "Welcome to " + club.getCurrentOfficialName().toUpperCase() + "!";
        this.messages[2] = "\n" + this.clubPrompt + "Your first and last name, please: ";
        this.messages[3] = this.clubPrompt + "Your school email address, please: ";
        this.messages[4] = this.clubPrompt + "Thank you. Connecting with a SF Giants player";
        this.messages[5] = " Chat session ended.";
        
        // Get Student Info
        Scanner input = new Scanner(System.in);
        this.startTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        System.out.println(this.startTime + this.messages[0]);
        System.out.print(this.messages[1]);
        System.out.println(this.club.toString());
        System.out.print(this.messages[2]);
        this.student.setFirstName(input.next()); // First Name
        this.student.setLastName(input.next());  // Last Name
        System.out.print(this.messages[3]);
        this.student.setSchoolEmailAddress(input.next()); // schoolEmailAddress
        this.studentPrompt = this.student.toString() + ": ";
        
        // Set Messages
        this.messages[6] = "Hello " + this.student.getFirstName() + "! C-O-N-G-R-A-T-U-L-A-T-I-O-N-S! ";
        this.messages[7] = ChatSession.ANSI_PURPLE_BACKGROUND + ChatSession.ANSI_YELLOW + Student.SCHOOL_NAME.toUpperCase() + ANSI_RESET + ". Way to go!";
        this.messages[8] = "Likewise, " + this.student.getFirstName() + ". Very nice chatting w/ you.";
        this.messages[9] = "How many SF Giants Thank You cards are you getting?";
        this.messages[10] = "In 2 lines, Name and Message for ";
        this.messages[11] = "Thanks, " + this.student.getFirstName() + ". Your order: ";
        this.messages[12] = "Thanks again, " + this.student.getFirstName() + ". See you at your graduation ceremony!";
        this.messages[13] = "\nFREE tickets to SF Giants games this summer! Ace this quiz:";
        this.messages[14] = "See you at the summer games!!!";
        this.messages[15] = "\n***FREE tickets to summer games!***";
        this.messages[16] = "Thank you!";
    }

    // Connect Student w/ Player
    private void connectStudentPlayer() {

        // Connecting...
        System.out.print(this.messages[4]);
        int numDots = 10;
        for (int i = 1; i < numDots; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ChatSession.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (i == 4) {
                // Connected. Display player info.
                System.out.println(this.player.toStringPlayerInfo());
            }
            System.out.print(" .");
        }
        System.out.println("");
    }

    // Chat: Student & Player
    private void chatStudentPlayer() {

        // Congrats
        System.out.println(this.playerPrompt + this.messages[6]);
        System.out.println(this.playerPrompt + this.messages[7]);
        System.out.print(this.studentPrompt);
        
        // Student Response
        Scanner input = new Scanner(System.in);
        String studentResponse1 = input.nextLine();

        // Ask # of Cards
        System.out.println(this.playerPrompt + this.messages[8]);
        System.out.println(this.playerPrompt + this.messages[9]);
        System.out.print(this.studentPrompt);
        int numCards = input.nextInt();
        input.nextLine();
        

        // Recipient and Message for each card
        // this.card = new Card();
        for (int i = 1; i <= numCards; i++) {
            if (i == 1) {
                this.tmpString = this.messages[10] + "the Card #" + i + ", please:";
            }
            else {
                this.tmpString = "the Card #" + i + ", please:";
            }
            System.out.println(this.playerPrompt + this.tmpString);

            // Recipient
            System.out.print(this.studentPrompt);
            String tmpRecipient = input.nextLine();

            // Message
            System.out.print(this.studentPrompt);
            String tmpMessage = input.nextLine();
            
            //this.card = new Card(this.student, tmpRecipient, tmpMessage);
            this.student.addCard(new Card(this.student, tmpRecipient, tmpMessage));

        }

        // Order Summary
        
        System.out.println(this.playerPrompt + this.messages[11]);
        this.student.listCards();

        // Student confirms
        System.out.print(this.studentPrompt);
        input.next();

        // Player leaves 
        System.out.println(this.playerPrompt + this.messages[12]);
    }

    // Perfect = Free tickets to Log
    // Not Perfect = No Log
    private void runQuiz() {
        System.out.println(this.messages[13]);
        // Set quiz
        this.quiz.makeDefaultQuiz(this.studentPrompt, this.clubPrompt);
        // Run Quiz
        if (this.quiz.runQuiz() == true) {
            System.out.println(this.clubPrompt + this.messages[14]);
        }
        else this.allCorrect = false;
    }

    private void endChatSession() {
        this.endTime = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        System.out.println(this.endTime + this.messages[5]);
        System.out.println();
        // Write Log
        this.logData.add(this.startTime + this.messages[0]);
        this.logData.add(this.player.toString());
        this.logData.add(this.student.toString() + ", " + this.student.getSchoolEmailAddress());
        this.logData.add(Integer.toString(this.student.getCardsSize()));
        for (int i = 0; i < this.student.getCardsSize(); i++) {
            this.logData.add(this.student.getCardsRecipient(i));
            this.logData.add(this.student.getCardsMessage(i));
        }
        if (this.allCorrect == true) {
            this.logData.add(this.messages[15]);
        }
        this.logData.add(this.endTime + this.messages[5]);
        
        // Store Log
        String logFileName = "CardOrderDB_"
                + this.student.getFirstName()
                + this.student.getLastName()
                + "_" + this.student.getSchoolEmailAddress()
                + ".txt";
        this.log = new Log(this.startTime, this.endTime, this.player, this.student, this.logData,
            this.LOG_FILE_ABSOLUTE_PATH, this.logFileRelativePath, logFileName);
        this.log.writeLogToFile(this.logFileRelativePath, logFileName, this.logData);
    }

    // A Chat Session
    public void runChatSession() {
        this.startChatSession();
        this.connectStudentPlayer();
        this.chatStudentPlayer();
        this.runQuiz();
        this.endChatSession();
    }
    
}
