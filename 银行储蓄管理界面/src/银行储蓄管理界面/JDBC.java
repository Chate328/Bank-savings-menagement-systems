package 银行储蓄管理界面;

import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	
	String User=null;
	String Password=null;
	JDBC(int n){
		if(1==n) {
			User="sa";
			Password="123456";
		}else if(2==n) {
			User="Employee";
			Password="123456";
		}
	}
	
	String url="jdbc:sqlserver://192.168.132.1:1433;DatabaseName=master";	
	//查询
	public  int Proc(String sql) {
		//账户
		Connection con;
		Statement stmt;
		//连接SQL sever 2018
		//String url="jdbc:sqlserver://192.168.132.1:1433;DatabaseName=yhgxgl";
		int result=1;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(java.lang.ClassNotFoundException a) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(a.getMessage());
		}
		
		try {
			con =DriverManager.getConnection(url,User,Password);
			CallableStatement c=con.prepareCall(sql);
			c.setInt(3,100);
			//关闭数据库	
		}catch(SQLException ex) {
			System.out.println("SQLException: "+ex.getMessage());
			result=0;
		}
		return result;
		
	}
	//删除\插入\修改
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
				//关闭数据库
				stmt.close();
				con.close();
				
			}catch(SQLException ex) {
				result = 0;
				System.out.println("SQLException: "+ex.getMessage());
				
			}
			return result;
		}
	
}
