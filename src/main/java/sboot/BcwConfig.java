package sboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sohail on 11/05/15.
 */
@Configuration
public class BcwConfig {
    //Must be non static
    @Bean //Both @Bean and @Value are needed.
    @Value("${graph.shape}") //Could not resolve placeholder 'graph.shape' in string value "${graph.shape}"
    public GameInstance createGameInstance(String graphShape) {
        System.out.println("BcwConfig.createGameInstance was called with parameter graphShape=" + graphShape + " len=" + graphShape.length());
        GameInstance g= new GameInstance(graphShape);
        g.simple();
        //UserState us = new UserState("Jack");
        //g.players.put(7L, us);
        //assert g.players.size()==1;
        return g;
    }


}
