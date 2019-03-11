package com.oks.pojo;

import lombok.Data;

/**
 * 
 * 注释: 解析订单SKU的出货信息实体
 * @author happy everyday
 * 2019年2月27日下午9:58:59
 */
@Data
public class ItemQutity {
	
	/**
	 * 商品名称
	 */
	private String itemName;
	/**
	 * 商品出货量
	 */
	private Integer itemQutity;

}
