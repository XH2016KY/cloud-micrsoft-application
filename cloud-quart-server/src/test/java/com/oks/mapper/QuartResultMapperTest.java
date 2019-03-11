package com.oks.mapper;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;
import com.oks.pojo.QuartResult;
import com.oks.service.impl.SQLQuartStrategyImpl;

@Component
public class QuartResultMapperTest extends CloudQuartServerApplicationTests{
	
	
	@Autowired
	private QuartResultMapper quartResultMapper;
	
	@Autowired
	private SQLQuartStrategyImpl sQLQuartStrategyImpl;
	
	@Test
	public void testquart() {
		List<QuartResult> quart = quartResultMapper.quart();
		System.out.println(quart);
	}
	
	@Test
	public void testcompareStock() throws ParseException {
		Set<String> compareStock = sQLQuartStrategyImpl.compareStock();
		System.out.println(compareStock);
	}
	
	@Test
	public void testgetResult() throws ParseException {
		String compareStock = sQLQuartStrategyImpl.getResult();
		System.out.println(compareStock);
	}

}
