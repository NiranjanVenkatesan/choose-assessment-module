package com.yourorg.assessment.repository;

import com.yourorg.assessment.model.entity.AssessmentSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentSessionRepository extends JpaRepository<AssessmentSession, String> {
}
