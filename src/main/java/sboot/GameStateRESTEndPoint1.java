package sboot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by sohail on 28/04/15.
 */
//@RequestMapping("/controller_rest_endpoint1")
@Controller
@RequestMapping("/gamestate")
public class GameStateRESTEndPoint1 {
    //the name was: HelloWorldController

    @Resource
    GameInstance gameinstance; //Todo: reference to the same main Game bean

    //private static final String template = "Hello, %s!";
    //private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public
    @ResponseBody GameInstance //Annotates the return _type_
    myShowGameInfo(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        //return GameInstance.createGameInstance(counter.incrementAndGet(), String.format(template, name));
        System.out.print("this.gameinstance= ");
        System.out.println(this.gameinstance);
        return this.gameinstance; //writes nothing in curl
    }
}
