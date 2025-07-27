package com.edtech.chooseassessment;

import java.time.LocalDateTime;
import java.util.List;

public class Question {

    private Long id;
    private String subject;
    private String classStandard;
    private String chapter;
    private String subChapter;
    private String body;
    private List<String> options;
    private String answer;
    private List<String> tags;
    private String difficulty;
    private String calibrationMeta;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and setters
}
