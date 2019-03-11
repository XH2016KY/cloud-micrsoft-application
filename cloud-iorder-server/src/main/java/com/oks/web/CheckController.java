package com.oks.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.oks.service.CheckService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * 注释: SKU信息服务接口
 * @author happy everyday
 * 2019年3月1日上午12:29:41
 */
@Controller
@RequestMapping(produces="application/json;charset=utf-8")
public class CheckController {
	
	
	@Autowired
	private JedisPool jedisPool;
	
	@Autowired
	private CheckService checkService;
	
	@RequestMapping(value="checkQutity",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Integer> checkQutity() throws ParseException{
		return checkService.checkQutity(new Date());
	}
	
	@RequestMapping(value="checkIO",method=RequestMethod.GET)
	@ResponseBody
	public File checkFileIO() throws IOException, ParseException {
		return checkService.checkFileIO(new Date());
		
	}

	@RequestMapping(value="jedis",method=RequestMethod.GET)
	@ResponseBody
	public String jedis() {
		Jedis resource = null;
		try {
			resource = jedisPool.getResource();
			return resource.get("cloud");
		} finally {
			resource.close();
		}
	}

}
