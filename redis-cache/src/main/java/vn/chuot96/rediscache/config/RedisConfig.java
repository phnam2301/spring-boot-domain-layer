package vn.chuot96.rediscache.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.*;
import vn.chuot96.rediscache.dto.CacheHolderDTO;

@Configuration
public class RedisConfig {
    @Bean
    public ReactiveRedisTemplate<String, CacheHolderDTO> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(
                BasicPolymorphicTypeValidator.builder()
                        .allowIfSubType(Object.class)
                        .build(),
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY);
        JavaType javaType = mapper.getTypeFactory().constructType(CacheHolderDTO.class);
        Jackson2JsonRedisSerializer<CacheHolderDTO> serializer = new Jackson2JsonRedisSerializer<>(javaType);
        RedisSerializationContext<String, CacheHolderDTO> context =
                RedisSerializationContext.<String, CacheHolderDTO>newSerializationContext(new StringRedisSerializer())
                        .value(serializer)
                        .build();
        return new ReactiveRedisTemplate<>(factory, context);
    }
}
