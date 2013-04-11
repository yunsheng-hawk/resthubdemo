package me.hawk.demo.service;

import me.hawk.demo.model.Task;

import org.resthub.common.service.CrudService;

public interface TaskService extends CrudService<Task, Long> {
	Task affectTask(Long taskId, Long userId);
}
