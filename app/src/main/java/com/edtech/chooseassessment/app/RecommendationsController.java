package com.edtech.chooseassessment.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/recommendations")
public class RecommendationsController {

    private final RecommendationsService recommendationsService;

    @Autowired
    public RecommendationsController(RecommendationsService recommendationsService) {
        this.recommendationsService = recommendationsService;
    }

    @GetMapping
    public void getRecommendations(@RequestParam UUID student_uuid) {
        recommendationsService.getRecommendations(student_uuid);
    }

}
