package com.oks.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.oks.annotation.Loacl;
import com.oks.pojo.Item;
import com.oks.pojo.ItemStock;

public interface ItemMapper {
	
	@Loacl
	Item findById(@Param("itemId")String itemId);
	
	/**
	 * 查询指定时间数据的各商品库存
	 * @return
	 */
	@Loacl
	@MapKey("itemName")
	Map<String,ItemStock> selectStock();

}
