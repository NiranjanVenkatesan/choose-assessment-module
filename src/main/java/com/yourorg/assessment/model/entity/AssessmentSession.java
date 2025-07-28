package com.yourorg.assessment.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "assessment_sessions")
public class AssessmentSession {

    @Id
    private String id;
    private UUID studentUuid;
    private String subject;
    private String chapter;
    private String tags;
    private int numQuestions;
    private int currentQuestionNum;
    private boolean isComplete;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    // Getters and setters
}
