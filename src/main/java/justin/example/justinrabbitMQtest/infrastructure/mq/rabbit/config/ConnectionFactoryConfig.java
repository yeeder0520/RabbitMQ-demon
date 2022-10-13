package justin.example.justinrabbitMQtest.infrastructure.mq.rabbit.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.PooledChannelConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 連線工廠配置
 *
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/10/13 上午 11:15
 **/
@Configuration
public class ConnectionFactoryConfig {

    @Bean
    public PooledChannelConnectionFactory pooledChannelConnectionFactory() throws Exception {
        ConnectionFactory rabbitConnectionFactory = new ConnectionFactory();
        rabbitConnectionFactory.setHost("localhost");
        PooledChannelConnectionFactory factory = new PooledChannelConnectionFactory(rabbitConnectionFactory);
        factory.setPoolConfigurer((pool, tx) -> {
            if (tx) {
                // configure the transactional pool
            } else {
                // configure the non-transactional pool
            }
        });
        return factory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("host", 1111);
        cachingConnectionFactory.setUsername("username");
        cachingConnectionFactory.setPassword("password");
        cachingConnectionFactory.setVirtualHost("/");
        cachingConnectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
        cachingConnectionFactory.setChannelCacheSize(10);
        cachingConnectionFactory.setChannelCheckoutTimeout(600);
        cachingConnectionFactory.setConnectionCacheSize(3);
        cachingConnectionFactory.setConnectionLimit(10);
        return cachingConnectionFactory;
    }

}
