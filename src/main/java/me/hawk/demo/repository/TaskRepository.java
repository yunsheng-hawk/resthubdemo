package me.hawk.demo.repository;

import me.hawk.demo.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
	Task findByTitle(String title);
}
