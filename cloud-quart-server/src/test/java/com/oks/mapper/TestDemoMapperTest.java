package com.oks.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;
import com.oks.pojo.NameEnums;
import com.oks.pojo.TestDemo;
import com.oks.utils.PageCalculator;

@Component
public class TestDemoMapperTest extends CloudQuartServerApplicationTests{
	
	@Autowired
	private TestDemoMapper testDemoMapper;
	
	@Test
	public void testInsertAll() {
		List<TestDemo> list= new ArrayList<>();
		for(int i=1;i<=100;i++) {
			int num = (int)((Math.random())*5);
			TestDemo t1 = new TestDemo();
			t1.setName(NameEnums.stateof(num));
			list.add(t1);
		}
		
		testDemoMapper.insertAll(list);
	}
	
	@Test
	public void testCount() {
		Long selectCount = testDemoMapper.selectCount();
		System.out.println(selectCount);
	}
	
	@Test
	public void testPage() {
		List<TestDemo> selectByPage = testDemoMapper.selectByPage(PageCalculator.calculateRowIndex(2, 10), 10);
		System.out.println(selectByPage);
	}
	

}
