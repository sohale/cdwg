package sboot;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by sohail on 13/05/15.
 */
@Component
public class TimestampProvider {
    /**
     * Provides millisecond precision.
     */
    public LocalDateTime getNow() {
        LocalDateTime timePoint = LocalDateTime.now();
        return timePoint;
    }
}



//com.datastax.driver.core.TimestampGenerator x= new AtomicMonotonicTimestampGenerator();
//com.datastax.driver.core.TimestampGenerator x= new ThreadLocalMonotonicTimestampGenerator();
//com.datastax.driver.core.TimestampGenerator x= new AtomicMonotonicTimestampGenerator();
//AbstractMonotonicTimestampGenerator