package justin.example.justinrabbitMQtest.application.service;

import justin.example.justinrabbitMQtest.domain.model.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/12 下午 01:59
 **/
@Component
public class MessageTestSendService {

    private final RabbitTemplate rabbitTemplate;
    private final CachingConnectionFactory cachingConnectionFactory;


    public MessageTestSendService(
            CachingConnectionFactory cachingConnectionFactory,
            RabbitTemplate rabbitTemplate
    ) {
        this.cachingConnectionFactory = cachingConnectionFactory;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendByExchangeAndRoutingKey(
            String exchangeName,
            String routingKey,
            String message
    ) {
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }


    public void sendByRoutingKey(String routingKey, String message) {
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        rabbitTemplate.convertAndSend(routingKey, message);
    }

    public void sendLoop(
            String exchangeName,
            String routingKey,
            String message
    ) throws InterruptedException {
        System.out.println(new Object() {
        }.getClass().getEnclosingMethod().getName());
        for (int i = 0; i < 50; i++) {
            Thread.sleep(5000);
            rabbitTemplate.convertAndSend(exchangeName, routingKey, i + " : " + message);
        }
    }


    public void sendUser(String routingKey, User user) {
        final var message = user;
        rabbitTemplate.convertAndSend(routingKey, message);
    }
}
