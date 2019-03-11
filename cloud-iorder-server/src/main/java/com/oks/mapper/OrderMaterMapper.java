package com.oks.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oks.annotation.Loacl;
import com.oks.pojo.ItemQutity;
import com.oks.pojo.OrderMaster;

public interface OrderMaterMapper {
	
	
	@Loacl
	OrderMaster findById(@Param("orderId")String orderId);
	
	
	@Loacl
	List<OrderMaster> findByDate(@Param("start")Date start,@Param("end")Date end);
	
	
	/**
	 * 查询所有已支付订单的SKU信息
	 * @param start   起始日期
	 * @param end      截止日期
	 * @return            SKU的最小校对信息
	 */
	@Loacl
	List<ItemQutity>findAllStatus(@Param("start")Date start,@Param("end")Date end);
	


}
