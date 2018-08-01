package com.example.MySpringBoot.util;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import com.example.MySpringBoot.SpringContextHolder;

/**
 * 详情见 <a>http://docs.spring.io/spring-data/redis/docs/current/api/</a>
 * @author nhsoft.lsd@hotmail.com
 * @date 2017年6月7日
 *
 */
public class RedisUtilNew {

	private static final Logger logger = LoggerFactory.getLogger(RedisUtilNew.class);

//	public static RedisTemplate<String, Object> redisTemplate;
	private static RedisTemplate<String, Object> redisTemplate = SpringContextHolder.getBean("redisTemplate");

	private static boolean redisValid = true;
	
	public static Integer EXPIRE_1H = 60 * 60;

	public static boolean isRedisValid() {
		return redisValid;
	}

	public void setRedisValid(boolean redisValid) {
		RedisUtilNew.redisValid = redisValid;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		RedisUtilNew.redisTemplate = redisTemplate;
	}
	
	public static RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public static void addSet(String key, Object ...value){
	    if (redisValid) {
            try {
                redisTemplate.opsForSet().add(key, value);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
        }
	}
	
	public static void deleteSet(String key, Object ...value){
	    if (redisValid) {
            try {
                redisTemplate.opsForSet().remove(key, value);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
        }
	}
	
	public static Set<Object> getSet(String key){
	    
	    if (redisValid) {
            try {
                return redisTemplate.opsForSet().members(key);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
        }
	    return null;
	}
	
	public static boolean isSet(String key, Object ...value){
	    
	    if (redisValid) {
            try {
                return redisTemplate.opsForSet().isMember(key, value);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
        }
	    return false;
	}
	
	public static void leftPush(String key, Object o){
	    if (redisValid) {
            try {
                redisTemplate.opsForList().leftPush(key, o);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
        }
	}
	
	//sort set
	public static Boolean addZSet(String key, Object value, double score){
	    
	    if (redisValid) {
	        try {
	            return redisTemplate.opsForZSet().add(key, value, score);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
	    }
	    return null;
	}
	
	public static Boolean addZSet(String key, Set<ZSetOperations.TypedTuple<Object>> tuples){
        
        if (redisValid) {
            
            try {
                redisTemplate.opsForZSet().add(key, tuples);
                return true;
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
            
        }
        
        return null;
    }
	
	public static Set<ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end){
	    if (redisValid) {
	        
	        try {
	            Set<ZSetOperations.TypedTuple<Object>> set = redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
	            return set;
	        } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
	    }
	    return null;
	    
	}
	
	
	public static Double incrementScore(String key, Object value, double score){
	    
	    if (redisValid) {
	        try {
	            double scroe =  redisTemplate.opsForZSet().incrementScore(key, value, score);
	            return scroe;
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);
            }
	    }
	    return null;
	   
	}

	   //string
    public static void put(String key, Object value) {
        if (redisValid) {
            try {
                redisTemplate.opsForValue().set(key, value);
            } catch (Exception e) {
                logger.warn(e.getMessage(), e);

            }

        }
    }
	
	//string
	public static void put(String key, Object value, int expireTime) {
		if (redisValid) {
			try {

				redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);

			} catch (Exception e) {
				logger.warn(e.getMessage(), e);

			}

		}
	}

	public static Object get(String key) {
		if (redisValid) {
			try {
				return redisTemplate.opsForValue().get(key);
			} catch (Exception e) {
				logger.warn(e.getMessage(), e);
				return null;
			}
		}else{
			return null;
		}
		
	}

	public static void delete(String key) {
		if (redisValid) {
			try {
				redisTemplate.delete(key);

			} catch (Exception e) {
				logger.warn(e.getMessage(), e);
			}

		}
	}

	public static void hashPut(String key, String hashKey, Object value) {
		if (redisValid) {
			try {

				redisTemplate.opsForHash().put(key, hashKey, value);

			} catch (Exception e) {
				logger.warn(e.getMessage(), e);

			}

		}
	}

	public static Object hashGet(String key, String hashKey) {

		try {
			return redisTemplate.opsForHash().get(key, hashKey);

		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
			return null;
		}

	}
	
	/**
	 * INCR 自增
	 * @param key
	 * @return 返回自增后的值
	 */
	public static Long increment(String key) {
		try {
			Long value = redisTemplate.opsForValue().increment(key, 1);
			return value;
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return null;
	}
	
	
	/**
	 * INCR 自增设置默认初始值
	 * @param key
	 * @param offset
	 */
	public static void setIncrementOffSet(String key, Long offset) {
		try {
			redisTemplate.opsForValue().set(key, offset);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
	}
	
	public static void expire(String key, long timeout) {
		try {
			redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
	}

	public static String script = "return redis.call('SET', KEYS[1], ARGV[1], 'NX', 'EX', ARGV[2]) ";
    public static RedisScript<String> scriptLock = new DefaultRedisScript<String>(script, String.class);
     /**
     * 获取锁
     * 
     * @param key
     * @param value
     * @return
     */
    public static boolean getLock(final String key, String value, int expireTime) {
        try {
            
            Object result = redisTemplate.execute(scriptLock, redisTemplate.getStringSerializer(), redisTemplate.getStringSerializer(), Collections.singletonList(key), value,
                    String.valueOf(expireTime));
            if ("OK".equals(result)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static String scriptRe = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    public static RedisScript<String> scriptLockRe = new DefaultRedisScript<String>(scriptRe, String.class);
    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static void releaseDistributedLock(String lockKey, String requestId) {

        redisTemplate.execute(scriptLockRe, redisTemplate.getStringSerializer(), redisTemplate.getStringSerializer(), Collections.singletonList(lockKey), requestId);

    }
}
