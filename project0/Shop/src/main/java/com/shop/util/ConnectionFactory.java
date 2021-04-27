package com.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/shop";
	private static final String USERNAME  = "postgres";
	private static final String PASSWORD = "postgres";
	
	private static Connection conn;
	
	public static Connection getConnection() {
		
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
	
	}

}
