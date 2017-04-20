package com.ellis.service.bootstrap.config;

import com.ellis.commons.lock.RedisReentrantLock;
import com.ellis.commons.redis.RedisClient;
import com.ellis.commons.redis.RedisFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ellis.luo
 * @date 16/12/11 上午10:33
 * @description
 */
@Configuration
public class RedisConfig {
    private long lockTimeOut;

    @Bean(name = "redisReentrantLock")
    @ConfigurationProperties(prefix = "redis")
    public RedisReentrantLock redisReentrantLockBean() throws Exception {
        RedisReentrantLock lock = new RedisReentrantLock();
        lock.setRedisClient(redisClientBean());
        return lock;
    }

    @Bean(name = "defaultCache")
    public RedisClient redisClientBean() throws Exception {
        RedisClient client = new RedisClient();
        client.setFactory(redisFactoryBean());
        return client;
    }

    @Bean
    @ConfigurationProperties(prefix = "redis")
    public RedisFactory redisFactoryBean() throws Exception {
        return new RedisFactory();
    }

    public long getLockTimeOut() {
        return lockTimeOut;
    }

    public void setLockTimeOut(long lockTimeOut) {
        this.lockTimeOut = lockTimeOut;
    }
}
