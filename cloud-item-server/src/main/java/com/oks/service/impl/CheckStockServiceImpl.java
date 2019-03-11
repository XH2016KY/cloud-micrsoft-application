package com.oks.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.enums.SplitTools;
import com.oks.mapper.ItemMapper;
import com.oks.pojo.ItemStock;
import com.oks.service.CheckStockService;

@Service("checkStockService")
public class CheckStockServiceImpl implements CheckStockService{
	
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public Map<String, ItemStock> getStockInfo() {
		return itemMapper.selectStock();
	}

	@Override
	public File getStockInfoFile() throws IOException {
		FileWriter writer=null;
		writer = new FileWriter("F://item-stock//stock.txt");
		BufferedWriter buff;
		buff = new BufferedWriter(writer);
		Map<String, ItemStock> stockInfo = getStockInfo();
	    Set<String> keySet = stockInfo.keySet();
	    try {
	    	
	    	keySet.stream().forEach(e->{
	    		try {
					buff.write(e + SplitTools.ONE.getSplit()+ stockInfo.get(e).getItemStock() + 
							SplitTools.TWO.getSplit());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    	});
	    	return new File("F://item-stock//stock.txt");
		} finally {
			// 关闭流一定要按顺序
			buff.close();
			writer.close();
		}
	  
	}

}

//			for (String e : keySet) {
//				buff.write(e + ":" + stockInfo.get(e).getItemStock() + "|");
//			} 
//			return new File("F://item-stock//stock.txt");