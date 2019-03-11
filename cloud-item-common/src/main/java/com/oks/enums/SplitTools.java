package com.oks.enums;

import lombok.Getter;

/**
 * 
 * 注释: 符号枚举
 * @author happy everyday
 * 2019年3月1日下午11:37:06
 */
@Getter
public enum SplitTools {
	
	ONE(0,":"),TWO(1,"|");
	
	private Integer code;
	
	private String split;
	
	SplitTools(Integer code,String split){
		this.code = code;
		this.split = split;
	}

}
