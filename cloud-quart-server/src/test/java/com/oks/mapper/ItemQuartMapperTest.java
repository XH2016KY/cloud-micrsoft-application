package com.oks.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;
import com.oks.pojo.ItemQuart;

@Component
public class ItemQuartMapperTest extends CloudQuartServerApplicationTests{
	
	
	@Autowired
	private ItemQuartMapper itemQuartMapper;
	
	@Test
	public void testfindByName() {
		ItemQuart findByName = itemQuartMapper.findByName("网卡");
		System.out.println(findByName);
	}
	

}
