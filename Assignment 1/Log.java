package asmt01ec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * SFSU CSC220 Data Structures
 *
 * @author Duc Ta PLUS
 */
public class Log {

    private final String LOG_FILE_RELATIVE_PATH;
    private String startTime;
    private String endTime;
    private Player player;
    private Student student;
    private final ArrayList<String> logData;
    private String logFileAbsolutePath;
    private final String logFileRelativePath;
    private String logFileName;

    public Log() {
        this.logData = new ArrayList();
        /**
         * ************* Please match your file path ***********************
         */
        this.LOG_FILE_RELATIVE_PATH = "src/asmt01ec/";
        this.logFileRelativePath = this.LOG_FILE_RELATIVE_PATH;
    }

    public Log(String startTime, String endTime, Player player, Student student, ArrayList<String> logData,
            String logFileAbsolutePath, String logFileRelativePath, String logFileName) {
        /**
         * ************* Please match your file path ***********************
         */
        this.LOG_FILE_RELATIVE_PATH = "src/asmt01ec/";
        this.startTime = startTime;
        this.endTime = endTime;
        this.player = player;
        this.student = student;
        this.logData = logData;
        this.logFileAbsolutePath = logFileAbsolutePath;
        this.logFileRelativePath = this.LOG_FILE_RELATIVE_PATH;
        this.logFileName = logFileName;
    }
    
    // Getters
    
    String getLogFileRelativePath() {
        return this.logFileRelativePath;
    }
    
    String getLogFileName() {
        return this.logFileName;
    }
    
    ArrayList getLogData() {
        return this.logData;
    }
    
    // Setters
    
    public void writeLogToFile(String relativePath, String fileName, ArrayList<String> log) {
        
        String filePath = relativePath + fileName;
        try (FileWriter fw = new FileWriter(filePath); BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < log.size(); i++) {
                  bw.write(log.get(i), 0, log.get(i).length());
                  bw.newLine();
            }
        }
        catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
              
    }
}
