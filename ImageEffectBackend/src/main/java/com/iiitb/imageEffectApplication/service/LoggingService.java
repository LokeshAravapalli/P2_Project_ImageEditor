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
    private final String logFilePath = "logs.txt"; 

    public void addLog(String fileName, String effectName, String optionValues) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(dateTimeFormatter);
        LogModel new_log = new LogModel(formattedDateTime,fileName,effectName,optionValues);
        this.logs.add(new_log);

        String logString = formattedDateTime+"#"+fileName+"#"+effectName+"#"+optionValues;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true))) {
            writer.write(logString);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<LogModel> getAllLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader("logs.txt"))) {
            String line;
            logs.clear();
            while ((line = reader.readLine()) != null) {
                String[] logData = line.split("#");
                if (logData.length >= 4) {
                    String formattedDateTime = logData[0];
                    String fileName = logData[1];
                    String effectName = logData[2];
                    String optionValues = logData[3];
                    LogModel new_log = new LogModel(formattedDateTime,fileName,effectName,optionValues);
                    this.logs.add(new_log);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        List<LogModel> logsByEffect = new ArrayList<LogModel>();
        for (LogModel log : logs) {
            if(log.getEffectName().equals(effectName)){
                logsByEffect.add(log);
            }
        }
        return logsByEffect;
    }

    public void clearLogs() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(logFilePath, false))) {
            writer.print(""); // Clears the content of the file
            System.out.println("File content cleared successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logs.clear();
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        List<LogModel> logsWithinTimestamps = new ArrayList<>();
        for (LogModel log : logs) {
            String logTimestamp = log.getTimestamp();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime parsedDateTime = LocalDateTime.parse(logTimestamp, dateTimeFormatter); 
            if (parsedDateTime.isAfter(startTime) && parsedDateTime.isBefore(endTime)) {
                logsWithinTimestamps.add(log);
            }
        }
        return logsWithinTimestamps;
    }

}
