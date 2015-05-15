package sboot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by sohail on 13/05/15.
 */
//@Qualifier("b")
@Component
public class TimestampProvider {
    /**
     * Provides millisecond precision.
     */
    public ZonedDateTime getNow() {
        ZonedDateTime timePoint = ZonedDateTime.now();
        return timePoint;
    }
}


//LocalDateTime timePoint = LocalDateTime.now();
//java.time.ZonedDateTime z;

//com.datastax.driver.core.TimestampGenerator x= new AtomicMonotonicTimestampGenerator();
//com.datastax.driver.core.TimestampGenerator x= new ThreadLocalMonotonicTimestampGenerator();
//com.datastax.driver.core.TimestampGenerator x= new AtomicMonotonicTimestampGenerator();
//AbstractMonotonicTimestampGenerator

//java.time.LocalTime
//java.time.Instant
//java.time.ZonedDateTime
//ZonedDateTime   is an immutable representation of a date-time with a time-zone.

//LocalDateTime
//ZoneTime  /In what ase will it be used?

