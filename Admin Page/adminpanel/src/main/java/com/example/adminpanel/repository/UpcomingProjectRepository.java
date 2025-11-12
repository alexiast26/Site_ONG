package com.example.adminpanel.repository;

import com.example.adminpanel.model.UpcomingProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpcomingProjectRepository extends JpaRepository<UpcomingProject, Long> {
}
