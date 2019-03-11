package com.oks.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Predicate;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * 
 * 注释: 数据库连接
 * @author happy everyday
 * 2019年3月3日上午6:05:44
 */
public class JDBCUtil {
	
	/**
	 * 1.创建连接
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection create() throws IOException, ClassNotFoundException, SQLException {

		// 读取jdbc.properties文件
		//InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		//InPutStream in = new InPutStr
		File f = new File("C:\\Users\\happyeveryday\\Desktop\\Servlet-JSP\\jdbcTask.properties");
		InputStream inputStream = new FileInputStream(f);
		// 创建加载properties
		Properties properties = new Properties();
		properties.load(inputStream);		// 用户名
		String user = properties.getProperty("jdbc.user");
		// 密码
		String password = properties.getProperty("jdbc.password");
		// url
		String url = properties.getProperty("jdbc.url");
		// 驱动类
		String driverClass = properties.getProperty("jdbc.driverClass");
		// 驱动
		Class.forName(driverClass);
		Connection connection = (Connection) DriverManager.getConnection(url, user, password);
		return connection;
	}

	/**
	 * 2.关闭连接资源
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static int[] release(ResultSet resultSet, PreparedStatement preparestatement, Connection connection) {
		int b = 0;
		int a = 0;
		int c = 0;
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != preparestatement) {
			try {
				preparestatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != connection) {
			try {
				connection.close();
				a++;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int[] D = { a, b, c };
		return D;

	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		/* System.out.println(JDBCUtils.create()); */
		Connection connection = JDBCUtil.create();
		int[] release = JDBCUtil.release(null, null, connection);
		// Predicate<T>是一个断言接口
		Predicate<Integer> p = i -> release[0] == 1;
		System.out.println(p.test(release[0]));
		System.out.println(connection);

	}
	/**
	 * 总结:关闭了连接不代表connection对想就为null,对象是引用,参数传的是值而不是引用！！！！！
	 */

}
