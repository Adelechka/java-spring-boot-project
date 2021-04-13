package ru.itis.reddit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.reddit.model.User;
import ru.itis.reddit.repositories.UsersRepository;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getUserByUsername(String username) {
        return usersRepository.findByLogin(username).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public List<User> findAllByOrderById() {
        return usersRepository.findAllByOrderById();
    }

    @Override
    public void banById(Long id) {
        User user = usersRepository.getOne(id);
        if (!user.isAdmin()) {
            user.setState(User.State.BANNED);
            usersRepository.save(user);
        }
    }

    @Override
    public void unbanById(Long id) {
        User user = usersRepository.getOne(id);
        if (!user.isAdmin()) {
            user.setState(User.State.ACTIVE);
            usersRepository.save(user);
        }
    }
}
