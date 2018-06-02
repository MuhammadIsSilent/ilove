package cn.ljzyemu.iloveweb.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;


/**
 * @Author :ljz
 * @Date :2018/5/14  15:57
 **/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


    @Bean
    public KeyGenerator keyGenerator() {


        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(o.getClass().getName());
                stringBuilder.append(method.getName());
                for (Object object : objects) {
                    stringBuilder.append(object.toString());
                }
                return stringBuilder;
            }
        };
    }

/*    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {

        RedisCacheManager redisCacheManager = new  RedisCacheManager(redisTemplate);

        return redisCacheManager;
    }*/

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(factory);

        Jackson2JsonRedisSerializer jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jsonRedisSerializer.setObjectMapper(objectMapper);
        stringRedisTemplate.setValueSerializer(jsonRedisSerializer);
        stringRedisTemplate.afterPropertiesSet();

        return stringRedisTemplate;
    }


}

