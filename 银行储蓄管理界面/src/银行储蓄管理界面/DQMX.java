package ���д���������;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;
      
public class DQMX {
	JDBCDQ jdbcdq;
		DQMX(int n){
		jdbcdq = new JDBCDQ(n);
		}
	 public void DQMX(JPanel m,int a,String str) {
		 //ֱ�ӵ���public void MyTable ��J6��� ������
		   	 List<String> columnZ=new ArrayList<>(Arrays.asList("��ˮ��","�˻�","��������","�������","��Ϣ","���","����","��������"));
	       List<List<String>> rowZ=new ArrayList<>();
		   //ȫ��/*
	    
		 
		   String sql=null;
		   String strPLUS=str+"%";
		 //a=1 �˺� a=2 ��ˮ�� a=3 ������
		   if(a==1) {
			    sql="SELECT * FROM yhcxgl_DQMX WHERE Dacnum like'"+strPLUS+"'";
			    
		   }else if(a==2) {
			   sql="SELECT * FROM yhcxgl_DQMX WHERE Dserialnumber like'"+strPLUS+"'";
		   }else if(a==3) {
			    sql="SELECT * FROM yhcxgl_DQMX where CONVERT(varchar,Dtime,120)LIKE'"+strPLUS+"'";
		   }else {
			    sql = "SELECT * FROM yhcxgl_DQMX";
		   }
		   
		  
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
	    M.MyTable(columnZ,rowZ," ",m);
		   
	   }
	 
}
