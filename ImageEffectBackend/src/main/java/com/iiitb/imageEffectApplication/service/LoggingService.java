package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class LoggingService {
    private ArrayList<LogModel> logs = new ArrayList<LogModel>();
    private final String logFilePath = "logs.txt";  //file to store logs

    public void addLog(String fileName, String effectName, String optionValues) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formatting the date time to required format
        String formattedDateTime = dateTime.format(dateTimeFormatter); //converting formatted date time to string
        LogModel new_log = new LogModel(formattedDateTime,fileName,effectName,optionValues); //creating log model
        this.logs.add(new_log); //adding log to list

        String logString = formattedDateTime+"#"+fileName+"#"+effectName+"#"+optionValues; //crteating string to add to logs file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true))) {
            writer.write(logString);
            writer.newLine(); //writing line to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<LogModel> getAllLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("logs.txt"))) {
            String line;
            logs.clear(); //clearing logs before reading to make sure list is empty
            while ((line = reader.readLine()) != null) {
                String[] logData = line.split("#"); //reading from file and splitting
                if (logData.length >= 4) {
                    String formattedDateTime = logData[0];
                    String fileName = logData[1];
                    String effectName = logData[2];
                    String optionValues = logData[3];   
                    LogModel new_log = new LogModel(formattedDateTime,fileName,effectName,optionValues); //creating log model
                    this.logs.add(new_log); //adding to arraylist logs
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs; //retunring the list
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        List<LogModel> logsByEffect = new ArrayList<LogModel>();
        for (LogModel log : logs) {
            if(log.getEffectName().equals(effectName)){ //comparing effect name
                logsByEffect.add(log);
            }
        }
        return logsByEffect; //returning logs by effect
    }

    public void clearLogs() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, false))) {
            writer.print(""); // Clears the content of the file
        } catch (IOException e) {
            e.printStackTrace();
        }
        logs.clear();
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        List<LogModel> logsWithinTimestamps = new ArrayList<>();
        for (LogModel log : logs) {
            String logTimestamp = log.getTimestamp(); 
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formatting string to date time object
            LocalDateTime parsedDateTime = LocalDateTime.parse(logTimestamp, dateTimeFormatter); 
            if (parsedDateTime.isAfter(startTime) && parsedDateTime.isBefore(endTime)) { //checking if it is in required time frame
                logsWithinTimestamps.add(log);
            }
        }
        return logsWithinTimestamps; //returning the required list
    }

}
