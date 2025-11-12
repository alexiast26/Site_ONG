package com.example.adminpanel.service;

import com.example.adminpanel.model.CompletedProject;
import com.example.adminpanel.repository.CompletedProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CompletedProjectService {
    private final CompletedProjectRepository repository;
    private final String uploadDir = "uploads";

    public CompletedProjectService(CompletedProjectRepository repository) {
        this.repository = repository;
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();
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
            File dest = new File(uploadDir + "/" + fileName);
            image.transferTo(dest);
            project.setImagePath("/uploads/" + fileName);
        }

        return repository.save(project);
    }

    public void deleteProject(Long id) {
        repository.deleteById(id);
    }
}
