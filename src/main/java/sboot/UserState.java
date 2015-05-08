package sboot;

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

    public String getPublicName(){
        return "Dr S";
    }
    public String getPrivateName(){
        return "Havij";
    }
    public boolean isOnScreen(){
        return false;
    }
    public int lastChoice(){
        return lastChoice;
    }

    public void setChoice(int choice){
        this.lastChoice = choice;
    }

    public UserStateSummaryView getSummary(){
        return new UserStateSummaryView(0,"Name:"+getPublicName()+" OnApp: "+isOnScreen());
    }
    public UserState(){
        System.out.println("Constructed: UserState");
    }
}

/*
class UserEntity {
    private final long uid;
    private final String name;
}
*/