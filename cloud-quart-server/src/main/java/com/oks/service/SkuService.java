package com.oks.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;
/**
 * 
 * 注释: SKU信息获取服务接口
 * @author happy everyday
 * 2019年3月2日上午8:09:46
 */
public interface SkuService {

	/**
	 * 获取SKU出货信息
	 * @return
	 * @throws ParseException
	 */
	Map<String,Integer>getInfoSku() throws ParseException;
	
	/**
	 * 下载SKU出货信息文件
	 * @throws IOException
	 * @throws ParseException
	 */
	void downLoadFile() throws IOException, ParseException;
	
	/**
	 * 解析SKU出货文件
	 * @return
	 * @throws SQLException 
	 */
	boolean analysFile() throws SQLException;
	
	
}
