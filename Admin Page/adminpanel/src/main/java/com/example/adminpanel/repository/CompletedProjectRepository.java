package com.example.adminpanel.repository;

import com.example.adminpanel.model.CompletedProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedProjectRepository extends JpaRepository<CompletedProject, Long> {
}
