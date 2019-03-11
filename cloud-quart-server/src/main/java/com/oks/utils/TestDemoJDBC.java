package com.oks.utils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.oks.pojo.TestDemo;

/**
 * 
 * 注释: JDBC分页查询
 * @author happy everyday
 * 2019年3月3日上午10:20:05
 */
public class TestDemoJDBC {
	
	public static List<TestDemo> page(Integer index,Integer size){
		
		List<TestDemo> list = new ArrayList<>();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
        String sql ="select * from test_demo limit ?,?";
		
		try {
			connection = (Connection) JDBCUtil.create();
			prepareStatement= (PreparedStatement) connection.prepareStatement(sql);
			prepareStatement.setInt(1, index);
			prepareStatement.setInt(2, size);
			resultSet = prepareStatement.executeQuery();
			TestDemo demo = null;
			while(resultSet.next()){
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				
				demo = new TestDemo();
				
				demo.setId(id);
				demo.setName(name);
				list.add(demo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(resultSet, prepareStatement, connection);
		}
		return list;
		
	}
	
	public static void main(String[] args) {
		List<TestDemo> page = TestDemoJDBC.page(PageCalculator.calculateRowIndex(1,10),10);
		for(TestDemo t:page) {
			System.out.println(t);
		}
	}

}
