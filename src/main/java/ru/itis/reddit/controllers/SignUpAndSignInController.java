package ru.itis.reddit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.reddit.dto.UserForm;
import ru.itis.reddit.services.SignUpService;

import javax.annotation.security.PermitAll;

@Controller
public class SignUpAndSignInController {
    @Autowired
    private SignUpService signUpService;

    @PermitAll
    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in_page";
    }

//    @PermitAll
//    @GetMapping("/signUp")
//    public String getSignUpPage() {
//        return "sign_up_page";
//    }

    @PermitAll
    @PostMapping("/signUp")
    public String signUp(UserForm form) {
        signUpService.signUp(form);
        return "redirect:/signIn";
    }

}
