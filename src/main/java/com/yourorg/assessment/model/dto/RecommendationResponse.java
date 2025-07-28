package com.yourorg.assessment.model.dto;

import java.util.List;

public class RecommendationResponse {

    private List<Object> studyTips; // Define a proper StudyTip DTO

    public List<Object> getStudyTips() {
        return studyTips;
    }

    public void setStudyTips(List<Object> studyTips) {
        this.studyTips = studyTips;
    }
}
