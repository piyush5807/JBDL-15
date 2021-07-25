package com.example.gfg.libraryapp.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
public class UserCacheRepository {

    private static Logger logger = LoggerFactory.getLogger(UserCacheRepository.class);

    // cache related operations

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String USER_KEY_PREFIX = "usr::";

    public void setUserInCache(User user){
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getUsername(), user, Duration.ofMinutes(10));
        logger.info("Set user with key - {}, value - {}", USER_KEY_PREFIX + user.getUsername(), user);
    }

    public User getUserFromCache(String userName){
        return (User) redisTemplate.opsForValue().get(USER_KEY_PREFIX + userName);
    }
}
