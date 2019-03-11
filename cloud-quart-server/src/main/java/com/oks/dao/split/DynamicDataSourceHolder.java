package com.oks.dao.split;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicDataSourceHolder {
   
	private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static String DB_MASTER = "master";

	public static String DB_SLAVE = "slave";
	
	public static String DB_LOCAL = "local";

	
	/**
	 * 获取数据源类型
	 * @return
	 */
	public static String getDbType() {
		String db = contextHolder.get();
		if (db == null) {
			db = DB_LOCAL;
		}
		return db;
	}
    
	/**
	 * 设置数据源类型
	 * @param str
	 */
	public static void setDbType(String str) {
        log.info("所用数据源类型{}",str);
		contextHolder.set(str);
	}
    
	/**
	 * 清理数据源key
	 */
	public static void cleanDbType() {
		contextHolder.remove();
	}

}
