CREATE DATABASE spring_hw003;
-- create venue
CREATE TABLE venues(
    venue_id SERIAL PRIMARY KEY ,
    venue_name VARCHAR(50),
    location VARCHAR(50)
)
-- create event
CREATE TABLE events (

                        event_id SERIAL PRIMARY KEY,
                        event_name VARCHAR(100) NOT NULL,
                        event_date DATE NOT NULL,
                        venue_id INT NOT NULL,
                        FOREIGN KEY (venue_id)
                            REFERENCES venues(venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT * FROM venues;
SELECT * FROM venues WHERE venue_id IN (1, 2, 3, 4, 5);

-- create attendee
CREATE TABLE attendees (
                           attendee_id SERIAL PRIMARY KEY,
                           attendee_name VARCHAR(100) NOT NULL,
                           email VARCHAR(100) NOT NULL UNIQUE
);
SELECT *FROM attendees;