package com.NHSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NHSystem.entities.Task;
import com.NHSystem.entities.User;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
