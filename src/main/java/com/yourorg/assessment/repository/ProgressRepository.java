package com.yourorg.assessment.repository;

import com.yourorg.assessment.model.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, UUID> {
}
