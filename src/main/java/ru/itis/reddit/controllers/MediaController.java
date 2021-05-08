package ru.itis.reddit.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class MediaController {
    @GetMapping("/media")
    public void getImage(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("image/jpeg");
        String path = request.getParameter("path");
        File file = new File(path);

        try (InputStream inputStream = new FileInputStream(file)) {
            response.getOutputStream().write(inputStream.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/media", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@RequestParam String name) throws IOException {
        InputStream inputStream = new FileInputStream(new File(name));
        return inputStream.readAllBytes();
    }
}
