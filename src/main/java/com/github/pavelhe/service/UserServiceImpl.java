package com.github.pavelhe.service;

import java.util.*;

import com.github.pavelhe.model.*;
import com.github.pavelhe.repository.*;
import com.netflix.hystrix.contrib.javanica.annotation.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    @HystrixCommand(fallbackMethod = "fallback")
    public int save(User user) {
        if (userExist(user))
            throw new IllegalArgumentException("User already exist");
        repository.save(user);
        return UserService.USER_CREATED;
    }

    private int fallback(User user) {
        log.info("User with name " + user.getName() + " already exist. Try another name.");
        return UserService.USER_EXIST;
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id).get());
    }

    private boolean userExist(User user) {
        return repository.findByName(user.getName()).isPresent();
    }
}
