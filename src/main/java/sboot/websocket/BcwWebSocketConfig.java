package sboot.websocket;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by sohail on 23/05/15.
 * STOMP support = spring-messaging + spring-websocket
 *
 * http://docs.spring.io/spring/docs/current/spring-framework-reference/html/websocket.html#websocket-stomp-enable
 */
@Configuration
@EnableWebSocketMessageBroker
public class BcwWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker(BcwWebsockEndpoint.STOMPSUBSCR_PREFIX);
        config.setApplicationDestinationPrefixes(BcwWebsockEndpoint.APP_WEBSOCK_PREFIX);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(BcwWebsockEndpoint.CONTROLLER_EP_SUFFIX).withSockJS();
    }
}
