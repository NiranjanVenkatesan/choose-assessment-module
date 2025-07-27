package com.edtech.chooseassessment.app;

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
    public void startSession(@RequestBody StartSessionRequest request) {
        assessmentService.startSession(request);
    }

    @PostMapping("/serve-question")
    public void serveQuestion(@RequestBody ServeQuestionRequest request) {
        assessmentService.serveQuestion(request);
    }

    @GetMapping("/session-status")
    public void getSessionStatus(@RequestParam String session_id) {
        assessmentService.getSessionStatus(session_id);
    }

}
