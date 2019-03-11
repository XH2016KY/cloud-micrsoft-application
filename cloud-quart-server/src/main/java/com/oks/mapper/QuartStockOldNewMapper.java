package com.oks.mapper;

import java.util.List;

import com.oks.annotation.Loacl;
import com.oks.pojo.QuartStockOldToNew;

public interface QuartStockOldNewMapper {
	
	
	// TODO 改进:可以传一个集合参数 只校验有出货信息的Item库存差
	@Loacl
	List<QuartStockOldToNew>subStock();

}
