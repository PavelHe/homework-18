package com.github.pavelhe.service;


import java.util.*;

import com.github.pavelhe.model.*;

public interface UserService {

    int USER_CREATED = 0;
    int USER_EXIST = 1;

    List<User> findAll();

    Long count();

    int save(User user) throws IllegalArgumentException;

    void delete(Long id);

}
