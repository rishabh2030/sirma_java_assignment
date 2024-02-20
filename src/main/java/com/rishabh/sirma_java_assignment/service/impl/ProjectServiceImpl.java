package com.rishabh.sirma_java_assignment.service.impl;

import com.rishabh.sirma_java_assignment.dto.ProjectDto;
import com.rishabh.sirma_java_assignment.helper.Messages;
import com.rishabh.sirma_java_assignment.model.Project;
import com.rishabh.sirma_java_assignment.repository.ProjectRepository;
import com.rishabh.sirma_java_assignment.service.ProjectService;
import com.rishabh.sirma_java_assignment.service.exception.ProjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(ProjectDto projectDto) {
        Project project_obj = Project.builder()
                .name(projectDto.getName())
                .description(projectDto.getDescription())
                .startDate(projectDto.getStartDate())
                .endDate(projectDto.getEndDate())
                .build();

        return this.projectRepository.save(project_obj);
    }

    @Override
    public Project updateProject(ProjectDto projectDto) throws ProjectNotFoundException  {

        Optional<Project> projectDb = this.projectRepository.findById(projectDto.getId());

        if (projectDb.isPresent()) {
            Project projectUpdate = projectDb.get();
            projectUpdate.setName(projectDto.getName());
            projectUpdate.setDescription(projectDto.getDescription());
            projectUpdate.setStartDate(projectDto.getStartDate());
            projectUpdate.setEndDate(projectDto.getEndDate());
            projectRepository.save(projectUpdate);
            return projectUpdate;
        } else {
            throw new ProjectNotFoundException(Messages.NOT_FOUND_RECORD_ID + projectDto.getId());
        }
    }

    @Override
    public List<Project> getAllProject() {
        return this.projectRepository.findAll();
    }

    @Override
    public Project getProjectById(long projectId) throws ProjectNotFoundException {
        Optional<Project> projectDb = this.projectRepository.findById(projectId);

        if (projectDb.isPresent()) {
            return projectDb.get();
        } else {
            throw new ProjectNotFoundException(Messages.NOT_FOUND_RECORD_ID + projectId);
        }
    }

    @Override
    public void deleteProject(long projectId) throws ProjectNotFoundException {
        Optional<Project> projectDb = this.projectRepository.findById(projectId);

        if (projectDb.isPresent()) {
            this.projectRepository.delete(projectDb.get());
        } else {
            throw new ProjectNotFoundException(Messages.NOT_FOUND_RECORD_ID + projectId);

        }


    }
}
