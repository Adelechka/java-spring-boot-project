package ru.itis.reddit.dto;

import lombok.Data;

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String photos;
    private String login;
    private String password;
}
