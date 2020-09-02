package com.NHSystem.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.NHSystem.entities.Task;
import com.NHSystem.services.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/addTask")
	public String taskForm(String email,Model model,HttpSession session) {
		
		session.setAttribute("email", email);
		model.addAttribute("task", new Task());
		
		return "views/taskForm";
	}
	
	/*@PostMapping("/addTask")
	public String taskForm(@Valid Task task,BindingResult bindingResult) {
		
		return "";
	}*/
	
}
