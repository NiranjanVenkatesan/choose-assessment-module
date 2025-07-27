package com.edtech.chooseassessment.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "responses")
public class ResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID studentUuid;
    private String sessionId;
    private Long questionId;
    private String response;
    private boolean isCorrect;
    private double marksAwarded;
    private double abilityEstimate;
    private String concept;
    private LocalDateTime submittedAt;
    private int timeTakenSec;
    private String feedback;

    // Getters and setters
}
