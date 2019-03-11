package com.oks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * 注释: Redis配置
 * @author happy everyday
 * 2019年3月1日上午12:29:01
 */
@Configuration
public class RedisConfig {
	
	@Autowired
	private JedisConfig jedisConfig;
	
	@Bean
	public JedisPool jedisPoolFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(jedisConfig.getPoolMaxTotal());
		poolConfig.setMaxIdle(jedisConfig.getPoolMaxldle());
		poolConfig.setMaxWaitMillis(jedisConfig.getPoolMaxWait()*1000);
		JedisPool pool = new JedisPool(poolConfig,jedisConfig.getHost(),
				jedisConfig.getPort(),jedisConfig.getTimeout()*1000,
				jedisConfig.getPassword());
		return pool;
		
	}

}
