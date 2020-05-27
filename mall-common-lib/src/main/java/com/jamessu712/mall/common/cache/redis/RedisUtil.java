package com.jamessu712.mall.common.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

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
    public Boolean setObjectForHash(String key, Map<String,Object> map){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Object getObjectForHash(String key,String mapKey){
        Map<Object,Object> mp = redisTemplate.opsForHash().entries(key);
        Object obj = mp.get(mapKey);
        return obj;
    }

}
