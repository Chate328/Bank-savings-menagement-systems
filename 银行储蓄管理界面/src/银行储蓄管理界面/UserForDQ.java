package ���д���������;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class UserForDQ {
	public static String User_id;
	UserForDQ(String str){
		this.User_id=str;
	}
	public void ActionListenerforDQ(JPanel w,String start,String end) {
		JDBCDQ jdbcdq = new JDBCDQ(2);
		 String sql=null;
		 sql="SELECT * FROM yhcxgl_DQ WHERE Dacnum='"+User_id+"' group by Dcrtime,Dacnum,Dmoney,Dnumber,Dbalance,Dyear,Dinterest,DStyle having Dcrtime between '"+start+"' AND   '"+end+"'";
		 ResultSet rs = jdbcdq.slectData(sql);
		 List<String> columns=new ArrayList<>(Arrays.asList("���ڴ���","�˻�","������","������","���","����","��Ϣ","�������"));
        List<List<String>> rows=new ArrayList<>();
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
		   MyTable T=new MyTable();
		 
		   T.MyTable(columns,rows," ",w);
	}
	}

