package com.test.site_ong.volunteerForm.service;

import com.test.site_ong.volunteerForm.model.Volunteer;
import com.test.site_ong.volunteerForm.repo.VolunteerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {
    //dependency injection (we inject the repository)
    private final VolunteerRepo volunteerRepository;

    @Autowired
    public VolunteerService(VolunteerRepo volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }


    //saving a new form into our database
    public Volunteer submitNewForm(Volunteer form){


        if (volunteerRepository.findByEmail(form.getEmail()) != null){
            throw new IllegalArgumentException("A volunteer form with this email already exists.");
        }

        if (form.getPhone_number().length() > 16){
            throw new IllegalArgumentException("Phone number is too long, please enter a valid phone number.");
        }else{
            if (volunteerRepository.findByPhoneNumber(form.getPhone_number()) != null){
                throw new IllegalArgumentException("A volunteer form with this phone number already exists.");
            }
        }

        if (form.getDesccription().length() > 400){
            throw new IllegalArgumentException("Description is too long, please limit to 400 characters.");
        }

        return volunteerRepository.save(form);
    }

    //extracting all volunteer forms from our database
    public List<Volunteer> getAllForms(){
        return volunteerRepository.findAll();
    }
}
