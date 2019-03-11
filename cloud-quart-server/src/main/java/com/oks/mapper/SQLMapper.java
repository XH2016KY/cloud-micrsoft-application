package com.oks.mapper;

import org.apache.ibatis.annotations.Param;

import com.oks.annotation.Loacl;

public interface SQLMapper {
	
	@Loacl
	String findByName(@Param("name")String name);
	
	@Loacl
	Integer findByOldName(@Param("name")String name);
	
	@Loacl
	Integer findByNewName(@Param("name")String name);

}
