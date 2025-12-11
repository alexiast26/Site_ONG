package com.example.adminpanel.service;

import com.example.adminpanel.model.UpcomingProject;
import com.example.adminpanel.repository.UpcomingProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class UpcomingProjectService {
    private final UpcomingProjectRepository repository;
    private final Path uploadPath;

    public UpcomingProjectService(UpcomingProjectRepository repository) {
        this.repository = repository;
        this.uploadPath = Paths.get("uploads").toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.uploadPath);
        } catch (IOException e) {
            throw new RuntimeException("Nu se poate crea directorul pentru upload!", e);
        }
    }

    public List<UpcomingProject> getAll() {
        return repository.findAll();
    }

    public UpcomingProject addProject(String title, String description, MultipartFile image) throws IOException {
        UpcomingProject project = new UpcomingProject();
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

    public void deleteProject(Long id){
        repository.deleteById(id);
    }
}