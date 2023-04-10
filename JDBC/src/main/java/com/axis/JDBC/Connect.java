package com.axis.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
		
	public static Connection getConnection() {
		Connection conn = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/axisbank-jdbc";
		String userName = "root";
		String password ="root";
		
		conn=DriverManager.getConnection(url,userName,password);
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			
		}
		return conn;
	}
}
