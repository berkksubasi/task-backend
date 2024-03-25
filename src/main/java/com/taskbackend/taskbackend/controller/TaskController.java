package com.taskbackend.taskbackend.controller;

import com.taskbackend.taskbackend.model.Task;
import com.taskbackend.taskbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Create Task
    @PostMapping("/tasks/create")
    public Task createTask(@RequestBody Task task) {
        System.out.println("Creating Task: " + task.getTask());
        return taskService.createTask(task);
    }

    // Update Task
    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        System.out.println("Updating Task with ID: " + id);
        return taskService.updateTask(id, task);
    }

    // Delete Task
    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        System.out.println("Deleting Task with ID: " + id);
        taskService.deleteTaskById(id);
    }

    // Get all Tasks
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
