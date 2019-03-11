package com.oks.enums;

import lombok.Getter;

/**
 * 
 * 注释: 日期枚举
 * @author happy everyday
 * 2019年3月1日下午11:37:24
 */
@Getter
public enum DateEnums {
	
	START_DATE(0,"开始校验的时间");
	
	private Integer code;
	
	private String dateString;
	
	private DateEnums(Integer code,String dateString) {
	   this.code = code;
	   this.dateString = dateString;
	}

}
