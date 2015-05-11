package sboot;

import org.springframework.stereotype.Component;
import sboot.endpoints.UserStateSummaryView;

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

    public void setChoice(int choice){
        this.lastChoice = choice;
    }

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

