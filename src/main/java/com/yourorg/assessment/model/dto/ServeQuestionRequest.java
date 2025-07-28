package com.yourorg.assessment.model.dto;

public class ServeQuestionRequest {

    private String sessionId;
    private Long questionId;
    private Object response; // Can be of different types
    private int timeTakenSec;

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

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public int getTimeTakenSec() {
        return timeTakenSec;
    }

    public void setTimeTakenSec(int timeTakenSec) {
        this.timeTakenSec = timeTakenSec;
    }
}
