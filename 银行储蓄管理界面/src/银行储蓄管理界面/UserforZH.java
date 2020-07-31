package 银行储蓄管理界面;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class UserforZH {
	public static String User_id;
	UserforZH(String str){
		this.User_id=str;
	}
	public void ActionListenerforZH(JPanel w,String start,String end){
		 List<String> columnZ=new ArrayList<>(Arrays.asList("转账单号","付款方账户","收款方账户","转账日期","转账金额","收款方银行","收款人"));
	       List<List<String>> rowZ=new ArrayList<>();
		   //全表/*
	       JDBCDQ jdbcdq = new JDBCDQ(2);
		 
		   String sql=null;
		   sql="SELECT * FROM yhcxgl_ZH where acnum='"+User_id+"' GROUP BY Ztime,acnum,Zacnum,Zbank,Zjymoney,Zpayee,Znumber having Ztime between '"+start+"'and '"+end+"'";
		   ResultSet rsZH = jdbcdq.slectData(sql);
		   try {
			while(rsZH.next()){
				String acnum =rsZH.getString(2);
				String Zbank=rsZH.getString(6);
				BigDecimal Zjymoney=rsZH.getBigDecimal(5);
				String Zacnum=rsZH.getString(3);
				Date Ztime=rsZH.getDate(4);
				String Znumber=rsZH.getString(1);
				String Zpayee=rsZH.getString(7);
				List<String> row=new ArrayList<>();
					row.add(Znumber);
					row.add(acnum);
					row.add(Zacnum);
					row.add(Ztime.toString());
					row.add(Zjymoney.toString());
					row.add(Zbank);
					row.add(Zpayee);
					rowZ.add(row);
				
					
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MyTable T=new MyTable();
	    T.MyTable(columnZ,rowZ," ",w);
		   
	}
	
	}

