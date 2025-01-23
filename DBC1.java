package com_1.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBC1 {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDB","root", "hasmashaik@2310");
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return con;
	}

}
