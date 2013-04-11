package me.hawk.demo.service;

import javax.inject.Inject;
import javax.inject.Named;

import me.hawk.demo.model.Task;
import me.hawk.demo.model.User;

import org.fest.assertions.api.Assertions;
import org.resthub.test.AbstractTest;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

@ActiveProfiles("resthub-jpa")
public class TaskServiceTest extends AbstractTest {
	@Inject
	@Named("taskService")
	private TaskService taskService;
	
	@Inject
	@Named("userService")
	private UserService userService;
	
	@Test
    public void testAffectTask() {
		User u1 = new User("u1");
		User u2 = new User("u2");
		Task t1 = new Task("task1");
		u1 = userService.create(u1);
		u2 = userService.create(u2);
		t1 = taskService.create(t1);
		
		t1 = taskService.affectTask(t1.getId(), u1.getId());
		Assertions.assertThat(t1.getUser().getId()).isEqualTo(u1.getId());
		
		t1 = taskService.affectTask(t1.getId(), u2.getId());
		Assertions.assertThat(t1.getUser().getId()).isEqualTo(u2.getId());
		
	}
}
