package com.oks.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;

/**
 * 
 * 注释: QuartService接口单元测试
 * @author happy everyday
 * 2019年3月1日下午11:50:13
 */
@Component
public class SkuServiceTest extends CloudQuartServerApplicationTests{
	
	@Autowired
	private SkuService skuService;
	
	/**
	 * 测试解析文件
	 * @throws SQLException
	 */
	@Test
	public void testanalysFile() throws SQLException {
		boolean analysFile = skuService.analysFile();
		assertEquals(true, analysFile);
	}

}
