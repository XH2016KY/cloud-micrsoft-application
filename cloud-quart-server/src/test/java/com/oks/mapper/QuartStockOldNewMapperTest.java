package com.oks.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;
import com.oks.pojo.QuartStockOldToNew;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class QuartStockOldNewMapperTest extends CloudQuartServerApplicationTests{

	
	@Autowired
	private QuartStockOldNewMapper quartStockOldNewMapper;
	
	@Autowired
	private JedisPool jedisPool;
	
	@Test
	public void test1() {
		List<QuartStockOldToNew> subStock = quartStockOldNewMapper.subStock();
		System.out.println(subStock);
		Map<String,Integer> result = new ConcurrentHashMap<>();
		Map<String, List<QuartStockOldToNew>> map = subStock.stream()
				.collect(Collectors.groupingBy(QuartStockOldToNew::getItemName));
		MapUtils.verbosePrint(System.out, "信息", map);
		map.forEach((k,v)->{
			 result.put(k, v.get(0).getItemStockOld()-v.get(0).getItemStockNew());		
		});
		System.out.println(result);
		// 
		Jedis resource = jedisPool.getResource();
		Set<String> keySet = result.keySet();
		for(String s:keySet) {
			resource.sadd("stock_app", s+"->"+result.get(s).toString());
	    }
		
		Set<String> sdiff = resource.sdiff("stock_app","stock");
		System.out.println(sdiff);
	}
}
