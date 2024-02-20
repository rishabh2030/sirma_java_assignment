package com.rishabh.sirma_java_assignment.service;

import com.rishabh.sirma_java_assignment.dto.ProjectDto;
import com.rishabh.sirma_java_assignment.model.Project;
import com.rishabh.sirma_java_assignment.service.exception.ProjectNotFoundException;

import java.util.List;

public interface ProjectService {
    Project createProject(ProjectDto projectDto);

    Project updateProject(ProjectDto projectDto) throws ProjectNotFoundException;

    List<Project> getAllProject();

    Project getProjectById(long projectId) throws ProjectNotFoundException;

    void deleteProject(long projectId) throws ProjectNotFoundException;
}
