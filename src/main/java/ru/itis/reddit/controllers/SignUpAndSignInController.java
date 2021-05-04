package ru.itis.reddit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.reddit.dto.UserForm;
import ru.itis.reddit.model.User;
import ru.itis.reddit.services.SignUpService;
import ru.itis.reddit.utils.FileUploadUtil;

import javax.annotation.security.PermitAll;
import java.util.Objects;
import java.util.UUID;

@Controller
public class SignUpAndSignInController {
    @Autowired
    private SignUpService signUpService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Value("${path.user-photo}")
    private String userPhotoPath;


    @Value("${path.user-photo-for-html}")
    private String userPhotoPathForHtml;


    @PermitAll
    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in_page";
    }

    @PermitAll
    @PostMapping("/signUp")
    public String signUp(UserForm form, @RequestParam("image") MultipartFile multipartFile) {

        if (multipartFile != null) {
            String fileName = UUID.randomUUID().toString() + "."
                    + StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())).split("\\.")[1]);
            form.setPhotos(userPhotoPathForHtml + fileName);
            User newUser = signUpService.signUp(form);

            String uploadDir = userPhotoPath + newUser.getId();
            fileUploadUtil.saveFile(uploadDir, userPhotoPath + newUser.getId() + "\\/" + fileName, multipartFile);
        } else {
            signUpService.signUp(form);
        }
        return "redirect:/signIn";
    }

}
