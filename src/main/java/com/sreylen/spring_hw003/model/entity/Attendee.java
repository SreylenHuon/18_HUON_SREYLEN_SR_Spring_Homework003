package com.sreylen.spring_hw003.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendee {
    private Long id;
    private  String attendeeName;
    private  String email;
}
