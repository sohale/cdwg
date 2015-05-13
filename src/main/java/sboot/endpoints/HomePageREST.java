package sboot.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sohail on 13/05/15.
 * Following: https://spring.io/guides/gs/authenticating-ldap/#initial
 */
@RestController //plain text output, no json. no `view`s
public class HomePageREST {

    @RequestMapping("/") //The default method is GET
    public String page(){
        return "Welcome to BCwd Web App";
    }
}
