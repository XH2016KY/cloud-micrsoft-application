package com.oks.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 注释: mybatis配置
 * @author happy everyday
 * 2019年3月1日上午12:30:27
 */
@Component
@ConfigurationProperties(prefix="jdbc")
@Setter@Getter
public class DaoFile {
	
	private String className;
	
	private String password;
	
	private String testUrl;
	
	private String username;
	
	private String mybatis_config_file;
	
	private String mapper_path;
	
	private String type_alias_path;

}
