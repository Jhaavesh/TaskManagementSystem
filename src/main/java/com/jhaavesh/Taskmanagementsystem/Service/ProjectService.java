package com.jhaavesh.Taskmanagementsystem.Service;

import com.jhaavesh.Taskmanagementsystem.Model.Project;
import com.jhaavesh.Taskmanagementsystem.Model.User;

import java.util.List;

public interface ProjectService {

        Project saveProject(Project project);

        Project getProjectById(Long id);

        List<Project> getAllProjects();

        Project updateProject(Long id, Project project);

        void deleteProject(Long id);
    }

