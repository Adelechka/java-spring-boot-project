package ru.itis.reddit.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadUtilImpl implements FileUploadUtil {
    @Override
    public void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) {
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path uploadPath = Paths.get(uploadDir);
            Files.createDirectories(uploadPath);
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Could not save image file: " + fileName, ioe);
        }
    }
}
