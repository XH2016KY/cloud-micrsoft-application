package com.oks.service;

import java.text.ParseException;

public interface DateService {
	
	/**
	 * 设置校验时间
	 * @return
	 */
	String createStartQuartTime();
	
	/**
	 * 更新校验时间
	 * @return
	 * @throws ParseException 
	 */
	String updateQuartTime() throws ParseException;

}
