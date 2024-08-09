package com.supportkim.kimchimall.common.config;

import com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto;
import com.supportkim.kimchimall.kimchi.domain.Kimchi;
import io.lettuce.core.RedisURI;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import static com.supportkim.kimchimall.kimchi.controller.response.FindLowestPriceResponseDto.*;

@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisConfig {

    private final RedisProperties redisProperties;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(redisProperties.getHost() , redisProperties.getPort());
    }


    // Kimchi 전용 Redis
    @Bean
    public RedisTemplate<String , ItemDto> LowestPriceKimchiRedisTemplate() {
        RedisTemplate<String, ItemDto> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(ItemDto.class));
        return redisTemplate;
    }
}
