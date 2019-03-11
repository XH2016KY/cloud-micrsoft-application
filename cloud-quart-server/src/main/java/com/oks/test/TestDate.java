package com.oks.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	
	public static void main(String[] args) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		System.out.println(sd.format(d));
		// 拿到相隔时间一天的两个日期
		Date d1 = new Date(d.getTime()+24*3600*1000L);
		System.out.println(sd.format(d1));
		System.out.println(TestDate.add(0, 800));
	}
	
	
	public static int add(int start,int end) {
		int sum =0;
		for(int i=start;i<=end;i++) {
			sum +=i;
		}
		return sum;
	}

}
