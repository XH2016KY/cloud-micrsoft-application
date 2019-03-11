package com.oks.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.CloudQuartServerApplicationTests;

@Component
public class SQLMapperTest extends CloudQuartServerApplicationTests {

	@Autowired
	private SQLMapper sqlMapper;

	@Test
	public void testfindByName() {
         String findByName = sqlMapper.findByName("鼠标");
         System.out.println(findByName);
	}

	@Test
	public void testfindByOldName() {
         Integer findByOldName = sqlMapper.findByOldName("鼠标");
         System.out.println(findByOldName);
	}

	@Test
	public void testfindByNewName() {
         Integer findByNewName = sqlMapper.findByNewName("鼠标");
         System.out.println(findByNewName);
	}

}
