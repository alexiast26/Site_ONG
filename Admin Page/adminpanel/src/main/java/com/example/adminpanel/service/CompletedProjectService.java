package com.example.adminpanel.service;

import com.example.adminpanel.model.CompletedProject;
import com.example.adminpanel.repository.CompletedProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class CompletedProjectService {
    private final CompletedProjectRepository repository;
    private final Path uploadPath;

    public CompletedProjectService(CompletedProjectRepository repository) {
        this.repository = repository;
        this.uploadPath = Paths.get("uploads").toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Nu se poate crea directorul pentru upload!", e);
        }
    }

    public List<CompletedProject> getAll() {
        return repository.findAll();
    }

    public CompletedProject addProject(String title, String description, MultipartFile image) throws IOException {
        CompletedProject project = new CompletedProject();
        project.setTitle(title);
        project.setDescription(description);

        if (image != null && !image.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
            Path targetLocation = uploadPath.resolve(fileName);
            Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            project.setImagePath("/uploads/" + fileName);
        }

        return repository.save(project);
    }

    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
}