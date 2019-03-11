package com.oks.pojo;

import lombok.Getter;

@Getter
public enum NameEnums {
	
	ONE(0,"oks"),TWO(1,"pl"),THREE(2,"Tom"),
	FOUR(3,"Dave"),FIVE(4,"GGG");
	
	private Integer code;
	
	private String name;
	
	private NameEnums(Integer code,String name) {
		this.code = code;
		this.name = name;
	}
	
   public static String stateof(int state){
		
		for(NameEnums nameEnum:values()){
			if(nameEnum.getCode()==state){
				return nameEnum.getName();
			}
		}
		return null;		
	}

}
