package justin.example.justinrabbitMQtest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/13 下午 05:28
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String username;
    private int age;
    private boolean stupid;
}
