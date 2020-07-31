package 银行储蓄管理界面;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class UserforHQMX {
	public static String User_id;
	UserforHQMX(String str){
		User_id=str;
	}
	public void ActionListenerforDQMX(JPanel m,String start,String end) {
		 List<String> columnZ=new ArrayList<>(Arrays.asList("流水号","账户","操作日期","操作金额","利息","余额","操作类型"));
	     List<List<String>> rowZ=new ArrayList<>();
		   //全表/*
	    
		 JDBCDQ jdbcdq=new JDBCDQ(2);
		  
		 String sql="SELECT * FROM yhcxgl_HQMX where Hacnum='"+User_id+"' GROUP BY Hserialnumber,Hnumber,Hacnum,HCZtime,Hinterest,Hyemoney,HStyle,Hyemoney,HQmoney,Hproject having HCZtime between '"+start+"'and '"+end+"'";
		 
		   
		  
		  
		   ResultSet rsZH = jdbcdq.slectData(sql);
		   try {
			while(rsZH.next()){
				String Hacnum =rsZH.getString(2);
				String Hinterest=rsZH.getString(6);
				String HQmoney=rsZH.getString(3);
				BigDecimal Hyemoney=rsZH.getBigDecimal(7);
				Date HCZtime=rsZH.getDate(5);
				String Hnumber=rsZH.getString(1);
				String HStyle=rsZH.getString(4);
				List<String> row=new ArrayList<>();
					row.add(Hnumber);
					row.add(Hacnum);
					row.add(HCZtime.toString());
					row.add(HQmoney);
					row.add(Hinterest.toString());
					row.add(Hyemoney.toString());
					row.add(HStyle);
					rowZ.add(row);
				
					
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MyTable M=new MyTable();
	    M.MyTable(columnZ,rowZ," ",m);
		   
	   }
	}

