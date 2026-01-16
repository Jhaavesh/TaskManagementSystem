package com.jhaavesh.Taskmanagementsystem.Repository;

import com.jhaavesh.Taskmanagementsystem.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
