package ���д���������;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class HQMX {
	 JDBCDQ jdbcdq ;
	 public static int m;
		HQMX(int n){
			this.m=n;
			 jdbcdq = new JDBCDQ(m);
		}
	 public void HQMX(JPanel m,int a,String str) {
		 //ֱ�ӵ���public void MyTable ��J6��� ������
		   	 List<String> columnZ=new ArrayList<>(Arrays.asList("��ˮ��","�˻�","��������","�������","��Ϣ","���","��������"));
	       List<List<String>> rowZ=new ArrayList<>();
		   //ȫ��/*
	    
		 
		   String sql=null;
		   String strPLUS=str+"%";
		 //a=1 �˺� a=2 ��ˮ�� a=3 ������
		   if(a==1) {
			    sql="SELECT * FROM yhcxgl_HQMX WHERE Hacnum like'"+strPLUS+"'";
			    
		   }else if(a==2) {
			   sql="SELECT * FROM yhcxgl_HQMX WHERE Hserialnumber like'"+strPLUS+"'";
		   }else if(a==3) {
			    sql="SELECT * FROM yhcxgl_HQMX where CONVERT(varchar,HCZtime,120)LIKE'"+strPLUS+"'";
		   }else {
			    sql = "SELECT * FROM yhcxgl_HQMX";
		   }
		   
		  
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
