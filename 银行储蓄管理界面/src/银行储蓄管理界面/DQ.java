package 银行储蓄管理界面;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DQ {
	MyTable T;
	JDBCDQ jdbcdq;
	DQ(int n){
		T=new MyTable();
		jdbcdq = new JDBCDQ(n);
	}
	//定期查询SELECT *FROM yhcxgl_DQ
	   public void DQSELECTPanel(JPanel m,int a,String str) {
	      
	      
		  //直接调用public void MyTable 在J6面板 构造表格
		   	 List<String> columns=new ArrayList<>(Arrays.asList("存款单号","账户","存入金额","存入日","余额","年限","利息","存款种类"));
	         List<List<String>> rows=new ArrayList<>();
		   //全表/*
	   
		   String sql=null;
		   String strPLUS=str+"%";
		   //a=1 账号 a=2 流水号 a=3 存入日
		   if(a==1) {
			    sql="SELECT * FROM yhcxgl_DQ WHERE Dacnum like'"+strPLUS+"'";
			    
		   }else if(a==2) {
			   sql="SELECT * FROM yhcxgl_DQ WHERE Dnumber like'"+strPLUS+"'";
		   }else if(a==3) {
			    sql="SELECT * FROM yhcxgl_DQ WHERE CONVERT(varchar,Dcrtime,120)LIKE'"+strPLUS+"'";
			 
		   }else {
			    sql = "SELECT * FROM yhcxgl_DQ";
		   }
		   
		  
		   ResultSet rs = jdbcdq.slectData(sql);
		   try {
			while(rs.next()){
					String Dacnum =rs.getString(2);
					String Dyear=rs.getString(6);
					BigDecimal Dmoney=rs.getBigDecimal(3);
					BigDecimal Dbalance=rs.getBigDecimal(5);
					Date Dcrtime=rs.getDate(4);
					String Dnumber=rs.getString(1);
					String DStyle=rs.getString(8);
					BigDecimal Dinterest=rs.getBigDecimal(7);
					List<String> row=new ArrayList<>();
					row.add(Dnumber);
					row.add(Dacnum);
					row.add(Dmoney.toString());
					row.add(Dcrtime.toString());
					row.add(Dbalance.toString());
					row.add(Dyear);
					row.add(Dinterest.toString());
					row.add(DStyle);
					rows.add(row);
				   // System.out.println(Dnumber+" "+Dacnum+"  "+Dmoney+"  "+Dcrtime+"  "+Dbalance+"   "+Dyear+" "+Dinterest+" "+DStyle);
					
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   
	       T.MyTable(columns,rows," ",m);
	   
		   
		  
	       
	   }
	  
	  
}
