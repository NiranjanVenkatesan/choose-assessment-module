package com.yourorg.assessment.model.dto;

import com.yourorg.assessment.model.entity.Question;

public class StartSessionResponse {

    private String sessionId;
    private int totalQuestions;
    private int questionNum;
    private Question question;
    private Object progress; // Define a proper Progress DTO

    // Getters and setters
}
