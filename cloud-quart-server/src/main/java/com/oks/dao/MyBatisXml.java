package com.oks.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import com.alibaba.druid.pool.DruidDataSource;
import com.oks.config.DaoFile;
import com.oks.dao.split.DynamicDataSource;

@Configuration
@MapperScan("com.oks.mapper")
public class MyBatisXml {
	
	
//	@Value("${jdbc.className}")
//	private String className;
//	
//    @Value("${jdbc.testUrl}")
//   	private String testUrl;
//    
//	@Value("${jdbc.username}")
//	private String username;
//	
//	@Value("${jdbc.password}")
//	private String password;
//	
//	@Value("${mybatis_config_file}")
//	private String mybatisConfigFile;
//	
//	@Value("${mapper_path}")
//	private String mapperPath;
//	
//	@Value("${type_alias_path}")
//	private String typeAliasPath;
	
	@Autowired
	private DaoFile daoFile;
	
	
	@Bean("local")
	public DruidDataSource  local() {
		DruidDataSource local = new DruidDataSource();
		local.setDriverClassName(daoFile.getClassName());
		local.setUrl(daoFile.getTestUrl());
        local.setUsername(daoFile.getUsername());
        local.setPassword(daoFile.getPassword());
		return local;
		
	}
	
	
	@Bean
	public DynamicDataSource dynamicDataSource(){
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object, Object> map = new HashMap<>();
		map.put("local", local());
		dynamicDataSource.setTargetDataSources(map);
		return dynamicDataSource;
	}
	
	@Bean
	public LazyConnectionDataSourceProxy dataSource(){
		LazyConnectionDataSourceProxy dataSource = new LazyConnectionDataSourceProxy();
		dataSource.setTargetDataSource(dynamicDataSource());
		return dataSource;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean  sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(daoFile.getMybatis_config_file()));
		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		String packageSerchPath = daoFile.getMapper_path();
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSerchPath));
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setTypeAliasesPackage(daoFile.getType_alias_path());
		return sqlSessionFactoryBean;

	}

}
