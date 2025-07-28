package com.yourorg.assessment.service;

import com.yourorg.assessment.model.dto.RecommendationResponse;

import java.util.UUID;

public interface RecommendationService {
    RecommendationResponse getRecommendations(UUID studentUuid);
}
