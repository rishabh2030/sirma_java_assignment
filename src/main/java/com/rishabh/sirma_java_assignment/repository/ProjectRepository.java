package com.rishabh.sirma_java_assignment.repository;

import com.rishabh.sirma_java_assignment.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
