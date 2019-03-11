package com.oks.utils;

public class PageCalculator {
	
	 /**
     * 将分页数据当前页转化为开始行
     * @param pageIndex 分页当前页
     * @param pageSize  分页大小
     * @return 数据查询开始行
     */
	public static Integer calculateRowIndex(Integer pageIndex, Integer pageSize) {

		return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;

	}

}