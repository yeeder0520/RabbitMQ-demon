package justin.example.justinrabbitMQtest.interfaces;

import justin.example.justinrabbitMQtest.infrastructure.mq.RabbitMqTestSend;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/12 下午 02:09
 **/
@RestController
@RequiredArgsConstructor
public class SendMessageController {

    private final RabbitMqTestSend rabbitMqTestSend;

    @GetMapping("/send")
    public void send(final @RequestParam String message) {
        rabbitMqTestSend.send(message);
    }
}
