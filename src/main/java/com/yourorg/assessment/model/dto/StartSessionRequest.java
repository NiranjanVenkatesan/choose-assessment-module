package com.yourorg.assessment.model.dto;

import java.util.List;
import java.util.UUID;

public class StartSessionRequest {

    private UUID studentUuid;
    private String subject;
    private String chapter;
    private List<String> tags;
    private Integer numQuestions;

    // Getters and setters
}
