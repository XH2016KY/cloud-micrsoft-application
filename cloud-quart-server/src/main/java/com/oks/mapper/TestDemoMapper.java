package com.oks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oks.annotation.Loacl;
import com.oks.pojo.TestDemo;

public interface TestDemoMapper {
	
	@Loacl
	boolean insertAll(@Param("demoList")List<TestDemo> demoList);
	
	@Loacl
	Long selectCount();
	
	@Loacl
	List<TestDemo> selectAll();
	
	@Loacl
	List<TestDemo>selectByPage(@Param("start")Integer start,@Param("size")Integer size);

}
