package com.jhaavesh.Taskmanagementsystem.Service.Implementation;

import com.jhaavesh.Taskmanagementsystem.Model.Project;
import com.jhaavesh.Taskmanagementsystem.Model.User;
import com.jhaavesh.Taskmanagementsystem.Repository.ProjectRepository;
import com.jhaavesh.Taskmanagementsystem.Service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {

    private final ProjectRepository projectRepository;

    // Constructor Injection
    public ProjectServiceImp(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
   public Project saveProject(Project project) {
        Project savedProject = projectRepository.save(project);
        return savedProject;
    }

    @Override
    public Project getProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Long id, Project project) {

        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        existingProject.setProjectName(project.getProjectName());
        existingProject.setDescription(project.getDescription());

        return projectRepository.save(existingProject);
    }

    @Override
    public void deleteProject(Long id) {

        Project existingProject = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        projectRepository.delete(existingProject);
    }
}
