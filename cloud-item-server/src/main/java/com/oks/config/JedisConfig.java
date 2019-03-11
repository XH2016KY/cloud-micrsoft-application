package com.oks.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 注释: Jedis配置
 * @author happy everyday
 * 2019年3月1日上午12:29:21
 */
@Component
@ConfigurationProperties(prefix="jedis")
@Setter@Getter
public class JedisConfig {
	
	private String host;
	
	private Integer port;
	
	private Integer timeout;
	
	private String password;
	
	private Integer poolMaxTotal;
	
	private Integer poolMaxldle;
	
	private Integer poolMaxWait;

}
