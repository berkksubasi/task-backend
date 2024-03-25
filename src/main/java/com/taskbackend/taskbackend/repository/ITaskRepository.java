package com.taskbackend.taskbackend.repository;

import com.taskbackend.taskbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long> {

    Task findByTask(String task);
}
