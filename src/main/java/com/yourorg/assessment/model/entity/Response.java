package com.yourorg.assessment.model.entity;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getStudentUuid() {
        return studentUuid;
    }

    public void setStudentUuid(UUID studentUuid) {
        this.studentUuid = studentUuid;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public double getMarksAwarded() {
        return marksAwarded;
    }

    public void setMarksAwarded(double marksAwarded) {
        this.marksAwarded = marksAwarded;
    }

    public double getAbilityEstimate() {
        return abilityEstimate;
    }

    public void setAbilityEstimate(double abilityEstimate) {
        this.abilityEstimate = abilityEstimate;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public int getTimeTakenSec() {
        return timeTakenSec;
    }

    public void setTimeTakenSec(int timeTakenSec) {
        this.timeTakenSec = timeTakenSec;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
