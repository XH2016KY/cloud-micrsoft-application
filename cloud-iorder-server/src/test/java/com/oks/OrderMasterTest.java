package com.oks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.mapper.OrderDetailMapper;
import com.oks.mapper.OrderMaterMapper;
import com.oks.pojo.OrderDetail;
import com.oks.pojo.OrderMaster;

@Component
public class OrderMasterTest extends CloudIorderServerApplicationTests{
	
	
	@Autowired
	private OrderMaterMapper orderMaterMapper;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;
	
	
	@Test
	public void testfindById() {
		OrderMaster findById = orderMaterMapper.findById("x00001");
		System.out.println(findById);
		
		Set<String> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		List<OrderDetail> findByOrderId = orderDetailMapper.findByOrderId(findById.getOrderId());
		System.err.println(findByOrderId);
		findByOrderId.stream().forEach(i->{
			// 可以用lamda的分组
			list.add(i.getItemName()+":"+i.getItemQutity());
		});
	    Map<Boolean, List<OrderDetail>> collect = findByOrderId.stream().collect(Collectors.partitioningBy(s->s.getItemName().equals("网卡")));
	    System.out.println(collect);
	    // 分组
	    Map<String, List<OrderDetail>> collect2 = findByOrderId.stream().collect(Collectors.groupingBy(OrderDetail::getItemName));
	    MapUtils.verbosePrint(System.out, "分组信息", collect2);
	}
	
	@Test
	public void testfindByOrderId() {
		List<OrderDetail> findByOrderId = orderDetailMapper.findByOrderId("x00001");
		// TODO 怎么把所有订单的商品信息 --->商品id 、商品卖出数量多线程统计
		System.out.println(findByOrderId);
	}
	
	
	@Test
	public void testfindByDate() throws ParseException {
		@SuppressWarnings("unused")
		Date start = null;
		@SuppressWarnings("unused")
		Date end = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		start = sd.parse("2018-01-01 00:00:00");
		end = sd.parse("2018-12-31 00:00:00");
		List<OrderMaster> findByDate = orderMaterMapper.findByDate(start, new Date());
		
		String format = sd.format(new Date());
		System.out.println(format);
		System.out.println(findByDate);
	}
	
	
	@Test
	public void testDate() throws ParseException {
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = sd.parse("2018-01-01 00:00:00");
		List<OrderMaster> findByDate = orderMaterMapper.findByDate(start, new Date());
		List<OrderDetail> orderDetails = new ArrayList<>();
		findByDate.stream().forEach(i->{
			orderDetails.addAll(orderDetailMapper.findByOrderId(i.getOrderId()));
		});
		System.out.println(orderDetails);
		System.err.println(orderDetails.size());
		
		
	}
	
	@Test
	public void testDate1() throws ParseException {
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = sd.parse("2018-01-01 00:00:00");
	    List<OrderDetail> findByDate = orderDetailMapper.findByDate(start, new Date());
	    findByDate.stream().forEach(i->{
	    	System.out.println(i);
	    });
	    System.out.println(findByDate.size());
		
		
	}
	
//	@Test
//	public void test() throws ParseException, IOException {
//		List<ItemQutity> itemQutities = checkQutityService.check(new Date());
//		FileWriter writer = new FileWriter("F://iorder//orderdetail.txt");
//		BufferedWriter buff = new BufferedWriter(writer);
//		itemQutities.stream().forEach(e->{
//			try {
//				buff.write(e.getItemName()+","+e.getItemQutity()+"|");
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//		});
//		buff.close();
//		writer.close();
//	}

}
