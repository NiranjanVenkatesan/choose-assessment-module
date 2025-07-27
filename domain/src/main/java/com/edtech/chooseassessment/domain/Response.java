package com.edtech.chooseassessment.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Response {

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
