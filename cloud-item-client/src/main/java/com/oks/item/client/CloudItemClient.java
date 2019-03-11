package com.oks.item.client;

import java.io.File;
import java.io.IOException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name="cloud-item")
public interface CloudItemClient {

	@RequestMapping(value="getStockIO",method=RequestMethod.GET)
	@ResponseBody
	public File checkStockIO() throws IOException;
}
