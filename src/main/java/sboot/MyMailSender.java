package sboot;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMessage;

/**
 * Created by sohail on 12/05/15.
 */
@Component
public abstract class MyMailSender implements JavaMailSender {
    //todo: remove this

    //JavaMailSender

    /*
    public JavaMailSender setMailSender() {
        JavaMailSenderImpl msender = new JavaMailSenderImpl();
        msender.setHost("mail.host.com");
        return msender;
    }
    */

    public void notifyUserViaEmail(Long uid, String message){

    }
    protected void sendEmail(String emailaddress, String message) throws MessagingException {
        JavaMailSenderImpl msender = new JavaMailSenderImpl(); //todo: don't initialise here
        msender.setHost("mail.host.com");
        MimeMessage mm = msender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm);
        helper.setTo("received@website.com");
        String plainText = "test";
        helper.setText(plainText);
        msender.send(mm);
    }


//    public JavaMailSender setMailSender() {
//        JavaMailSenderImpl msender = new JavaMailSenderImpl();
//        msender.setHost("mail.host.com");
//        /*
//        try {
//            MimeMessage mm = setMailSender().createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mm);
//                helper.setTo("received@website.com");
//            String plainText = "test";
//            helper.setText(plainText);
//            msender.send(mm?);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        */
//        return msender;
//    }

}
