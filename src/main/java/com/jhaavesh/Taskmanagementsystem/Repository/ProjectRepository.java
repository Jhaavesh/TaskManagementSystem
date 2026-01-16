package com.jhaavesh.Taskmanagementsystem.Repository;

import com.jhaavesh.Taskmanagementsystem.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
