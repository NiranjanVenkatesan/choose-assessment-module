package com.yourorg.assessment.service;

import com.yourorg.assessment.model.dto.StartSessionRequest;
import com.yourorg.assessment.model.dto.ServeQuestionRequest;

public interface AssessmentService {
    void startSession(StartSessionRequest request);
    void serveQuestion(ServeQuestionRequest request);
    void getSessionStatus(String sessionId);
}
