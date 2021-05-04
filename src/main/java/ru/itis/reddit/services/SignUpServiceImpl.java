package ru.itis.reddit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.reddit.dto.UserForm;
import ru.itis.reddit.model.User;
import ru.itis.reddit.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signUp(UserForm form) {
        User newUser = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .login(form.getLogin())
                .photos(form.getPhotos())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .role(User.Role.USER)
                .state(User.State.ACTIVE)
                .build();

        return usersRepository.save(newUser);
    }
}
