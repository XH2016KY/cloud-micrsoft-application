package com.oks.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oks.annotation.Loacl;
import com.oks.pojo.OrderDetail;

public interface OrderDetailMapper {
	
	@Loacl
	List<OrderDetail> findByOrderId(@Param("orderId")String orderId);
	
	@Loacl
	List<OrderDetail> findByDate(@Param("start")Date start,@Param("end")Date end);

}
