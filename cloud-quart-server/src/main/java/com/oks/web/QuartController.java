package com.oks.web;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oks.fork.CountTaskTool;
import com.oks.pojo.TestDemo;
import com.oks.service.SkuService;
import com.oks.service.StockService;


@Controller
@RequestMapping(produces="application/json;charset=utf-8")
public class QuartController {
	
	@Autowired
	private SkuService skuService;
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value="client",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Integer> client() throws ParseException{
		return skuService.getInfoSku();
		
	}
	
	@RequestMapping(value="clientIO",method=RequestMethod.GET)
	@ResponseBody
	public String clientIO() throws ParseException, IOException{
		skuService.downLoadFile();
		return "OK";
		
	}
	
	@RequestMapping(value="clientIOtoSQL",method=RequestMethod.GET)
	@ResponseBody
	public String clientToSQL() throws ParseException, IOException, SQLException{
		boolean analysFile = skuService.analysFile();
		return analysFile?"OK":"GG";
		
	}
    
	@RequestMapping(value="clientStock",method=RequestMethod.GET)
	@ResponseBody
	public String Stock() throws IOException {
		File stockInfoFile = stockService.getStockInfoFile();
		return stockInfoFile!=null?"OK":"GG";
		
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<TestDemo> selectTask = CountTaskTool.selectTask(3, 199);
		for(TestDemo t: selectTask) {
			System.out.println(t);
		}
	}
}
