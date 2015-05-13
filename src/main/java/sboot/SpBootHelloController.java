package sboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SpBootHelloController {

    @RequestMapping("/greet")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}
