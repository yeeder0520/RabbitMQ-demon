package justin.example.justinrabbitMQtest;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class JustinRabbitMqTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustinRabbitMqTestApplication.class, args);
    }


//    @RabbitListener(
//            bindings = @QueueBinding(
//                    exchange = @Exchange(value = "justin.topic", type = "topic"),
//                    value = @Queue(value = "color.red", durable = "true"),
//                    key = "color.#"
//            ))
//    public void listen(Message message) throws Exception {
//        System.out.println(" [1] Received '" + message + "'");
//        System.out.println(" [1] getBody '" + message.getBody() + "'");
//        System.out.println(" [1] getMessageProperties '" + message.getMessageProperties() + "'");
//    }

    @RabbitListener(queues = {"color.red"})
    public void listenColorRed(Message message){
        System.out.println(" [color.red] Received '" + message + "'");
        System.out.println(" [color.red] getBody '" + new String(message.getBody(), StandardCharsets.UTF_8) + "'");
        System.out.println(" [color.red] getMessageProperties '" + message.getMessageProperties() + "'");
    }

}
