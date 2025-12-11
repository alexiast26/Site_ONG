package com.example.adminpanel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {

    private final Path uploadPath;

    public FileStorageService(@Value("${upload.path:uploads}") String uploadDir) {
        this.uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();

        try {
            // Creează directorul automat la pornirea aplicației
            Files.createDirectories(this.uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Nu se poate crea directorul pentru upload!", e);
        }
    }

    public String storeFile(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = UUID.randomUUID().toString() + extension;

            Path targetLocation = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return filename;
        } catch (IOException e) {
            throw new RuntimeException("Eroare la salvarea fișierului!", e);
        }
    }

    public void deleteFile(String filename) {
        try {
            Path filePath = uploadPath.resolve(filename);
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Eroare la ștergerea fișierului!", e);
        }
    }
}