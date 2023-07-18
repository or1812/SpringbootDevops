package com.devopsproject.webapp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    // The message is the log represented by String, it serves as the primary key for the Log entity.
    @Id
    String message;
}
