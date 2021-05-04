package ru.itis.reddit.services;

import ru.itis.reddit.dto.UserForm;
import ru.itis.reddit.model.User;

public interface SignUpService {
    User signUp(UserForm form);
}
