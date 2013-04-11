package me.hawk.demo;

import javax.inject.Inject;
import javax.inject.Named;

import org.resthub.common.util.PostInitialize;

import me.hawk.demo.model.Task;
import me.hawk.demo.model.User;
import me.hawk.demo.repository.TaskRepository;
import me.hawk.demo.repository.UserRepository;

@Named("taskInitializer")
public class TaskInitializer {

    @Inject
    @Named("taskRepository")
    private TaskRepository taskRepository;
    
    @Inject
    @Named("userRepository")
    private UserRepository userRepository;

    @PostInitialize
    public void init() {
    	User u1 = userRepository.save(new User("u1"));
    	User u2 = userRepository.save(new User("u2"));
    	
        taskRepository.save(new Task("task1", u1));
        taskRepository.save(new Task("task2", u1));
        taskRepository.save(new Task("task3", u2));
        taskRepository.save(new Task("task4"));
    }
}
