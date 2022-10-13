package justin.example.justinrabbitMQtest;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JustinRabbitMqTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustinRabbitMqTestApplication.class, args);
    }


    @RabbitListener(queues = "Justin_MQ")
    public void listen(String receiveString) throws Exception {
        System.out.println(" [1] Received '" + receiveString + "'");
    }

}
