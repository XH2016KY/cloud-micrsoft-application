package com.oks.client;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="cloud-iorder")
public interface CloudIorderClient {
	
	
	@RequestMapping(value="checkQutity",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Integer> checkQutity() throws ParseException;
	
	@RequestMapping(value="checkIO",method=RequestMethod.GET)
	@ResponseBody
	public File checkFileIO() throws IOException, ParseException;

}
