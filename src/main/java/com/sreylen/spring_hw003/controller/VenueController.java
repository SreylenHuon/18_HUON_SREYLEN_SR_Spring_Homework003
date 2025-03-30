package com.sreylen.spring_hw003.controller;


import com.sreylen.spring_hw003.model.entity.Venue;
import com.sreylen.spring_hw003.repository.VenueRepository;
import com.sreylen.spring_hw003.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpLogging;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
@RequiredArgsConstructor
public class VenueController {
//    private final VenueService venueService;


    //findAllVenue
@GetMapping
    public  List<Venue>  getAllVenue(){

    return VenueService.getAllvenue();
}

//findVenueById
    @GetMapping("/{venue-id}")
    public ResponseEntity<?>  getVenueById(@PathVariable("venue-id") Long venueId){
    Venue venue = VenueService.getVenueById(venueId);
    try {
        if (venue == null){
            throw new NotFoundException("Venue id "+venueId+"not found");
        }
    }catch (NotFoundException e){
       ErrorResponse errorResponse = new ErrorResponse(
           e.getMessage(),
           HttpStatus.NOT_FOUND
       );
       return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(venue, HttpStatus.OK);
    }

    //createVenue
    @PostMapping
    public  Venue addVenue(@RequestBody Venue venue){
    return null;
    }

    //deleteStudentById
    @DeleteMapping
    public  void deleteVenue(@RequestBody Venue venue){
    return;
    }

    //updateVenueById
    @PutMapping("/{id}")
    public  Venue updateVenue(@PathVariable Long id, @RequestBody Venue venue){
    return null;
    }







}
