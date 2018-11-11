package com.jskp.naidu;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	
	public static void main(String[] args) {
		//if you are using mysql8 then String jdbcUrl = "jdbc:mysql://localhost:3306/hibernateudemydb?useSSL=false";
		//to get rid of the MySQl warnings;
		String jdbcUrl = "jdbc:mysql://localhost:3306/hibernateudemydb";
		String username="root";
		String password="root";
		try {
			System.out.println("connecting to JDBC URL="+jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection successfull!!!"+con);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());		}
	}
}
