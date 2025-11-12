package com.example.adminpanel.service;

import com.example.adminpanel.model.Volunteer;
import com.example.adminpanel.repository.VolunteerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VolunteerService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    public List<Volunteer> getAll() {
        return volunteerRepository.findAll();
    }

    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }
}
