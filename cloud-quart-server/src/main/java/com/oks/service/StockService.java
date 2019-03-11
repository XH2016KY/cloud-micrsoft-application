package com.oks.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 
 * 注释: 库存信息服务接口
 * @author happy everyday
 * 2019年3月2日上午8:10:19
 */
public interface StockService {
	
	/**
	 * 获取库存信息文件
	 * @return
	 * @throws IOException 
	 */
	File getStockInfoFile() throws IOException;
	
	/**
	 * 下载存信息文件
	 * @throws IOException 
	 */
	void downLoadStockInfo() throws IOException;
	
	/**
	 * 将库存文件加载到数据库
	 * @throws SQLException 
	 */
	boolean loadStockToSQL() throws SQLException;

}
