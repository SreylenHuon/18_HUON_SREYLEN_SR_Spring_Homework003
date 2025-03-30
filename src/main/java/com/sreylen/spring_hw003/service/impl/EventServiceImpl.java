package com.sreylen.spring_hw003.service.impl;

import com.sreylen.spring_hw003.model.entity.Event;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;


    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.getAllEvent();
    }

    @Override
    public List<Event> getAllEvent(int page, Integer size) {
        int offset = (page - 1) * size;
        return eventRepository.getAllEvent(offset,size);
    }




}