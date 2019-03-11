package com.oks.service;

import java.text.ParseException;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;
import com.oks.enums.QuartStrategyEnums;
import com.oks.service.impl.StrategyContex;

@Component
public class StrategyContexTest extends CloudQuartServerApplicationTests{
	
	@Autowired
	private StrategyContex strategyContex;
	
	@Test
	public void testcompareStock() throws ParseException {
		Set<String> compareStock = strategyContex
				.compareStock(QuartStrategyEnums.REDIS.getStrategy());
		System.out.println(compareStock);
		
	}
	
//	@Test
//	public void testgetResult() throws ParseException {
//		String result = strategyContex
//				.getResult(QuartStrategyEnums.REDIS.getStrategy());
//		System.out.println(result);
//		
//	}
	
	@Test
	public void testSQLcompareStock() throws ParseException {
		Set<String> compareStock = strategyContex
				.compareStock(QuartStrategyEnums.SQL.getStrategy());
		System.out.println(compareStock);
		
	}
	
//	@Test
//	public void testSQLgetResult() throws ParseException {
//		String result = strategyContex
//				.getResult(QuartStrategyEnums.SQL.getStrategy());
//		System.out.println(result);
//		
//	}

}
