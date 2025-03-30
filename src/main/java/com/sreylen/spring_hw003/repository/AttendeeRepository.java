package com.sreylen.spring_hw003.repository;

import com.sreylen.spring_hw003.model.entity.Attendee;
import com.sreylen.spring_hw003.model.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.awt.*;

@Mapper
public interface AttendeeRepository {
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    @Select("SELECT * FROM attendees LIMIT #{size} OFFSET #{offset}")
    List<Attendee> getAllAttendees(int offset, int size);

    @ResultMap("attendeeMapper")
    @Select("SELECT * FROM attendees WHERE attendee_id = #{attendeeId}")
    Attendee getAttendeeById(@Param("attendeeId") Integer attendeeId);


    @Select("INSERT INTO attendees (attendee_name, email) VALUES" +
            " (#{req.attendeeName}, #{req.email}) RETURNING *")
    @ResultMap("attendeeMapper")
    Attendee saveAttendee(@Param("req") AttendeeRequest request);

    @Update("UPDATE attendees SET attendee_name = #{req.attendeeName}," +
            " email = #{req.email} WHERE attendee_id = #{attendeeId}")
    @ResultMap("attendeeMapper")
    void updateAttendee(@Param("attendeeId") Integer attendeeId, @Param("req") AttendeeRequest request);
    @ResultMap("attendeeMapper")
    @Delete("DELETE FROM attendees WHERE attendee_id = #{attendeeId}")
    void deleteAttendee(@Param("attendeeId") Integer attendeeId);
}