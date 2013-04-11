package me.hawk.demo.controller;

import me.hawk.demo.model.Task;

import org.fest.assertions.api.Assertions;
import org.resthub.test.AbstractWebTest;
import org.testng.annotations.Test;

public class TaskControllerTest extends AbstractWebTest {
	
	public TaskControllerTest() {
		super("resthub-web-server,resthub-jpa");
	}
	
//	@Ignore
	@Test
    public void testFindByName() {
        this.request("api/task").xmlPost(new Task("task1"));
        this.request("api/task").xmlPost(new Task("task2"));
        Task task1 = this.request("api/task/4").getJson().resource(Task.class);
        Assertions.assertThat(task1).isNotNull();
//        Assertions.assertThat(task1.getTitle()).isEqualTo("task1");
    }
	
}
