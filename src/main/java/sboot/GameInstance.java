package sboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by sohail on 28/04/15.
 */
@Component
public class GameInstance {

    @Value("${graph.shape}")
    public static GameInstance createGameInstance(String graphShape) {
        GameInstance g= new GameInstance(graphShape);
        UserState us = new UserState();
        g.simple(us);
        return g;
    }

    //UserState is for this game. A user (a UserEntity) can have more than one UserState when more tha one game is being played.
    private ArrayList<UserState> players;

    //@Value("${graph.shape}") Cannot be used for constructors
    private GameInstance(String graphShape) {
        assert graphShape.equals("clique");
        //graphShape is/defines the allocation strategy
        //players.add();
        this.players = new ArrayList<>();
    }


    //UserState.newJoins


    //temporary
    public void simple(UserState us){
        this.players.add(us);
        assert this.players.size()==1;
    }


    /*
    public void playerJoins(UserEntity ue){
        //public playerJoins(UserState us){
        //UserState us = null;
        //this.players.add(us);
        UserState us = new UserState(ue); //Generates the first and only instance for this ue.
        this.players.add(us);
    }
    */

    /*
    Candidate properties:
        setName()
        getDate() //TimeStarted
    */

}


//String name, String phoneno