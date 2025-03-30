package com.sreylen.spring_hw003.controller;

import com.sreylen.spring_hw003.model.entity.Event;
import com.sreylen.spring_hw003.service.EventService;
import com.sreylen.spring_hw003.service.VenueService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;
    private final VenueService venueService; // Added VenueService

    public EventController(EventService eventService, VenueService venueService) {
        this.eventService = eventService;
        this.venueService = venueService;
    }

    @Operation(summary = "Get all events with pagination")
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllEvents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        int offset = (page - 1) * size;
        List<Event> events = eventService.getAllEvent(offset, size);


        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All events have been successfully fetched.");
        response.put("payload", events);
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }

}