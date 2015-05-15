package sboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sboot.endpoints.UserStateSummaryView;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.Resource;


/**
 * Instantaneous state of the user in the game.
 * * One instance per game? (no FK for game)
 * Created by sohail on 28/04/15.
 */
public class UserState {
    final static int  NO_CHOICE = -1;
    //private final long id; //todo
    private int lastChoice = NO_CHOICE;

    private String name;

    public String getPublicName(){
        return this.name;
    }
    public String getPrivateName(){
        return this.name;
    }
    public boolean isOnAppScreen(){
        return false;
    }
    public Integer lastChoice(){
        return lastChoice;
    }

    private ZonedDateTime lastTimeSet_REST;
    private ZonedDateTime lastTimeSet_HERE; //We cannot have this because we don't have access to the timer the bean here.
    //private ZonedDateTime lastTimeSet_FRONTEND;
    //private ZonedDateTime lastTimeSet_RECEIVED_FROM_SERVER;
    //private ZonedDateTime lastTimeSet_RECEIVED_FROM_WEBSOCKETS;

    //public ZonedDateTime getLastTimeSet(){
    //    return this.lastTimeSet_REST;
    //}
    public String getLastTimeSet(){
        //DateTimeFormatter f = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        //return this.lastTimeSet_REST.format(f);
        return this.lastTimeSet_REST+"";
    }

    //@Resource //Problem: is not injected.
    //public TimestampProvider timer; //timeProvider; //timerBean


    public void setChoice(int choice, ZonedDateTime ts){
        //todo: only set when changed?
        if (this.lastChoice == choice)
            log.warn("this.lastChoice == choice == "+choice);
        this.lastChoice = choice;
        this.lastTimeSet_REST = ts;
        //System.out.println("*****this.timer="+this.timer);
        //this.lastTimeSet_HERE = this.timer.getNow();
        this.lastTimeSet_HERE = ZonedDateTime.now();
        //ZonedDateTime lastTimeSet_HERE=ZonedDateTime.now();

        String timediff_msec;
        if (this.lastTimeSet_REST != null)
            timediff_msec  = ChronoUnit.MILLIS.between(this.lastTimeSet_REST, this.lastTimeSet_HERE)+"";
        else
            timediff_msec = "N/A";
        log.info(timediff_msec + " (msec) = "+
                 this.lastTimeSet_HERE + " minus " + this.lastTimeSet_REST );

    }

    private static final Log log = LogFactory.getLog(UserState.class);


    //public UserStateSummaryView getSummary(){
    //    return new UserStateSummaryView(0,"Name:"+getPublicName()+" OnApp: "+isOnAppScreen());
    //}

    private UserEntity userEntity=null;
    public UserState(String name){
        //this.userEntity = //new UserEntity
        this.name = name;
        System.out.println("Constructed: UserState");
    }
    public static UserState createUserStateInstance() { // see below: newJoins
        return new UserState("Jack");
    }

    //Todo: Howe to identify a unique user? WHat is the primary key: when adding a "new" user? phone no? an id number in the DB?
    //UserState is not a User class. A Userclass is like a J2EE entity.
    //todo: Factory
    //public static UserState newJoins(UserEntity ue){
    //    return UserState(ue);
    //}
}

/*
class UserEntity {
    private final long uid;
    private final String name;
}
*/

