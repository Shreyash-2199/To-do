package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.Task;
import com.todo.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")

public class TaskController {
	
	@Autowired private TaskService service;

    @GetMapping public List<Task> getAll() { return service.getAllTasks(); }

    @GetMapping("/{id}") public Task getById(@PathVariable Long id) { return service.getTaskById(id); }

    @PostMapping public Task create(@RequestBody Task task) { return service.createTask(task); }

    @PutMapping("/{id}") public Task update(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.deleteTask(id); }
}
