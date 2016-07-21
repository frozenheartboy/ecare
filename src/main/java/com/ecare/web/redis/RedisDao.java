package com.ecare.web.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by L on 2016/7/21.
 */
@Component
public class RedisDao {
    @Resource(name = "redisTemplate")
    protected RedisTemplate<String, Object> redisTemplate;
    public String getToken(int userId) {
        return String.valueOf(redisTemplate.opsForValue().get("token_"+String.valueOf(userId)));
    }

}
