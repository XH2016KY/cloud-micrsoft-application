package com.oks.service.impl;

import java.text.ParseException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.oks.enums.QuartStrategyEnums;
import com.oks.service.QuartStrategy;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StrategyContex {
	
	@Autowired
	@Qualifier("redisQuartStrategy")
	private QuartStrategy redisQuartStrategy;
	
	@Autowired
	@Qualifier("sQLQuartStrategy")
	private QuartStrategy sQLQuartStrategy;
	
	public Set<String> compareStock(String strategy) throws ParseException{
		return strategy==QuartStrategyEnums.Strategy(0)?
				redisQuartStrategy.compareStock():sQLQuartStrategy.compareStock();
	}
	
	@Scheduled(cron="0/20 * * * * ?")
	public String getResult() throws ParseException {
		String strategy = QuartStrategyEnums.SQL.getStrategy();
		String string = strategy==QuartStrategyEnums.Strategy(0)?
				redisQuartStrategy.getResult():sQLQuartStrategy.getResult();
		log.info("校对结果:{}",string);
		return string;
	}

}
