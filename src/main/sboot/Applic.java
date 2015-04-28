package sboot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


// What is an actuator?
// In Spring, REST endpoints are just Spring MVC controllers.

@SpringBootApplication
public class Applic {

    public static void main(String[] args) {
        ApplicationContext ctx =
                SpringApplication.run(
                        Applic.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

}