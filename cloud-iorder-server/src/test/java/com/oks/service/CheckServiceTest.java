package com.oks.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudIorderServerApplicationTests;

@Component
public class CheckServiceTest extends CloudIorderServerApplicationTests{
	
	
	@Autowired
	private CheckService checkService;
	
	
	@Test
	public void testCheckQutity() throws ParseException {
		Map<String, Integer> checkQutity = checkService.checkQutity(new Date());
		System.out.println(checkQutity);
		assertEquals(2,checkQutity.size());
	}
	
	
	@Test
	public void testcheckFileIO() throws IOException, ParseException {
		File checkFileIO = checkService.checkFileIO(new Date());
		assertNotEquals(null, checkFileIO);
	}
	

}
