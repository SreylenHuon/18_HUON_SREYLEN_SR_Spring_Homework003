package com.sreylen.spring_hw003.repository;

import com.sreylen.spring_hw003.model.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {
    @Results(id = "eventMapper",value = {
            @Result(property ="eventId",column = "event_id"),
            @Result(property = "eventName",column = "event_name"),
            @Result(property = "eventDate",column = "event_date"),
            @Result(property = "venue",column = "venue_id",one=@One(select = "org.example._10_pon_cahannarith_pp_spring_homework003.repository.VenueRepository.getAllVenueById"))
    })
    @Select("""
        SELECT * FROM events;
   """)
    List<Event> getAllEvent(int offset, int size);

    List<Event> getAllEvent();
}
