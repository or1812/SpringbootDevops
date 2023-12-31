package com.devopsproject.webapp;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@RestController
public class LogController {
    private LogRepo logRepo;

    // PostMapping to add custom log if needed
    @PostMapping("/logs")
    Log createLog(@RequestBody Log newLog){
        return logRepo.save(newLog);
    }

    // GET endpoint to save a log entry when accessing the "/newlog" route.
    @GetMapping("/newlog")
    public String saveLog() {
        String route = "/newlog";
        String message = "Request made on " + generateCurrentTime() + " to route: " + route;
        Log log = new Log(message);
        logRepo.save(log);
        return message;
    }

    // GET endpoint to retrieve all logs and save a log entry when accessing the "/logs" route.
    @GetMapping("/logs")
    List<Log> getAllLogs(){
        String route = "/logs";
        String message = "Request made on " + generateCurrentTime() + " to route: " + route;
        Log log = new Log(message);
        logRepo.save(log);
        return logRepo.findAll();
    }

    private String generateCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return currentDateTime.format(formatter);
    }
}
