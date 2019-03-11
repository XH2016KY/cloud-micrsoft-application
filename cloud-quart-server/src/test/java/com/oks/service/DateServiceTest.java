package com.oks.service;

import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;

/**
 * 
 * 注释: DateService接口单元测试
 * @author happy everyday
 * 2019年3月1日下午11:49:35
 */
@Component
public class DateServiceTest extends CloudQuartServerApplicationTests{
	
	@Autowired
	private DateService dateService;
	
	
	/**
	 * 测试生成校对SKU数据的时间
	 */
	@Test
	public void testcreateStartQuartTime() {
		String createQuartTime = dateService.createStartQuartTime();
		assertNotEquals(null, createQuartTime);
	}
	
	/**
	 * 测试更新校对SKU数据的时间
	 * @throws ParseException
	 */
	@Test
	public void testupdateQuartTime() throws ParseException {
		String updateQuartTime = dateService.updateQuartTime();
		assertNotEquals(null, updateQuartTime);
	}

}
