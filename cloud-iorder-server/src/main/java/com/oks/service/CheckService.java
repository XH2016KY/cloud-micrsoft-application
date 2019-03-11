package com.oks.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

/**
 * 注释:生成校对SKU信息服务
 * @author happy everyday
 * 2019年2月28日下午8:57:58
 */
public interface CheckService {
	
	/**
	 * 查询出当天各个商品出货信息
	 * @param end 截止日期
	 * @return  出货信息Map
	 * @throws ParseException
	 */
	Map<String,Integer> checkQutity(Date end) throws ParseException;
	
	/**
	 * @return 出货信息流
	 * @throws IOException
	 * @throws ParseException 
	 */
	File checkFileIO(Date end) throws IOException, ParseException;
	
	
}
