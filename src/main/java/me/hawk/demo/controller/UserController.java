package me.hawk.demo.controller;

import javax.inject.Inject;
import javax.inject.Named;

import me.hawk.demo.model.User;
import me.hawk.demo.repository.UserRepository;

import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/user")
public class UserController extends RepositoryBasedRestController<User, Long, UserRepository> {

    @Inject
    @Named("userRepository")
    @Override
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
    
}
