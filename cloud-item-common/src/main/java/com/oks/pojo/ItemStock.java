package com.oks.pojo;

import lombok.Data;

/**
 * 
 * 注释: 校验库存实体
 * @author happy everyday
 * 2019年3月2日上午12:44:20
 */
@Data
public class ItemStock {
	
	/**
	 * 商品名称
	 */
	private String itemName;
	/**
	 * 商品库存
	 */
	private Integer itemStock;

}
