package com.oks.service.impl;

import java.text.ParseException;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.constants.StockConstant;
import com.oks.enums.SplitTools;
import com.oks.service.QuartStockOldToNewService;
import com.oks.service.QuartStrategy;
import com.oks.service.SkuService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * 注释: redis校验实现
 * @author happy everyday
 * 2019年3月4日上午6:48:27
 */
@Service("redisQuartStrategy")
public class RedisQuartStrategyImpl implements QuartStrategy{
	
	@Autowired
	private QuartStockOldToNewService quartStockOldToNewService;
	
	@Autowired
	private SkuService skuService;
	
	@Autowired
	private JedisPool jedisPool;

	@Override
	public Set<String> compareStock() throws ParseException {
		// 1.得到old-new->库存差
		Map<String, Integer> subStock = quartStockOldToNewService.subStock();
		Jedis resource = jedisPool.getResource();
		try {
			Set<String> keySet = subStock.keySet();
			for (String s : keySet) {
				resource.sadd(StockConstant.STOCK_APP, s + SplitTools.THREE.getSplit() + subStock.get(s).toString());
			}
			//2.得到order->出货量
			Map<String, Integer> infoSku = skuService.getInfoSku();
			Set<String> infoKey = infoSku.keySet();
			for (String info : infoKey) {
				resource.sadd(StockConstant.SKU_INFO,
						info + SplitTools.THREE.getSplit() + infoSku.get(info).toString());
			}
			//3.redis的set集合做差
			Set<String> sdiff = resource.sdiff(StockConstant.STOCK_APP, StockConstant.SKU_INFO);
			resource.expire(StockConstant.SKU_INFO, 1);
			resource.expire(StockConstant.STOCK_APP, 1);
			return sdiff;
		} finally {
			resource.close();
		}
	}

	@Override
	public String getResult() throws ParseException {
		Set<String> compareStock = this.compareStock();
		StringBuilder sb = new StringBuilder();
		for(String s:compareStock) {
			String[] split = s.split(SplitTools.THREE.getSplit());
			if(!split[1].equals("0")) {
				System.out.println(split[1]);
				sb.append(split[0]+":校验库存有差异");
			}			
		}
		return sb.toString().contains("校验库存有差异")?sb.toString():"校验数据正确";
	}
	
	

}
