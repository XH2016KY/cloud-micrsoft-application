package com.oks.pojo;

import lombok.Data;

/**
 * 
 * 注释: 库存新旧表校验结果实体
 * @author happy everyday
 * 2019年3月3日下午1:20:24
 */
@Data
public class QuartStockOldToNew {
	
    private String itemName;
	
	private Integer itemStockOld;
	
	private Integer itemStockNew;

}
