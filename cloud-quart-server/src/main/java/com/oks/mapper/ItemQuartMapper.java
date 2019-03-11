package com.oks.mapper;

import org.apache.ibatis.annotations.Param;

import com.oks.annotation.Loacl;
import com.oks.pojo.ItemQuart;

public interface ItemQuartMapper {
	
	@Loacl
	ItemQuart findByName(@Param("name")String name);

}
