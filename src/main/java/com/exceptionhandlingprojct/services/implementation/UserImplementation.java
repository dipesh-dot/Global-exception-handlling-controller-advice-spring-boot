package com.exceptionhandlingprojct.services.implementation;

import com.exceptionhandlingprojct.advice.CustomException;
import com.exceptionhandlingprojct.advice.ResourceNotFoundException;
import com.exceptionhandlingprojct.entity.User;
import com.exceptionhandlingprojct.repository.UserRepository;
import com.exceptionhandlingprojct.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserImplementation implements UserService {

    private final UserRepository userRepository;

    public UserImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new CustomException.NotFoundException("User not found with id: " + id));
    }
}
