package 银行储蓄管理界面;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.Timer;

public class Userforcrente {
	JPanel lossJPanel,MobliePhone;
	JLabel title;
	JDBCDQ jdbcdq ;
	public static String sql=null,User_id;
	UserforTableaccount Table;
	public static JPanel M;
	public JLabel loss,present,Password;
	private JButton confirm,Moblie;
	private String PasswordW,UPassword;
	Userforcrente(JPanel n,String str,JPanel m){
		title=new JLabel("账户信息");
		M=m;
		jdbcdq = new JDBCDQ(2);
		User_id=str;
		Table=new UserforTableaccount();
		loss=new JLabel("请选择操作功能:");
		n.add(loss);
		loss.setBounds(0, 175, 120, 25);
		loss.setForeground(Color.black);
		
		//挂失内部面板
		
		
		TextBorderUtlis Borderwhite=new TextBorderUtlis(new Color(255,255,255),1,true);
		
		
		
		
			
		
		
		confirm=new JButton();
		n.add(confirm);
		ImageIcon okIcon =new ImageIcon("src/images/loss.jpg");
		confirm.setIcon(okIcon);
		
		
		confirm.setBounds(355, 400, 60, 22);
		confirm.setBorder(Borderwhite);
		confirm.setBackground(Color.white);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ShowMessage Show=new ShowMessage();
				Show.Qusition("                    挂失!","    账户:"+User_id,"如需解挂请移步银行柜台办理!",User_id,2);
			}
			
		});
		
		Moblie=new JButton();
		n.add(Moblie);
		ImageIcon okIconmoblie =new ImageIcon("src/images/password.jpg");
		Moblie.setIcon(okIconmoblie);
		Moblie.setBounds(220, 400, 60, 23);
		Moblie.setBorder(Borderwhite);
		Moblie.setBackground(Color.white);
		JDBCDQ jdbcdq=new JDBCDQ(2);
		Moblie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ShowMessage chance=new ShowMessage();
				chance.Passwordchance(User_id);
			}

			
		});
		
		
		
		
		
		
		
		
		n.add(title);
		title.setBounds(0, 10, 150, 32);
		title.setForeground(Color.blue);
		//开一个线程刷新
		Timer TableAction = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 ActionFreshenTable();
			}
			
		});
		  TableAction.start();
	}
	protected String getString(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public void ActionListenerforcentre() {
		
	}
	private void ActionFreshenTable() {
		 List<String> columnZ=new ArrayList<>(Arrays.asList("账户","密码","户名","出生日期","性别","证件类型","证件号码","预留电话","开户日期","余额","状态"));
	     List<List<String>> rowZ=new ArrayList<>();
		  sql="SELECT * FROM yhcxgl_User WHERE Uacnum='"+User_id+"'";
		  ResultSet Rs = jdbcdq.slectData(sql);
			
			try {
				while(Rs.next()){
				String	Uacnum =Rs.getString(1);
				String password=Rs.getString(2);
					String Uname=Rs.getString(3);
					String	Usex=Rs.getString(4);
					String	UID=Rs.getString(5);
					String  Uphone=Rs.getString(6);
					BigDecimal Ubalance=Rs.getBigDecimal(8);
					String Ustate=Rs.getString(9);
					Date Uopen=Rs.getDate(7);
					Date brithday=Rs.getDate(12);
					String IDStyle=Rs.getString(13);
					List<String> row=new ArrayList<>();
					row.add(Uacnum);
					row.add(password);
					row.add(Uname);
					row.add(brithday.toString());
					row.add(Usex);
					row.add(IDStyle);
					row.add(UID);
					row.add(Uphone);
					row.add(Uopen.toString());
					row.add(Ubalance.toString());
					row.add(Ustate);
					rowZ.add(row);
					//System.out.println(Uacnum+" "+Uname+"  "+Usex+"  "+UID+"  "+Uphone+"   "+Upassword+"  "+"   "+Uopen+"   "+Ubalance);
					
				
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Table.MyTableL(columnZ, rowZ, null,M);
	}
}
