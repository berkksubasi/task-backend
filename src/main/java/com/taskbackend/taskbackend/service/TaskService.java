package com.taskbackend.taskbackend.service;

import com.taskbackend.taskbackend.model.Task;
import com.taskbackend.taskbackend.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class TaskService {
    private final ITaskRepository taskRepository;

    @Autowired
    public TaskService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        System.out.println("Creating Task: " + task.getTask());
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        System.out.println("Updating Task: " + task.getTask());
        // Implement update logic
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long taskId) {
        System.out.println("Deleting Task: " + taskId);
        taskRepository.deleteById(taskId);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


}
