package com.oks.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudIorderServerApplicationTests;
import com.oks.pojo.ItemQutity;
import com.oks.pojo.OrderMaster;

@Component
public class OrderMasterMapperTest extends CloudIorderServerApplicationTests{
	
	
	@Autowired
	private OrderMaterMapper orderMaterMapper;
	
	
	@Test
	public void testfindByDate() throws ParseException {
		// 规定日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = sd.parse("2018-01-01 00:00:00");
		List<OrderMaster> findByDate = orderMaterMapper.findByDate(start, new Date());
		System.out.println(findByDate);
	}
	
	
	/**
	 * 测试查询所有已支付订单的SKU信息
	 * @throws ParseException
	 */
	@Test
	public void testfindAllStatus() throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = sd.parse("2018-01-01 00:00:00");
		List<ItemQutity> itemQutities = orderMaterMapper.findAllStatus(start, new Date());
		System.out.println(itemQutities);
		Map<String, List<ItemQutity>> map = itemQutities.stream()
				.collect(Collectors.groupingBy(ItemQutity::getItemName));
		MapUtils.verbosePrint(System.out, "信息", map);
		Map<String,Integer> result = new ConcurrentHashMap<>();
		map.forEach((k,v)->{
			Optional<Integer> reduce = v.stream().map(ItemQutity::getItemQutity).reduce((i,j)->i+j);
		    result.put(k, reduce.get());
		});
		System.out.println(result);
		
	}
	
	
	
	

}
