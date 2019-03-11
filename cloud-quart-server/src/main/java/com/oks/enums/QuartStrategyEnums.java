package com.oks.enums;

import lombok.Getter;

/**
 * 
 * 注释: 校验策略
 * @author happy everyday
 * 2019年3月4日上午8:44:02
 */
@Getter
public enum QuartStrategyEnums {
	
	REDIS(0,"redis"),SQL(1,"sql");
	
	private Integer code;
	
	private String strategy;
	
	QuartStrategyEnums(Integer code,String strategy){
		this.code = code;
		this.strategy = strategy;
	}
	
	public  static String Strategy(Integer code) {
		for(QuartStrategyEnums quartStrategyEnums:values()) {
			if(quartStrategyEnums.getCode().equals(code)) {
				return quartStrategyEnums.getStrategy();
			}
		}
		return null;
		
	}

}
