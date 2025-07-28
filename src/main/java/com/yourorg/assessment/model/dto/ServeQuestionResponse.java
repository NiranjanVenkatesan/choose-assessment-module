package com.yourorg.assessment.model.dto;

import com.yourorg.assessment.model.entity.Question;

public class ServeQuestionResponse {

    private int questionNum;
    private int totalQuestions;
    private Question question;
    private Object progress; // Define a proper Progress DTO
    private int remainingQuestions;
    private boolean complete;
    private Object feedback; // Define a proper Feedback DTO
    private Object finalSummary; // Define a proper FinalSummary DTO
    private Object nextSteps; // Define a proper NextSteps DTO

    // Getters and setters
}
