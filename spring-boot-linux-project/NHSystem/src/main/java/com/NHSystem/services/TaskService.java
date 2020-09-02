package com.NHSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NHSystem.entities.Task;
import com.NHSystem.entities.User;
import com.NHSystem.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired 
	TaskRepository taskRepo;
	
	public void addTask(Task task,User user) {
		task.setUser(user);
		taskRepo.save(task);
	}
	
	public List<Task> findUserTask(User user){
		return taskRepo.findByUser(user);
	}
}
