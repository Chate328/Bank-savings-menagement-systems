package ���д���������;

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
	//���ڲ�ѯSELECT *FROM yhcxgl_DQ
	   public void DQSELECTPanel(JPanel m,int a,String str) {
	      
	      
		  //ֱ�ӵ���public void MyTable ��J6��� ������
		   	 List<String> columns=new ArrayList<>(Arrays.asList("����","�˻�","������","������","���","����","��Ϣ","�������"));
	         List<List<String>> rows=new ArrayList<>();
		   //ȫ��/*
	   
		   String sql=null;
		   String strPLUS=str+"%";
		   //a=1 �˺� a=2 ��ˮ�� a=3 ������
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
