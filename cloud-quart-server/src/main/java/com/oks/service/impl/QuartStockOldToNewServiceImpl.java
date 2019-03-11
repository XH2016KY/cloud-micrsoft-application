package com.oks.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.mapper.QuartStockOldNewMapper;
import com.oks.pojo.QuartStockOldToNew;
import com.oks.service.QuartStockOldToNewService;

@Service("quartStockOldToNewService")
public class QuartStockOldToNewServiceImpl implements QuartStockOldToNewService{
	
	
	@Autowired
	private QuartStockOldNewMapper quartStockOldNewMapper;

	@Override
	public Map<String, Integer> subStock() {
		List<QuartStockOldToNew> subStock = quartStockOldNewMapper.subStock();
		System.out.println(subStock);
		Map<String,Integer> result = new ConcurrentHashMap<>();
		Map<String, List<QuartStockOldToNew>> map = subStock.stream()
				.collect(Collectors.groupingBy(QuartStockOldToNew::getItemName));
		MapUtils.verbosePrint(System.out, "信息", map);
		map.forEach((k,v)->{
			 result.put(k, v.get(0).getItemStockOld()-v.get(0).getItemStockNew());		
		});
		return result;
	}
	
	
	

}
