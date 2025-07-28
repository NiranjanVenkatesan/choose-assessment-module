package com.yourorg.assessment.service;

import com.yourorg.assessment.model.dto.ServeQuestionRequest;
import com.yourorg.assessment.model.dto.ServeQuestionResponse;
import com.yourorg.assessment.model.dto.StartSessionRequest;
import com.yourorg.assessment.model.dto.StartSessionResponse;
import com.yourorg.assessment.model.entity.AssessmentSession;
import com.yourorg.assessment.repository.AssessmentSessionRepository;
import com.yourorg.assessment.serviceImpl.AssessmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssessmentServiceTest {

    @Mock
    private AssessmentSessionRepository assessmentSessionRepository;

    @Mock
    private QuestionService questionService;

    @Mock
    private RedisTemplate<String, Object> redisTemplate;

    @InjectMocks
    private AssessmentServiceImpl assessmentService;

    @Test
    public void testStartSession() {
        StartSessionRequest request = new StartSessionRequest();
        request.setStudentUuid(UUID.randomUUID());
        request.setSubject("Math");
        request.setChapter("Algebra");
        request.setTags(Collections.singletonList("Equations"));

        ValueOperations<String, Object> valueOperations = mock(ValueOperations.class);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);

        StartSessionResponse response = assessmentService.startSession(request);

        assertEquals(10, response.getTotalQuestions());
        assertEquals(1, response.getQuestionNum());
    }

    @Test
    public void testServeQuestion() {
        ServeQuestionRequest request = new ServeQuestionRequest();
        request.setSessionId("test-session");
        request.setQuestionId(1L);
        request.setResponse("4");
        request.setTimeTakenSec(30);

        AssessmentSession session = new AssessmentSession();
        session.setId("test-session");
        session.setNumQuestions(10);
        session.setCurrentQuestionNum(1);

        ValueOperations<String, Object> valueOperations = mock(ValueOperations.class);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get("test-session")).thenReturn(session);

        ServeQuestionResponse response = assessmentService.serveQuestion(request);

        assertEquals(2, response.getQuestionNum());
        assertEquals(10, response.getTotalQuestions());
        assertEquals(8, response.getRemainingQuestions());
        assertEquals(false, response.isComplete());
    }

    @Test
    public void testServeQuestion_sessionNotFound() {
        ServeQuestionRequest request = new ServeQuestionRequest();
        request.setSessionId("test-session");

        ValueOperations<String, Object> valueOperations = mock(ValueOperations.class);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
        when(valueOperations.get("test-session")).thenReturn(null);

        ServeQuestionResponse response = assessmentService.serveQuestion(request);

        assertEquals(null, response);
    }
}
