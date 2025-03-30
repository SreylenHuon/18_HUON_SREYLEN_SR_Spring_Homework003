package com.sreylen.spring_hw003.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AttendeeRequest {
    private String attendeeName;
    private String email;
}