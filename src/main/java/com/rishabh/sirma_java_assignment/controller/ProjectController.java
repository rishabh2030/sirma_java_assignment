package com.rishabh.sirma_java_assignment.controller;

import com.rishabh.sirma_java_assignment.dto.ProjectDto;
import com.rishabh.sirma_java_assignment.helper.MyResponseObject;
import com.rishabh.sirma_java_assignment.model.Project;
import com.rishabh.sirma_java_assignment.service.ProjectService;
import com.rishabh.sirma_java_assignment.service.exception.ProjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity<Project> createProject(@RequestBody @Valid ProjectDto projectDto) {
        return new ResponseEntity<>(projectService.createProject(projectDto), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Project>> listOfProject() {
        return new ResponseEntity<>(projectService.getAllProject(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId) throws ProjectNotFoundException {
        return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable("id") long projectId, @RequestBody @Valid ProjectDto projectDto) throws ProjectNotFoundException {
        projectDto.setId(projectId);
        return ResponseEntity.ok().body(this.projectService.updateProject(projectDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MyResponseObject> deleteById(@PathVariable("id") long projectId) throws ProjectNotFoundException{
        this.projectService.deleteProject(projectId);
        MyResponseObject responseObject = new MyResponseObject("Project with ID " + projectId + " deleted successfully.");
        return new ResponseEntity<>(responseObject,HttpStatus.OK);
    }

}
