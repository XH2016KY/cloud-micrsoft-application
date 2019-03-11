package com.oks.service;

import java.text.ParseException;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;
import com.oks.service.impl.RedisQuartStrategyImpl;

@Component
public class RedisQuartStrategyTest extends CloudQuartServerApplicationTests{
	
	
	@Autowired
	private RedisQuartStrategyImpl redisQuartStrategy;
	
	@Test
	public void testcompareStock() throws ParseException {
		Set<String> compareStock = redisQuartStrategy.compareStock();
		System.out.println(compareStock);
	}

}
