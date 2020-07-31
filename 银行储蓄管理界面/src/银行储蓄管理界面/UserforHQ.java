package 银行储蓄管理界面;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

public class UserforHQ {
	public  static String User_id;
	
	UserforHQ(String str){
		this.User_id=str;
	}
      public void ActionListenerforHQ(JPanel w,String start,String end) {
    	  JDBCDQ jdbcdq = new JDBCDQ(2);
			String sql=null;
			sql="SELECT * FROM yhcxgl_HQ WHERE Hacnum='"+User_id+"' group by Hcrtime,Hacnum,Hyemoney,Hnumber,Hckmoney,HStyle having Hcrtime between '"+start+"' AND   '"+end+"'";
			//构建表格
			 List<String> columnb=new ArrayList<>(Arrays.asList("活期存款单号","账户","存入金额","存入日期","余额","存款种类 "));
		     List<List<String>> rowb=new ArrayList<>();
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
			   MyTable T=new MyTable();
			   T.MyTable(columnb, rowb," ", w);
		}
		
      }

