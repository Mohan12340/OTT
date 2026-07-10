package com.training.ott.service.impl;

import com.training.ott.model.User;
import com.training.ott.repository.UserRepository;
import com.training.ott.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {

        User existing = repository.findById(id).orElseThrow();

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPlan(user.getPlan());

        return repository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
