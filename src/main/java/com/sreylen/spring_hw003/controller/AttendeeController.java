package com.sreylen.spring_hw003.controller;

import com.sreylen.spring_hw003.model.entity.Attendee;
import com.sreylen.spring_hw003.model.request.AttendeeRequest;
import com.sreylen.spring_hw003.service.AttendeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @Operation(summary = "Get all attendees")
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllAttendees(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        List<Attendee> attendees = attendeeService.getAllAttendees(page, size);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All attendees have been successfully fetched.");
        response.put("payload", attendees);
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get attendee by Id")
    @GetMapping("/{attendeeId}")
    public ResponseEntity<Map<String, Object>> getAttendeeById(@PathVariable Integer attendeeId) {
        Attendee attendee = attendeeService.getAttendeeById(attendeeId);
        Map<String, Object> response = new LinkedHashMap<>();
        if (attendee != null) {
            response.put("message", "Attendee found.");
            response.put("payload", attendee);
            response.put("status", "OK");
        } else {
            response.put("message", "Attendee not found.");
            response.put("status", "ERROR");
        }
        response.put("time", LocalDateTime.now().toString());

        return attendee != null ? ResponseEntity.ok(response) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @Operation(summary = "Add a new attendee")
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> saveAttendee(@Valid @RequestBody AttendeeRequest request) {
        Attendee savedAttendee = attendeeService.saveAttendee(request);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "The attendee has been successfully added.");
        response.put("payload", savedAttendee);
        response.put("status", "CREATED");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update an attendee")
    @PutMapping("/{attendeeId}")
    public ResponseEntity<Map<String, Object>> updateAttendee(
            @PathVariable Integer attendeeId,
            @Valid @RequestBody AttendeeRequest request
    ) {
        Attendee updatedAttendee = attendeeService.updateAttendee(attendeeId, request);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Attendee updated successfully.");
        response.put("payload", updatedAttendee);
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }
    @Operation(summary = "Delete an attendee")
    @DeleteMapping("/{attendeeId}")
    public ResponseEntity<Map<String, Object>> deleteAttendee(@PathVariable Integer attendeeId) {
        attendeeService.deleteAttendee(attendeeId);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Attendee deleted successfully.");
        response.put("status", "OK");
        response.put("time", LocalDateTime.now().toString());

        return ResponseEntity.ok(response);
    }
}