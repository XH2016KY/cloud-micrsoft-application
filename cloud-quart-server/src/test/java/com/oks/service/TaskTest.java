package com.oks.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;
import com.oks.fork.CountTask;

@Component
public class TaskTest extends CloudQuartServerApplicationTests{
	
	@Autowired
	private CountTask countTask;
	
	@Test
	public void test1() {
		
	}
}
