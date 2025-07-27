package com.edtech.chooseassessment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgressRepository extends JpaRepository<ProgressEntity, UUID> {
}
