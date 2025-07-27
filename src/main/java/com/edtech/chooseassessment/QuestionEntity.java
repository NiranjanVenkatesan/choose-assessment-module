package com.edtech.chooseassessment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
