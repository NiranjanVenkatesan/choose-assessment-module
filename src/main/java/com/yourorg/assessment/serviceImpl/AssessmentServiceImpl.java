package com.yourorg.assessment.serviceImpl;

import com.yourorg.assessment.model.dto.ServeQuestionRequest;
import com.yourorg.assessment.model.dto.StartSessionRequest;
import com.yourorg.assessment.service.AssessmentService;
import org.springframework.stereotype.Service;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Override
    public void startSession(StartSessionRequest request) {
        // TODO: Implement this method
    }

    @Override
    public void serveQuestion(ServeQuestionRequest request) {
        // TODO: Implement this method
    }

    @Override
    public void getSessionStatus(String sessionId) {
        // TODO: Implement this method
    }
}
