package vn.chuot96.rediscache.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class RedisKeyCodec {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String encode(Object dto) {
        try {
            return Base64.getUrlEncoder()
                    .encodeToString(objectMapper.writeValueAsString(dto).getBytes(StandardCharsets.UTF_8));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to encode DTO to key", e);
        }
    }

    public static <T> T decode(String key, Class<T> dtoClass) {
        try {
            return objectMapper.readValue(
                    new String(Base64.getUrlDecoder().decode(key), StandardCharsets.UTF_8), dtoClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to decode key to DTO", e);
        }
    }
}
