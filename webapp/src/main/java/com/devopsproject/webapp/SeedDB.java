package com.devopsproject.webapp;



import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Configuration
@RequestMapping("/")
public class SeedDB {
    private static final Logger logger = LoggerFactory.getLogger(SeedDB.class);
    @Bean
    CommandLineRunner seed(LogRepo logRepo){
        return args -> {
            LocalDateTime timestamp = LocalDateTime.now();
            String seedMessage = "Seeding made on " + timestamp;
            Log log = new Log(seedMessage);
            logger.info("Saving seed log to database... ");
            logRepo.save(log);
        };
    }
}
