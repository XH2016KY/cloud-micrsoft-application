package com.oks.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.oks.pojo.ItemStock;

public interface CheckStockService {
	
	/**
	 * 获取库存信息
	 * @return
	 */
	Map<String,ItemStock> getStockInfo();
	
	/**
	 * 生成库存信息文件
	 * @return
	 * @throws IOException 
	 */
	File getStockInfoFile() throws IOException;

}
