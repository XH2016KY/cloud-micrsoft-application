package com.oks.service.impl;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.mapper.QuartResultMapper;
import com.oks.mapper.SQLMapper;
import com.oks.pojo.QuartResult;
import com.oks.service.QuartStrategy;

/**
 * 
 * 注释: sql校验实现
 * @author happy everyday
 * 2019年3月4日上午8:13:29
 */
@Service("sQLQuartStrategy")
public class SQLQuartStrategyImpl implements QuartStrategy{
	
	@Autowired
	private QuartResultMapper quartResultMapper;
	
	@Autowired
	private SQLMapper sQLMapper;

	@Override
	public Set<String> compareStock() throws ParseException {
		// 1.先找出校验有差异的商品名集合
		List<QuartResult> quart = quartResultMapper.quart();
		Set<String> sets = new HashSet<>();
		// 2.遍历集合
		// a.从tb_quartInfo_order中查询到item_name
		// b.从tb_stock_old 中查询到item_stock_old
		// c.从tb_stock_new中查询到item_stock_new
		for(int i =0;i<quart.size();i++) {
			if(null==sQLMapper.findByName(quart.get(i).getItemName())) {
				if(0==sQLMapper.findByOldName(quart.get(i).getItemName())
					-sQLMapper.findByNewName(quart.get(i).getItemName())) {
					quart.remove(i);
				}
			}else {
				sets.add(quart.get(i).getItemName()+":"+"库存校对有差异");
			}
		}
		String oks = "SQL实现";
		sets.add(oks);
		return sets;
	}

	@Override
	public String getResult() throws ParseException {
		Set<String> compareStock = this.compareStock();
		return compareStock.size()==1?"数据校验正确":compareStock.toString();
	}

}
