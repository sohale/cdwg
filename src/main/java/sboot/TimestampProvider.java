package sboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


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

    public static class TimeUtils{

        private static final Log log = LogFactory.getLog(TimeUtils.class);

        //what is a final parameter in  a function??
        public static String concatPluralForm(long value, String unitSingularForm, final String unitPluralForm) {
            String u;
            if(value==1)
                u=unitSingularForm;
            else //includes 0
                u=unitPluralForm;
            return value+" "+u+""; //brackets
        }
        public static String concatPluralForm(long value, String unit) {
            char lastChar = unit.toLowerCase().charAt(unit.length()-1); //It is not used. Why is it evaluated at all?
            //if (lastChar=='a')
            return concatPluralForm(value,unit,unit+"s");
        }
        public static String agoNotation(ZonedDateTime lastTime){
            //todo: multiple flavours

            if(lastTime==null)
                return null;

            ZonedDateTime now = ZonedDateTime.now();

            log.debug("lastTime="+lastTime);
            log.debug("now="+now);
            long timediff_msec  = ChronoUnit.MILLIS.between(lastTime, now);
            //assert timediff_msec>=0L;
            if(timediff_msec<0L) {
                log.warn(timediff_msec + " (msec),  now=" + now + " is earlier than last=" + lastTime);
                //return timediff_msec + " (msec) in future!";
            }

            final long SEC=1000L;
            final long MINUTE=SEC*60;
            final long HOUR=MINUTE*60;
            final long DAY=HOUR*24;
            final long WEEK=DAY*7;
            final long MONTH=DAY*31;
            final long YEAR=(long)(((double)DAY)*365.25);
            final long CENTURY=YEAR*100;

            String suffix = " ago";
            if(timediff_msec<0L) {
                suffix = " in future";
                timediff_msec = -timediff_msec; //abs
            }


            log.warn("timediff_msec = " + timediff_msec);

            if (timediff_msec==0L)
                return "0 msec";
            else if (timediff_msec<600L)  //SEC
                //return timediff_msec+" (msec) ago";
                return concatPluralForm(timediff_msec,"msec")+suffix;
            else if (timediff_msec<=MINUTE)
                //return (timediff_msec/SEC)+" (sec) ago";
                return concatPluralForm(timediff_msec/SEC,"sec","sec")+suffix;
            else if (timediff_msec<=DAY)
                //return (timediff_msec/MINUTE)+" (min) ago";
                return concatPluralForm(timediff_msec/MINUTE,"minute")+suffix;
            else if (timediff_msec<=WEEK)
                //return (timediff_msec/DAY)+" (days) ago";
            return concatPluralForm( timediff_msec/DAY ,"day")+suffix;
            else if (timediff_msec<=MONTH)
                //return (timediff_msec/WEEK)+" (weeks) ago";
                return concatPluralForm(  timediff_msec/WEEK ,"week")+suffix;
            else if (timediff_msec<=YEAR)
            return concatPluralForm(  timediff_msec/MONTH ,"month")+suffix;
            else if (timediff_msec<=CENTURY)
                return concatPluralForm(  timediff_msec/YEAR ,"year")+suffix;
            else
                return concatPluralForm(  timediff_msec/YEAR ,"century","centuries")+suffix;
        }
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

