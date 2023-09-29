package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 測試資料庫有沒有連接上
 **/

public class DbUtil {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/fruit_database"; // 資料庫連接地址
	private String dbUserName = ""; // 用戶名
	private String dbPassword = ""; // 密碼
	
	// 獲取資料庫連接
	public Connection getCon() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	// 關閉資料庫連接
	public void closeCon(Connection con) throws Exception {
		if(con!=null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("fail");
		}
	}
}

