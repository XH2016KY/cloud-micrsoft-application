package com.oks.service;

import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;

@Component
public class StockServiceTest extends CloudQuartServerApplicationTests{
	
	
	@Autowired
	private StockService stockService;
	
	
	@Test
	public void testgetStockInfoFile() throws IOException {
		File stockInfoFile = stockService.getStockInfoFile();
		assertNotEquals(null, stockInfoFile);
	}
	
	@Test
	public void testdownLoadStockInfo() throws IOException {
		stockService.downLoadStockInfo();
	}
	
	@Test
	public void testloadStockToSQL() throws SQLException {
		boolean loadStockToSQL = stockService.loadStockToSQL();
		System.out.println(loadStockToSQL);
	}

}
