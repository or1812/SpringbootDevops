package com.devopsproject.webapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// Responsible for seeding the database with a default log entry.
@Configuration
public class SeedDB {
    private static final Logger logger = LoggerFactory.getLogger(SeedDB.class);

/*    A bean that implements the CommandLineRunner interface to run a task during application startup.
      It seeds the database with a default log entry.
       logRepo is used to access the database and save the log entry. */
    @Bean
    CommandLineRunner seed(LogRepo logRepo){
        return args -> {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDateTime = currentDateTime.format(formatter);
            String seedMessage = "Seeding made on " + formattedDateTime;
            Log log = new Log(seedMessage);
            logger.info("Saving seed log to database... ");
            logRepo.save(log);
        };
    }
}
