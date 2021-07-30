package com.example.majorproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

@Repository
public class UserCacheRepository {


    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String USER_KEY_PREFIX = "usr::";

    public User getUser(String userId){
        return (User) redisTemplate.opsForValue().get(getKey(userId));
    }

    public void addUser(User user){
        redisTemplate.opsForValue().set(getKey(user.getUserId()), user, Duration.ofMinutes(10));
    }

    private String getKey(String userId){
        return USER_KEY_PREFIX + userId;
    }

}
