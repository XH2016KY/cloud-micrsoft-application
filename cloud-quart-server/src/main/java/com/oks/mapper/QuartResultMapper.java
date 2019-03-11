package com.oks.mapper;

import java.util.List;

import com.oks.annotation.Loacl;
import com.oks.pojo.QuartResult;

public interface QuartResultMapper {
	
	@Loacl
	List<QuartResult> quart();

}
