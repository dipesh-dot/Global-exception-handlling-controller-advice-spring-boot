package com.exceptionhandlingprojct.services;

import com.exceptionhandlingprojct.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    User create(User user);

     List<User> getAll();
    User getById(Long id);

}
