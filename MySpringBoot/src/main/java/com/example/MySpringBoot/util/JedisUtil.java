package com.example.MySpringBoot.util;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.MySpringBoot.JedisConfig;

import redis.clients.jedis.Jedis;

@Component
public class JedisUtil {

    @Autowired
    private JedisConfig jedisConfig;

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间(毫秒)
     * @return 是否获取成功
     */
    
	public boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {

//		Jedis jedis = new Jedis(jedisConfig.getHost(), jedisConfig.getPort());
//		jedis.auth(jedisConfig.getPassword());
    	Jedis jedis = jedisConfig.getJedis();
        String result = jedis.set(lockKey, requestId, "NX", "EX", expireTime); // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒

        jedis.close();  
        if ("OK".equals(result)) {
            return true;
        }
        return false;

    }
    
    
    private static final Long RELEASE_SUCCESS = 1L;
    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
	public boolean releaseDistributedLock(String lockKey, String requestId) {

//    	Jedis jedis = new Jedis(jedisConfig.getHost(), jedisConfig.getPort());
//    	jedis.auth(jedisConfig.getPassword());
    	Jedis jedis = jedisConfig.getJedis();
    	
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        jedis.close(); 
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
}
