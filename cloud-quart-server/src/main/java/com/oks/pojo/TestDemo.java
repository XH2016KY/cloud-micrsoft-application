package com.oks.pojo;


import lombok.Data;
import lombok.ToString;

/**
 * 
 * 注释: 测试多线程实体
 * @author happy everyday
 * 2019年3月3日上午3:45:23
 */
@Data
@ToString
public class TestDemo {
	
	/**
	 *  id
	 */
	private Long id;
	/**
	 *  名称
	 */
	private String name;
	
    public static void main(String[] args) {
		// 生成一个0-4的随机数
    	for(int i=1;i<=30;i++) {
    		int num = (int)((Math.random())*5);
    		System.out.println(num);
    	System.out.println(NameEnums.stateof(num));
    	}   	
//    	int num1 = (int)((Math.random())*5);
//    	System.out.println(num1);
	}
}
