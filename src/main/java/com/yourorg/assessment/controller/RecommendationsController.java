package com.yourorg.assessment.controller;

import com.yourorg.assessment.model.dto.RecommendationResponse;
import com.yourorg.assessment.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/recommendations")
public class RecommendationsController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationsController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public RecommendationResponse getRecommendations(@RequestParam UUID student_uuid) {
        return recommendationService.getRecommendations(student_uuid);
    }

}
