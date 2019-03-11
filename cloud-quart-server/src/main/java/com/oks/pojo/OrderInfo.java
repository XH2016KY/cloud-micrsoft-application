package com.oks.pojo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * 注释: 订单SKU信息实体
 * @author happy everyday
 * 2019年3月3日下午1:09:20
 */
@Data
public class OrderInfo {
	
    private String itemName;
	
	private Integer itemQutity;
	
	private Date createTime;

}
