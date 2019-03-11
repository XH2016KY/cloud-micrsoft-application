package com.oks.pojo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * 注释: 商品实体
 * @author happy everyday
 * 2019年2月27日上午5:34:13
 */
@Data
public class Item {
	
	/**
	 * 商品id
	 */
	private String itemId;
	/**
	 * 商品名称
	 */
	private String itemName;
	/**
	 * 商品库存
	 */
	private Integer itemStock;
	/**
	 * 商品上架状态
	 */
	private Integer itemStatus;
	/**
	 * 商品类目
	 */
	private Integer itemCategory;
	/**
	 * 商品小图
	 */
	private String itemIcon;
	/**
	 * 商品创建时间
	 */
	private Date createTime;
	/**
	 * 商品更新时间
	 */
	private Date updateTime;

}
