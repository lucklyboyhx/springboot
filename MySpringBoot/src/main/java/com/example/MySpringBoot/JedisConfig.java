package com.example.MySpringBoot;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class JedisConfig implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3819550153454960537L;

	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.port}")
    private int port;
	
	@Value("${spring.redis.password}")
    private String password;
	
	@Value("${spring.redis.timeout}")
    private int timeout;
	
	@Value("${spring.redis.pool.max-active}")
    private int poolMaxTotal;
	
	@Value("${spring.redis.pool.max-idle}")
    private int poolMaxIdle;
	
	@Value("${spring.redis.pool.max-wait}")
    private int poolMaxWait;
	
	@Value("${spring.redis.pool.min-idle}")
    private int poolMinIdle;
	
	private static JedisPool pool;//jedis连接池  
	
    public Jedis getJedis(){  
    	initPool();//初始化连接池  
        return pool.getResource();  
    }  
  
    public void close(Jedis jedis){  
        jedis.close();  
    }  
  
    private void initPool(){  
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxTotal(poolMaxTotal);  
        config.setMaxIdle(poolMaxIdle);  
        config.setMinIdle(poolMinIdle);  
        config.setBlockWhenExhausted(true);  
        pool = new JedisPool(config, host, port, timeout, password);  
    }  
	
//	@Bean  
//    public JedisPoolConfig getRedisConfig(){  
//        JedisPoolConfig config = new JedisPoolConfig();  
//        return config;  
//    }  
//      
//    @Bean  
//    public JedisPool getJedisPool(){  
//        JedisPoolConfig config = getRedisConfig();  
//        JedisPool pool = new JedisPool(config,host,port,timeout,password);  
//        return pool;  
//    }  
    
    public int getPoolMinIdle() {
		return poolMinIdle;
	}
	public void setPoolMinIdle(int poolMinIdle) {
		this.poolMinIdle = poolMinIdle;
	}
	public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getTimeout() {
        return timeout;
    }
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    public int getPoolMaxTotal() {
        return poolMaxTotal;
    }
    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }
    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }
    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }
    public int getPoolMaxWait() {
        return poolMaxWait;
    }
    public void setPoolMaxWait(int poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }

}
