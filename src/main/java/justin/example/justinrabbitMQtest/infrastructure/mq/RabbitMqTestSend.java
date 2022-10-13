package justin.example.justinrabbitMQtest.infrastructure.mq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/12 下午 01:59
 **/
@Component
public class RabbitMqTestSend {

    ConnectionFactory connectionFactory = new CachingConnectionFactory(); //port 5672
    AmqpAdmin admin = new RabbitAdmin(connectionFactory);
    AmqpTemplate template = new RabbitTemplate(connectionFactory);

    public void send(String message) {
        System.out.println("GOGO");

        for (int i = 0; i < 50; i++) {
            admin.declareQueue(new Queue("Justin_MQ"));
            template.convertAndSend("Justin_MQ", i + " : " + message);
        }


    }

}
