package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoggingService {
    private ArrayList<LogModel> logs = new ArrayList<LogModel>();

    public void addLog(String fileName, String effectName, String optionValues) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(dateTimeFormatter);
        LogModel new_log = new LogModel(formattedDateTime,fileName,effectName,optionValues);
        this.logs.add(new_log);
    }

    public List<LogModel> getAllLogs() {
        return logs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        List<LogModel> logsByEffect = new ArrayList<LogModel>();
        for (LogModel log : logs) {
            if(log.getEffectName().equals(effectName)){
                logsByEffect.add(log);
            }
           // System.out.println(logs.get(i).getTimestamp());
        }
        return logsByEffect;
    }

    public void clearLogs() {
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
