package justin.example.justinrabbitMQtest;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.rabbit.test.context.SpringRabbitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/14 下午 05:10
 **/
@SpringRabbitTest
@SpringJUnitConfig
public class Test {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private RabbitAdmin admin;

    @Autowired
    private RabbitListenerEndpointRegistry registry;

    @org.junit.jupiter.api.Test
    void test() {
        template.convertAndSend("color.red","妞妞幼牛牛DER");
    }
}
