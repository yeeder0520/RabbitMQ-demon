package justin.example.justinrabbitMQtest.interfaces;

import justin.example.justinrabbitMQtest.domain.model.User;
import justin.example.justinrabbitMQtest.application.service.MessageTestSendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/12 下午 02:09
 **/
@RestController
@RequiredArgsConstructor
public class SendMessageController {

    private final MessageTestSendService messageTestSendService;

    @GetMapping("/sendByExchangeAndRoutingKey")
    public void sendByExchangeAndRoutingKey(
            final @RequestParam String exchangeName,
            final @RequestParam String routingKey,
            final @RequestParam String message) {
        messageTestSendService.sendByExchangeAndRoutingKey(exchangeName, routingKey, message);
    }

    @PostMapping("/sendUser")
    public void sendUser(
            final @RequestParam String routingKey,
            final @RequestBody User user) {
        System.out.println("user = " + user);
        messageTestSendService.sendUser( routingKey, user);
    }

    @GetMapping("/sendByRoutingKey")
    public void sendByRoutingKey(
            final @RequestParam String routingKey,
            final @RequestParam String message) {
        messageTestSendService.sendByRoutingKey( routingKey, message);
    }

    @GetMapping("/sendLoop")
    public void sendLoop(
            final @RequestParam String exchangeName,
            final @RequestParam String routingKey,
            final @RequestParam String message) throws InterruptedException {
        messageTestSendService.sendLoop(exchangeName, routingKey, message);
    }
}
