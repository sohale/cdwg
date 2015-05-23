/*
Does not work when these classes are activated
package sboot.websocket;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsckEndpoint {
    private static final Log log = LogFactory.getLog(WsckEndpoint.class);


    @MessageMapping("/wsckendpoint") //web access ==> Welcome to SockJS! Because SockJS also implements http as alternative .
    @SendTo("/topic/greetings") //subscription destination
    public MyMessageJson greeting(MyStompMessage message) throws Exception {
        log.info("greeting() was called with (stomp message=" + message.getMyStompText() + ")");
        Thread.sleep(1000); // simulated delay
        log.info("1 sec later...");
        //org.springframework.messaging.SubscribableChannel
        //org.springframework.messaging.SubscribableChannel s;
        //s.subscribe();s.send();
        return new MyMessageJson("Hello, " + message.getMyStompText() + "!");

        //see  org.springframework.messaging.Message
    }
}
*/