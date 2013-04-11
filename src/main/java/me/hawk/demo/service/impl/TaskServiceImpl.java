package me.hawk.demo.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import me.hawk.demo.model.Task;
import me.hawk.demo.model.User;
import me.hawk.demo.repository.TaskRepository;
import me.hawk.demo.repository.UserRepository;
import me.hawk.demo.service.NotificationService;
import me.hawk.demo.service.TaskService;

import org.resthub.common.service.CrudServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional
@Named("taskService")
public class TaskServiceImpl extends
		CrudServiceImpl<Task, Long, TaskRepository> implements TaskService {

	private UserRepository userRepository;
	private NotificationService notificationService;
	
	@Override
	@Inject
	public void setRepository(TaskRepository repository) {
		super.setRepository(repository);
	}
	
	@Inject
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Inject
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Transactional(readOnly=false)
	@Override
	public Task affectTask(Long taskId, Long userId) {
		Assert.notNull(taskId, "taskId must not be null");
		Assert.notNull(userId, "userId must not be null");
		
		Task task = repository.findOne(taskId);
		Assert.notNull(task, "task must not be null");
		
		User user = userRepository.findOne(userId);
		Assert.notNull(user, "user must not be null");

		// if the owner of task changed
		if (task.getUser() != null && !task.getUser().equals(user)) {
			if (task.getUser().getEmail() != null) 
				notificationService.sendMessage(task.getUser().getEmail(), "The task " + task.getTitle() + " has been removed.");
		}

		task.setUser(user); // change the owner
		if (user.getEmail() != null)
			notificationService.sendMessage(user.getEmail(), "The task " + task.getTitle() + " has been assigned to you");
		task = repository.save(task);

		
		return task;
	}
	
}
