package sboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

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


    @Bean //A @Bean (method) will be executed once even if called multiple times. (Any @Bean in a @Configuration)
    //@Profile("dev") //Inject only if ...
    public JavaMailSender setMailSender() {
        JavaMailSenderImpl msender = new JavaMailSenderImpl();
        msender.setHost("mail.host.com");
        /*
        try {
            MimeMessage mm = setMailSender().createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mm);
                helper.setTo("received@website.com");
            String plainText = "test";
            helper.setText(plainText);
            msender.send(m?);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        */
        return msender;
    }

}
