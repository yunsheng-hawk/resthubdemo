package me.hawk.demo.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import me.hawk.demo.model.User;
import me.hawk.demo.repository.UserRepository;
import me.hawk.demo.service.UserService;

import org.resthub.common.service.CrudServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Named("userService")
public class UserServiceImpl extends CrudServiceImpl<User, Long, UserRepository> implements UserService {

	@Override
	@Inject
	public void setRepository(UserRepository repository) {
		super.setRepository(repository);
	}


}
