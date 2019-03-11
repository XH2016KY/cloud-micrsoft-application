package com.oks.pojo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * 注释: 订单详情表
 * @author happy everyday
 * 2019年2月27日上午7:03:40
 */
@Data
public class OrderDetail {
    /**
     * 订单详情表id
     */
	private String detailId;
	/**
	 * 订单主表id
	 */
	private String orderId;
	/**
	 * 商品id
	 */
	private String itemId;
	/**
	 * 商品名称
	 */
	private String itemName;
	/**
	 * 商品购买数量
	 */
	private Integer itemQutity;
	/**
	 * 商品小图
	 */
	private String itemIcon;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	
}
