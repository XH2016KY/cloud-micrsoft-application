package com.oks.service;

import java.util.Map;

public interface QuartStockOldToNewService {
	
	/**
	 * 库存old表与new表之差
	 * @return  商品名->库存差
	 */
	Map<String,Integer> subStock();

}
