package com.edtech.chooseassessment.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "progress")
public class ProgressEntity {

    @Id
    private UUID studentUuid;

    private String sessionId;
    private String concept;
    private double proficiency;
    private String level;
    private LocalDateTime lastUpdated;

    // Getters and setters
}
