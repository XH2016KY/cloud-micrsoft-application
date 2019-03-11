package com.oks.web;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oks.service.CheckStockService;

/**
 * 
 * 注释: 校验库存接口
 * @author happy everyday
 * 2019年3月2日上午7:57:57
 */
@Controller
@RequestMapping(produces="application/json;charset=utf-8")
public class CheckStockController {
	
	@Autowired
	private CheckStockService checkStockService;
	
	@RequestMapping(value="getStockIO",method=RequestMethod.GET)
	@ResponseBody
	public File checkStockIO() throws IOException {
		return checkStockService.getStockInfoFile();
		
	}
	

}
