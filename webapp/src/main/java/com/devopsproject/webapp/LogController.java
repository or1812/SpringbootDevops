package com.devopsproject.webapp;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RestController
public class LogController {
    private LogRepo logRepo;

    @GetMapping("**")
    public String saveLog(HttpServletRequest request) {
        String route = request.getRequestURI();
        LocalDateTime timestamp = LocalDateTime.now();
        String message = "Request made on " + timestamp + " to route: " + route;
        Log log = new Log(message);
        logRepo.save(log);
        return message;
    }

    @GetMapping("/logs")
    List<Log> getAllLogs(){
        String route = "/logs";
        LocalDateTime timestamp = LocalDateTime.now();
        String message = "Request made on " + timestamp + " to route: " + route;
        Log log = new Log(message);
        logRepo.save(log);
        return logRepo.findAll();
    }
}
