package com.oks.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.enums.DateEnums;
import com.oks.enums.SplitTools;
import com.oks.mapper.OrderMaterMapper;
import com.oks.pojo.ItemQutity;
import com.oks.service.CheckService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * 注释: SUK信息校对实现
 * @author happy everyday
 * 2019年2月28日下午9:01:20
 */
@Service("checkService")
public class CheckServiceImpl implements CheckService{
	
	@Autowired
	private OrderMaterMapper orderMaterMapper;
	
	@Autowired
	private JedisPool jedisPool;
	

	@Override
	public Map<String, Integer> checkQutity(Date end) throws ParseException {
//		Date start = sd.parse("2018-01-01 00:00:00");
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Jedis jedis = jedisPool.getResource();
		Date start = sd.parse(jedis.get(DateEnums.START_DATE.getDateString()));
		Map<String,Integer> result = new ConcurrentHashMap<>();
		List<ItemQutity> itemQutities = orderMaterMapper.findAllStatus(start, end);
		Map<String, List<ItemQutity>> map = itemQutities.stream()
				.collect(Collectors.groupingBy(ItemQutity::getItemName));
		MapUtils.verbosePrint(System.out, "信息", map);
		map.forEach((k,v)->{
			Optional<Integer> reduce = v.stream().map(ItemQutity::getItemQutity).reduce((i,j)->i+j);
		    result.put(k, reduce.get());
		});
		return result;
	}


	@Override
	public File checkFileIO(Date end) throws IOException, ParseException {
		FileWriter writer=null;
		writer = new FileWriter("F://iorder//orderdetail003.txt");
		BufferedWriter buff;
		buff = new BufferedWriter(writer);
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Map<String, Integer> checkQutity = checkQutity(end);
			Set<String> keySet = checkQutity.keySet();
			for(String s:keySet) {
				buff.write(s+SplitTools.ONE.getSplit()+checkQutity.get(s)+SplitTools.ONE.getSplit()+sd.format(new Date())+
						SplitTools.TWO.getSplit());
			}		
			File file = new File("F://iorder//orderdetail003.txt");
			System.out.println(file.exists());
			return file;
		} finally {
			buff.close();
			writer.close();
		}
	}

}
