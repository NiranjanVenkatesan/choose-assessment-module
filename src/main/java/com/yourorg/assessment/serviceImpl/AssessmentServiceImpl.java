package com.yourorg.assessment.serviceImpl;

import com.yourorg.assessment.model.dto.*;
import com.yourorg.assessment.model.entity.AssessmentSession;
import com.yourorg.assessment.model.entity.Question;
import com.yourorg.assessment.repository.AssessmentSessionRepository;
import com.yourorg.assessment.service.AssessmentService;
import com.yourorg.assessment.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentSessionRepository assessmentSessionRepository;
    private final QuestionService questionService;
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public AssessmentServiceImpl(
            AssessmentSessionRepository assessmentSessionRepository,
            QuestionService questionService,
            RedisTemplate<String, Object> redisTemplate
    ) {
        this.assessmentSessionRepository = assessmentSessionRepository;
        this.questionService = questionService;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public StartSessionResponse startSession(StartSessionRequest request) {
        AssessmentSession session = new AssessmentSession();
        session.setId(UUID.randomUUID().toString());
        session.setStudentUuid(request.getStudentUuid());
        session.setSubject(request.getSubject());
        session.setChapter(request.getChapter());
        session.setTags(String.join(",", request.getTags()));
        session.setNumQuestions(request.getNumQuestions() != null ? request.getNumQuestions() : 10);
        session.setCurrentQuestionNum(1);
        session.setComplete(false);
        session.setStartedAt(LocalDateTime.now());

        assessmentSessionRepository.save(session);

        // TODO: Implement adaptive question fetching
        Question question = new Question();
        question.setId(1L);
        question.setBody("What is 2+2?");
        question.setOptions(List.of("3", "4", "5"));

        redisTemplate.opsForValue().set(session.getId(), session);

        StartSessionResponse response = new StartSessionResponse();
        response.setSessionId(session.getId());
        response.setTotalQuestions(session.getNumQuestions());
        response.setQuestionNum(session.getCurrentQuestionNum());

        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setBody(question.getBody());
        questionDto.setOptions(question.getOptions());
        response.setQuestion(questionDto);

        ProgressDto progressDto = new ProgressDto();
        progressDto.setConcept("Algebra");
        progressDto.setProficiency(0.0);
        progressDto.setLevel("Beginner");
        response.setProgress(progressDto);

        return response;
    }

    @Override
    public ServeQuestionResponse serveQuestion(ServeQuestionRequest request) {
        AssessmentSession session = (AssessmentSession) redisTemplate.opsForValue().get(request.getSessionId());
        if (session == null) {
            // Handle session not found
            return null;
        }

        // TODO: Log previous answer and update state

        session.setCurrentQuestionNum(session.getCurrentQuestionNum() + 1);

        if (session.getCurrentQuestionNum() > session.getNumQuestions()) {
            session.setComplete(true);
            session.setCompletedAt(LocalDateTime.now());
            assessmentSessionRepository.save(session);
            redisTemplate.delete(request.getSessionId());

            ServeQuestionResponse response = new ServeQuestionResponse();
            response.setComplete(true);
            // TODO: Populate final summary and next steps
            return response;
        }

        // TODO: Implement adaptive question fetching
        Question question = new Question();
        question.setId(2L);
        question.setBody("What is 3+3?");
        question.setOptions(List.of("5", "6", "7"));

        redisTemplate.opsForValue().set(session.getId(), session);

        ServeQuestionResponse response = new ServeQuestionResponse();
        response.setQuestionNum(session.getCurrentQuestionNum());
        response.setTotalQuestions(session.getNumQuestions());
        response.setRemainingQuestions(session.getNumQuestions() - session.getCurrentQuestionNum());
        response.setComplete(false);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
        questionDto.setBody(question.getBody());
        questionDto.setOptions(question.getOptions());
        response.setQuestion(questionDto);

        // TODO: Populate progress and feedback
        return response;
    }

    @Override
    public SessionStatusResponse getSessionStatus(String sessionId) {
        AssessmentSession session = (AssessmentSession) redisTemplate.opsForValue().get(sessionId);
        if (session == null) {
            // Handle session not found
            return null;
        }

        SessionStatusResponse response = new SessionStatusResponse();
        response.setQuestionNum(session.getCurrentQuestionNum());
        response.setTotalQuestions(session.getNumQuestions());
        response.setRemainingQuestions(session.getNumQuestions() - session.getCurrentQuestionNum());
        response.setComplete(session.isComplete());

        // TODO: Populate progress
        return response;
    }
}
