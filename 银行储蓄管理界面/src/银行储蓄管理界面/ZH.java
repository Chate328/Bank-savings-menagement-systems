package ���д���������;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class ZH {
	MyTable T;
	JDBCDQ jdbcdq;
	ZH(int n){
		T=new MyTable();
		jdbcdq = new JDBCDQ(n);
	}
	public void ZHSELECTZH(JPanel m,int a,String str) {
		 //ֱ�ӵ���public void MyTable ��J6��� ������
		   	 List<String> columnZ=new ArrayList<>(Arrays.asList("ת�˵���","����˻�","�տ�˻�","ת������","ת�˽��","�տ����","�տ���"));
	       List<List<String>> rowZ=new ArrayList<>();
		   //ȫ��/*
	    
		 
		   String sql=null;
		   String strPLUS=str+"%";
		 //a=1 �˺� a=2 ��ˮ�� a=3 ������
		   if(a==1) {
			    sql="SELECT * FROM yhcxgl_ZH WHERE acnum like'"+strPLUS+"'";
			    
		   }else if(a==2) {
			   sql="SELECT * FROM yhcxgl_ZH WHERE Znumber like'"+strPLUS+"'";
		   }else if(a==3) {
			    sql="SELECT * FROM yhcxgl_ZH where CONVERT(varchar,Ztime,120)LIKE'"+strPLUS+"'";
		   }else if(a==4){
			    sql = "SELECT * FROM yhcxgl_ZH";
		   }
		   
		  
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
		
	    T.MyTable(columnZ,rowZ," ",m);
		   
	   }
}
