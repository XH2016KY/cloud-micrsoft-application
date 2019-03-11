package com.oks.pojo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * 注释: 订单主表实体
 * @author happy everyday
 * 2019年2月27日上午6:52:27
 */
@Data
public class OrderMaster {
	
	/**
	 * 订单id
	 */
	private String orderId;
    /**
     * 订单所有者的买家名称
     */
	private String buyerName;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 订单更新时间
	 */
	private Date updateTime;
	

}
