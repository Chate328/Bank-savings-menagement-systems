package ���д���������;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDQ {
	String User=null;
	String Password=null;
	JDBCDQ(int n){
		if(1==n) {
			User="sa";
			Password="123456";
		}else if(2==n) {
			User="Employee";
			Password="123456";
		}
	}
	
	String url="jdbc:sqlserver://192.168.132.1:1433;DatabaseName=yhgxgl";	
	//��ѯ
	public  ResultSet slectData(String sql) {
		//�˻�
		Connection con;
		Statement stmt;
		//����SQL sever 2018
		//String url="jdbc:sqlserver://192.168.132.1:1433;DatabaseName=yhgxgl";
		ResultSet rs = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(java.lang.ClassNotFoundException a) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(a.getMessage());
		}
		
		try {
			con =DriverManager.getConnection(url,User,Password);
			stmt =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery(sql);
			//�ر����ݿ�	
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ex.getMessage());
			
		}
		return rs;
		
	}
	
	//ɾ��\����\�޸�
	public int excuteData(String sql) {
		Connection con;
		Statement stmt;	
		int result = 1;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(java.lang.ClassNotFoundException a) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(a.getMessage());
		}
		
		try {
			con =DriverManager.getConnection(url,User,Password);
			stmt =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate(sql);
			//�ر����ݿ�
			stmt.close();
			con.close();
			
		}catch(SQLException ex) {
			result = 0;
			System.out.println("SQLException: "+ex.getMessage());
			System.out.println(result);
		}
		return result;
	}
	
}
