package com.example.adminpanel.repository;

import com.example.adminpanel.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {}
