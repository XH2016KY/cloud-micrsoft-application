package com.oks.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.client.CloudIorderClient;
import com.oks.service.SkuService;

@Service("skuService")
public class SkuServiceImpl implements SkuService{
	
	@Autowired
	private CloudIorderClient cloudIorderClient;

	@Override
	public Map<String, Integer> getInfoSku() throws ParseException {
		return cloudIorderClient.checkQutity();
	}

	@Override
	public void downLoadFile() throws IOException, ParseException {
		 File checkFileIO = cloudIorderClient.checkFileIO();
		 FileReader reader = new FileReader(checkFileIO);
		 FileWriter writer =new FileWriter("F://io-order//quartOrder.txt");
		//char数组读取 
		 char[] flush=new char[1024]; 
		 int len=0; 

		 try {
			while (-1 != (len = reader.read(flush))) {
				String str = new String(flush, 0, len);
				System.out.println(str);
				writer.write(str);
			} 
		} finally {
			reader.close(); 
			writer.close();
		}
	}

	@Override
	public boolean analysFile() throws SQLException {
		String url = "jdbc:mysql://192.168.200.139:3306/quart?characterEncoding=utf-8&useSSL=false";
		String username="root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		String sql = "load data local infile 'F://io-order//quartOrder.txt'  ignore into table tb_quartInfo_order\r\n" + 
				"						character set 'utf8' \r\n" + 
				"						fields terminated by ':' \r\n" + 
				"						lines terminated by '|' (item_name,item_qutity,create_time);";
		CallableStatement prepareCall = connection.prepareCall(sql);
		prepareCall.execute();
		System.out.println(prepareCall.execute());// false->没有ResultSet结果集
		connection.close();
		return true;
	}
}
