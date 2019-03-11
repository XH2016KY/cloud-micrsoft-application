package com.oks.mapper;

import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudItemServerApplicationTests;
import com.oks.pojo.Item;
import com.oks.pojo.ItemStock;

@Component
public class ItemMapperTest extends CloudItemServerApplicationTests{
	
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Test
	public void testfindById() {
		Item findById = itemMapper.findById("001");
		System.out.println(findById);
	}
	
	/**
	 * 测试查询各个商品的库存
	 */
	@Test
	public void testselectStock() {
		 Map<String, ItemStock> selectStock = itemMapper.selectStock();
		System.out.println(selectStock);
	}
	
	
}
