package com.java.test;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
	/*
	 * 链接数据了并且将其封装 可以供其他数据操作调用 װ
	 */
	 @SuppressWarnings("finally")
	public static Connection getConnection() {
	 Connection conn=null;
	  String driverName="com.mysql.jdbc.Driver";
	  String dbURL="jdbc:mysql://localhost:3306/student";
	  String userName="root";
	  String userPwd="666666";
	  try {
	   Class.forName(driverName);
	   conn = DriverManager.getConnection(dbURL,userName,userPwd);
	  }
	  catch(Exception e)
	  {
	   e.printStackTrace();
	  } finally{
		  return conn;
	  }
 }
	  
	 public static void main(String[] args) {
		 Connection conn=DBUtil.getConnection(); 
		 if (conn==null) {
			 System.out.println("数据库连接失败");
			
		}else {
			System.out.println("数据库连接成功");
		}
	}


}
