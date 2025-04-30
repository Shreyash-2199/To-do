package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.Task;
import com.todo.repository.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired private TaskRepository repository;

    public List<Task> getAllTasks() { return repository.findAll(); }

    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task createTask(Task task) { return repository.save(task); }

    public Task updateTask(Long id, Task task) {
        Task existing = getTaskById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setCompleted(task.isCompleted());
        return repository.save(existing);

}

	@Override
	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		
	}
}