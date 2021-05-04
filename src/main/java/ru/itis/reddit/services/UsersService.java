package ru.itis.reddit.services;

import ru.itis.reddit.model.User;

import java.util.List;

public interface UsersService {
    User getUserByUsername(String username);
    List<User> findAll();
    List<User> findAllByOrderById();
    void banById(Long id);
    void unbanById(Long id);
    User getUserById(Long id);
}
