package 银行储蓄管理界面;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class UserforDQMX {
	public static String User_id;
	UserforDQMX(String str){
		this.User_id=str;
	}
	public void ActionListenerforDQMX(JPanel w,String start,String end) {
		JDBCDQ jdbcdq=new JDBCDQ(2);
		 List<String> columnZ=new ArrayList<>(Arrays.asList("流水号","账户","操作日期","操作金额","利息","余额","年限","操作类型"));
	       List<List<String>> rowZ=new ArrayList<>();
		   //全表/*
	    
		 
		   String sql=null;
		   sql="SELECT * FROM yhcxgl_DQMX where Dacnum='"+User_id+"' GROUP BY Dserialnumber,Dnumber,Dacnum,Dtime,Dinterest,Dyemoney,Dyear,Dstyle,Dczmoney,Dproject having Dtime between '"+start+"'and '"+end+"'";

		   ResultSet rsZH = jdbcdq.slectData(sql);
		   try {
			while(rsZH.next()){
				String Dacnum =rsZH.getString(2);
				String Dinterest=rsZH.getString(5);
				String Dczmoney=rsZH.getString(4);
				BigDecimal Dyemoney=rsZH.getBigDecimal(6);
				Date Dtime=rsZH.getDate(3);
				String Dnumber=rsZH.getString(1);
				String Dstyle=rsZH.getString(8);
				String Dyear=rsZH.getString(7);
				List<String> row=new ArrayList<>();
					row.add(Dnumber);
					row.add(Dacnum);
					row.add(Dtime.toString());
					row.add(Dczmoney);
					row.add(Dinterest.toString());
					row.add(Dyemoney.toString());
					row.add(Dyear);
					row.add(Dstyle);
					rowZ.add(row);
				
					
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MyTable M=new MyTable();
	    M.MyTable(columnZ,rowZ," ",w);
		   
	}	
	}

