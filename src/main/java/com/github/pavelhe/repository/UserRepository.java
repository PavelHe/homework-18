package com.github.pavelhe.repository;


import java.util.*;

import com.github.pavelhe.model.*;
import org.springframework.data.repository.*;

public interface UserRepository extends CrudRepository<User, Long>{

    List<User> findAll();

    Optional<User> findByName(String name);
}
