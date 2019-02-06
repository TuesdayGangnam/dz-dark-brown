package com.dz.config;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableRedisRepositories
@ConfigurationProperties(prefix = "spring")
public class RedisRepositoryConfig {

    @Setter
    private Map<String, String> profiles = new HashMap<>();

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setPort(redisPort);
        redisStandaloneConfiguration.setHostName(redisHost);

        redisStandaloneConfiguration.setPassword(redisPassword);

        return redisStandaloneConfiguration;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        // Lettuce 레터스
        //LettuceConnectionFactory로 생성되는 모든 LettuceConnections은, 모든 논블로킹-논트랜잭션 작업을 위해 같은 쓰레드세이프한 네이티브 코넥션을 공유합니다.
        //pooling blocking 하고 transactional 한 코넥션을 사용하기도하고, shareNativeConnection이 false로 되어있다면 모든 코넥션을 사용하기도 합니다.
        //return new LettuceConnectionFactory(host, port);
        return new LettuceConnectionFactory(redisStandaloneConfiguration());
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }

}