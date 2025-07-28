package com.yourorg.assessment.service;

import com.yourorg.assessment.model.dto.ServeQuestionRequest;
import com.yourorg.assessment.model.dto.ServeQuestionResponse;
import com.yourorg.assessment.model.dto.SessionStatusResponse;
import com.yourorg.assessment.model.dto.StartSessionRequest;
import com.yourorg.assessment.model.dto.StartSessionResponse;

public interface AssessmentService {
    StartSessionResponse startSession(StartSessionRequest request);
    ServeQuestionResponse serveQuestion(ServeQuestionRequest request);
    SessionStatusResponse getSessionStatus(String sessionId);
}
