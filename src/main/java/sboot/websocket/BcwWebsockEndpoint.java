package sboot.websocket;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class BcwWebsockEndpoint {
    private static final Log log = LogFactory.getLog(BcwWebsockEndpoint.class);

    //todo: move to properties


    final static String CONTROLLER_EP_SUFFIX ="/broadcast-change-ws-endpoint"; // "/wsckendpoint"
    public static final String APP_WEBSOCK_PREFIX = "/wsapp"; //"/app";
    public static final String APP_WEBSOCK_FULL = APP_WEBSOCK_PREFIX+ CONTROLLER_EP_SUFFIX; // "/app/wsckendpoint"
    public static final String STOMPSUBSCR_SUFFIX = "/choice-update-broadcaster";  // "/greetings"
    public static final String STOMPSUBSCR_PREFIX = "/bc-game-1";  // "/topic"   RECEIVER_POINT_PREFIX
    public static final String STOMPSUBSCR_FULL = STOMPSUBSCR_PREFIX+STOMPSUBSCR_SUFFIX; // "/bc-game-1/choice-update-broadcaster" //"/topic/greetings"
    // "/topic/greetings"
    //'/bc-game-1/choice-update-broadcaster" //subscription destination
    //'/topic/greetings',  //the receiver point (also clarified in @SendTo)

    /*
    final static String CONTROLLER_EP_SUFFIX = "/wsckendpoint";
    public static final String APP_WEBSOCK_PREFIX = "/app";
    public static final String APP_WEBSOCK_FULL = APP_WEBSOCK_PREFIX+ CONTROLLER_EP_SUFFIX;
    public static final String STOMPSUBSCR_SUFFIX = "/greetings";
    public static final String STOMPSUBSCR_PREFIX = "/topic";
    public static final String STOMPSUBSCR_FULL = STOMPSUBSCR_PREFIX+STOMPSUBSCR_SUFFIX;
    */

    // /wsckendpoint --> /broadcast-change-ws-endpoint //rename to: org.ucl.bcw.wbsck.bc-ep or broadcast-endpoint (or controller)
    // /topic/greetings --> /bc-game-1/choice-update-broadcaster //rename to: org.ucl.bcw.wbsck.game.1.ws-bc  websock-broadcast or stomp-broadcast (?)
    //@MessageMapping ==>  SockJS => Both Http/Web + WebSocket

    @MessageMapping(CONTROLLER_EP_SUFFIX)
    @SendTo(STOMPSUBSCR_FULL) //subscription destination
    public BcwChangeMessageJson changed(BcwChangeMessageStomp message) throws InterruptedException {
        log.info("state change report received on server-side. (stomp message=" + message + ")");
        //Thread.sleep(1000); //todo:
        log.info("100 ms later...");
        return new BcwChangeMessageJson(message);
        //BcwChangeMessageStomp -> BcwChangeMessageJson
    }
}
