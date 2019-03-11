package com.oks.service;

import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudItemServerApplicationTests;

/**
 * 
 * 注释: CheckStockService接口测试
 * @author happy everyday
 * 2019年3月2日上午1:18:23
 */
@Component
public class CheckStockServiceTest extends CloudItemServerApplicationTests{

	@Autowired
	private CheckStockService checkStockService;
	
	@Test
	public void testgetStockInfoFile() throws IOException {
		File geStockInfoFile = checkStockService.getStockInfoFile();
		assertNotEquals(null, geStockInfoFile);
	}
}
