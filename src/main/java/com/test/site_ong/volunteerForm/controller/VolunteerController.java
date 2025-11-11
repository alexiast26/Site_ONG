package com.test.site_ong.volunteerForm.controller;

import com.test.site_ong.dto.ErrorResponse;
import com.test.site_ong.volunteerForm.model.Volunteer;
import com.test.site_ong.volunteerForm.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//base URL for all methods in the controller
@RequestMapping("/api/volunteers")
public class VolunteerController {
    //dependency injection (we inject the service)
    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @PostMapping
    public ResponseEntity<?> addForm(@RequestBody Volunteer form) {
        try{
            Volunteer savedForm = volunteerService.submitNewForm(form);
            return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
        }catch(IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid Submission", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Volunteer> getAllVolunteers(){
        return volunteerService.getAllForms();
    }
}
