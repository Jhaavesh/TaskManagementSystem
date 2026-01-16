package com.jhaavesh.Taskmanagementsystem.Service.Implementation;

import com.jhaavesh.Taskmanagementsystem.Model.Task;
import com.jhaavesh.Taskmanagementsystem.Repository.TaskRepository;
import com.jhaavesh.Taskmanagementsystem.Service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        existingTask.setTask(taskDetails.getTask());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setStatus(taskDetails.getStatus());
        existingTask.setProjectId(taskDetails.getProjectId());
        existingTask.setUser(taskDetails.getUser());
        existingTask.setCreatedBy(taskDetails.getCreatedBy());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id " + id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }
}