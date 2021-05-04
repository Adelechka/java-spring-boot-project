package ru.itis.reddit.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadUtil {
    void saveFile(String uploadDir, String fileName, MultipartFile multipartFile);
}
