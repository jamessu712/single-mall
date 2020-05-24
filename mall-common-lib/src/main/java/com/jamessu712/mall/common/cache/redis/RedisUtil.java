package com.jamessu712.mall.common.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void setObject(String key,Object object){
        redisTemplate.opsForValue().set(key, object);
    }
    public Object getObject(String key){
        return redisTemplate.opsForValue().get(key);
    }

}
