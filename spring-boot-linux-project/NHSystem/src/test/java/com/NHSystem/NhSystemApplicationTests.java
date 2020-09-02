package com.NHSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.NHSystem.entities.Task;
import com.NHSystem.entities.User;
import com.NHSystem.services.TaskService;
import com.NHSystem.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NhSystemApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;

	@Before
	public void intDb() {
		
		{
			User newUser = new User("landryUser@gmail.com", "landryUser", "123User");
			userService.createUser(newUser);
		}
		
		{
			User newUser = new User("landryAdmin@gmail.com", "landryAdmin", "123Admin");
			userService.createUser(newUser);
		}
		
		Task userTask = new Task("06/10/2019", "02h15", "05h45", "working in spring boot");
		User user =userService.getUserByEmail("landryUser@gmail.com");
		taskService.addTask(userTask, user);
		
	}
	
	@Test
	public void testUser() {
		
		User user = userService.getUserByEmail("landryUser@gmail.com");
		assertNotNull(user);
		System.out.println(user.getEmail());
		
		User admin = userService.getUserByEmail("landryAdmin@gmail.com");
		assertEquals(admin.getEmail(), "landryAdmin@gmail.com");
		System.out.println(admin.getEmail());
		
	}
	
	@Test
	public void testTask() {
		
		User user = userService.getUserByEmail("landryUser@gmail.com");
		assertNotNull(user);
		
		/*List<Task> tasks = taskService.findUserTask(user);
		assertNotNull(tasks);*/
		
	}
	
	@Test
	public void contextLoads() {
	}

}
