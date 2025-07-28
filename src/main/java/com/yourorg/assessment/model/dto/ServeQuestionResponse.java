package com.yourorg.assessment.model.dto;

public class ServeQuestionResponse {

    private int questionNum;
    private int totalQuestions;
    private QuestionDto question;
    private Object progress; // Define a proper Progress DTO
    private int remainingQuestions;
    private boolean complete;
    private Object feedback; // Define a proper Feedback DTO
    private Object finalSummary; // Define a proper FinalSummary DTO
    private Object nextSteps; // Define a proper NextSteps DTO

    public int getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(int questionNum) {
        this.questionNum = questionNum;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public QuestionDto getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDto question) {
        this.question = question;
    }

    public Object getProgress() {
        return progress;
    }

    public void setProgress(Object progress) {
        this.progress = progress;
    }

    public int getRemainingQuestions() {
        return remainingQuestions;
    }

    public void setRemainingQuestions(int remainingQuestions) {
        this.remainingQuestions = remainingQuestions;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Object getFeedback() {
        return feedback;
    }

    public void setFeedback(Object feedback) {
        this.feedback = feedback;
    }

    public Object getFinalSummary() {
        return finalSummary;
    }

    public void setFinalSummary(Object finalSummary) {
        this.finalSummary = finalSummary;
    }

    public Object getNextSteps() {
        return nextSteps;
    }

    public void setNextSteps(Object nextSteps) {
        this.nextSteps = nextSteps;
    }
}
