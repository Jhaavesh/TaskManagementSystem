package com.jhaavesh.Taskmanagementsystem.Service;

import com.jhaavesh.Taskmanagementsystem.Model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    Task updateTask(Long id, Task taskDetails);

    void deleteTask(Long id);

    List<Task> getAllTasks();
}
