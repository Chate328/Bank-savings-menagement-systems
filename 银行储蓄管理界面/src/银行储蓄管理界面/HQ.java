package ���д���������;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class HQ {
	MyTable T;
	JDBCDQ jdbcdq;
	HQ(int n){
		T=new MyTable();
		jdbcdq = new JDBCDQ(n);
	}
	 public void HqSelectPanel(JPanel m,int a,String str) {
		   List<String> columnb=new ArrayList<>(Arrays.asList("����","�˻�","������","��������","���","������� "));
	       List<List<String>> rowb=new ArrayList<>();
		   //ȫ��/*
	     
	       String sql=null;
	       String strPLUS=str+"%";
	       if(a==1) {
			    sql="SELECT * FROM yhcxgl_HQ WHERE Hacnum like'"+strPLUS+"'";
			    
		   }else if(a==2) {
			   sql="SELECT * FROM yhcxgl_HQ WHERE Hnumber like'"+strPLUS+"'";
		   }else if(a==3) {
			    sql="SELECT * FROM yhcxgl_HQ where CONVERT(varchar,Hcrtime,120)LIKE'"+strPLUS+"'";
			   
		   }else {
			    sql = "SELECT * FROM yhcxgl_HQ";
			   
		   }
		   
	       
		 
		   ResultSet rs = jdbcdq.slectData(sql);
		   try {
			while(rs.next()){
					String Hacnum =rs.getString(2);
					BigDecimal Hckmoney=rs.getBigDecimal(3);
					BigDecimal Hyemoney=rs.getBigDecimal(6);
					Date Hcrtime=rs.getDate(5);
					String Hnumber=rs.getString(1);
					String HStyle=rs.getString(4);
					List<String> rowc=new ArrayList<>();
					rowc.add(Hnumber);
					rowc.add(Hacnum);
					rowc.add(Hckmoney.toString());
					rowc.add(Hcrtime.toString());
					rowc.add(Hyemoney.toString());
					rowc.add(HStyle);
					rowb.add(rowc);
					//System.out.println(Hnumber+" "+Hacnum+"  "+Hckmoney+"  "+Hcrtime+"  "+Hyemoney+"   "+HStyle+" ");
					
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     T.MyTable(columnb,rowb,"",m);
	 
		   
		  
	   }
	   
	   
}
