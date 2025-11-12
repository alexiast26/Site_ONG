package com.test.site_ong.donators.controller;

import com.test.site_ong.donators.model.Donators;
import com.test.site_ong.donators.service.DonatorsService;
import com.test.site_ong.dto.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/donators")
@RequiredArgsConstructor
public class DonatorsController {
    //dependency injection(we inject the service)
    private final DonatorsService donatorsService;

    @PostMapping
    public ResponseEntity<?> addDonators(@RequestBody Donators donators) {
        try{
            Donators savedDonators = donatorsService.saveDonators(donators);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDonators);
        }catch(IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Invalid Submission" , e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<List<Donators>> getAllDonators(){
        List<Donators> allDonators = donatorsService.findAllDonators();
        return ResponseEntity.ok(allDonators);
    }

    @GetMapping("/api/donators/by-date")
    public ResponseEntity<?> getDonatorsBySubmitDate(LocalDateTime startDate, LocalDateTime endDate) {
        List<Donators> donatorsByDate = donatorsService.findBySubmitDate(startDate, endDate);
        if (!donatorsByDate.isEmpty()) {
            return ResponseEntity.ok(donatorsByDate);
        }else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No donators found" , "No donations were found in the given date");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDonatorById(@PathVariable Integer id) {
        Optional<Donators> donator = donatorsService.findDonatorById(id);
        if (donator.isPresent()) {
            return ResponseEntity.ok(donator.get());
        }else {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No donator found" , "No donators were found in the given id");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDonatorById(@PathVariable Integer id) {
        try {
            donatorsService.deleteDonator(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (IllegalArgumentException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Donator not found" , e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

}
