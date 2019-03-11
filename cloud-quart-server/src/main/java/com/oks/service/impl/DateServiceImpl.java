package com.oks.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.enums.DateEnums;
import com.oks.service.DateService;

import redis.clients.jedis.JedisPool;

@Service("dateService")
public class DateServiceImpl implements DateService{
	
	@Autowired
	private JedisPool jedisPool;
	

	@Override
	public String createStartQuartTime() {
		// 设置时期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取当前时间
		Date current = new Date();
		// 拿到相隔当前时间一天后的个日期
		Date futrue = new Date(current.getTime()-48*3600*1000L);
		try {
			jedisPool.getResource().set(DateEnums.START_DATE.getDateString(), sd.format(futrue));
			return sd.format(futrue);
		} finally {
			if(jedisPool.getResource()!=null) {
				jedisPool.getResource().close();
			}
		}
	}

	@Override
	public String updateQuartTime() throws ParseException {
		try {
			String string = jedisPool.getResource().get(DateEnums.START_DATE.getDateString());
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date parse = sd.parse(string);
			Date newDate = new Date(parse.getTime() + 24 * 3600 * 1000);
			jedisPool.getResource().set(DateEnums.START_DATE.getDateString(), sd.format(newDate));
			return sd.format(newDate);
		} finally {
			if(jedisPool.getResource()!=null) {
				jedisPool.getResource().close();
			}
		}
	}

}
