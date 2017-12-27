package com.java.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class InsertTest {
 
    public static void main(String[] args) {
 
       Connection conn = DBUtil.getConnection();
       String sql = "insert into stu_information (username,classes,birthday,city,qq,words,phone) values (?,?,?,?,?,?,?)";
 
       try {
           PreparedStatement prep = conn.prepareStatement(sql);
          
           // 将连接的自动提交关闭，数据在传送到数据库的过程中相当耗时
           conn.setAutoCommit(false);
           long start = System.currentTimeMillis();
          
           for (int i = 1; i < 101; i++) {
             
              long start2 = System.currentTimeMillis();
             
              // 一次性执行插入10万条数据
              for (int j = 1; j < 300001; j++) {
                 
                  prep.setString(1, "付伟"+i*j);
                  prep.setString(2, "java");
                  prep.setInt(3, 1995-02-02);
                  prep.setString(4, "成都");
                  prep.setInt(5, 18515465);
                  prep.setString(6, "插入3000万条记录");
                  prep.setInt(7, 11598257);
                 
                  // 将预处理添加到批中
                  prep.addBatch();
                 
              }
             
              // 预处理批量执行
              prep.executeBatch();
              prep.clearBatch();
              conn.commit();
             
              long end2 = System.currentTimeMillis();
             
              // 批量执行一次批量打印执行依次的时间
              System.out.print("inner"+i+": ");
              System.out.println(end2 - start2+"S");
 
           }
          
           long end = System.currentTimeMillis();
           System.out.print("total: ");
           System.out.println(end - start +"S");
          
       } catch (SQLException e) {
 
           e.printStackTrace();
       } finally {
 
           try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
      
    }
 
}