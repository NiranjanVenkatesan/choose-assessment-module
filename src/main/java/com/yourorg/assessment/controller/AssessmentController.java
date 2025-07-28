package com.yourorg.assessment.controller;

import com.yourorg.assessment.model.dto.ServeQuestionRequest;
import com.yourorg.assessment.model.dto.ServeQuestionResponse;
import com.yourorg.assessment.model.dto.SessionStatusResponse;
import com.yourorg.assessment.model.dto.StartSessionRequest;
import com.yourorg.assessment.model.dto.StartSessionResponse;
import com.yourorg.assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment")
public class AssessmentController {

    private final AssessmentService assessmentService;

    @Autowired
    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @PostMapping("/start-session")
    public StartSessionResponse startSession(@RequestBody StartSessionRequest request) {
        return assessmentService.startSession(request);
    }

    @PostMapping("/serve-question")
    public ServeQuestionResponse serveQuestion(@RequestBody ServeQuestionRequest request) {
        return assessmentService.serveQuestion(request);
    }

    @GetMapping("/session-status")
    public SessionStatusResponse getSessionStatus(@RequestParam String session_id) {
        return assessmentService.getSessionStatus(session_id);
    }

}
