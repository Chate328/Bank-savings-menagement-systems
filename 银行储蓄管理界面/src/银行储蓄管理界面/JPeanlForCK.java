package 银行储蓄管理界面;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPeanlForCK {
	JDBCDQ jdbcdq;
	public static int w;
	public static String User_id;
	JPeanlForCK(int n,int m,String str){
		User_id=str;
		w=m;
		jdbcdq = new JDBCDQ(n);
	}
	 public void setJ8Panel(JPanel n) {
		   JLabel JLb1,JLb2,JLb3,JLb5,JLb6,JLb7,JLb8,JLb9;
		   JTextField JTe1,JTe2,JTe6;
		   JPasswordField JTe4,JTe5;
		   JButton confirm,cancel;
		   JCheckBox box1,box2,box3;
		   TextBorderUtlis Border=new TextBorderUtlis(new Color(0,191,255),2,true);
		   TextBorderUtlis BorderP=new TextBorderUtlis(new Color(255,255,255),1,true);
		   JLb1=new JLabel("存款业务");
		   JLb1.setForeground(Color.BLUE);
		   JLb1.setBounds(0,0,100,25);
		   n.add(JLb1);
		   
		   JLb2=new JLabel("请您填写存款账户:");
		   JLb2.setBounds(40,40,120,25);
		   n.add(JLb2);
		   
		   JLb3=new JLabel("存款账户 :");
		   JLb3.setBounds(60,70,100,25);
		   n.add(JLb3);
		   
		   JTe1=new JTextField();
		  
		   n.add(JTe1);
		   JTe1.setBounds(150,70,200,25);
		   if(w==3){
			   JTe1.setText(User_id);
			   JTe1.setEditable(false);
			   JTe1.setBackground(Color.white);
			   JTe1.setBorder(BorderP);
		   }else {
			   JTe1.setBorder(Border);
		   }
		   
		   JLb2=new JLabel("请您填写存款信息 :");
		   JLb2.setBounds(40,100,120,25);
		   n.add(JLb2);
		   
		   JLb6=new JLabel("存入金额 :");
		   JLb6.setBounds(60,140,100,25);
		   n.add(JLb6);
		   
		   JTe2=new JTextField();
		   JTe2.setBorder(Border);
		   n.add(JTe2);
		   JTe2.setBounds(150,140,200,25);
		   
		   
		   JLb8=new JLabel("存款类型:");
		   JLb8.setBounds(60,250,100,25);
		   n.add(JLb8);
		   
		   JComboBox<String> deposit=new JComboBox<String>();
			deposit.addItem("活期存款");
			deposit.addItem("定期三个月");
			deposit.addItem("定期半年");
			deposit.addItem("定期一年");
			deposit.addItem("定期两年");
			deposit.addItem("定期三年");
			deposit.addItem("定期五年");
			deposit.setBorder(Border);
			deposit.setBackground(new Color(255,255,255));
			deposit.setBounds(150, 250, 200, 25);
			n.add(deposit);
		   
		   //输入密码 
		   JLb5=new JLabel("请您输入密码:");
		   JLb5.setBounds(60,320,100,25);
		   n.add(JLb5);
		   //输入密码框
		   JTe4=new JPasswordField();
		   JTe4.setBorder(Border);
		   n.add(JTe4);
		   JTe4.setBounds(150,320,100,25);
		   //确认密码
		   JLb9=new JLabel("确认密码:");
		   JLb9.setBounds(60,370,100,25);
		   n.add(JLb9);
		   //确认密码框
		   JTe5=new JPasswordField();
		   JTe5.setBorder(Border);
		   n.add(JTe5);
		   JTe5.setBounds(150,370,100,25);
		   
		   JLb7=new JLabel("请您选择存款类型:");
		   JLb7.setBounds(40,190,120,25);
		   n.add(JLb7);
		   
		   
		   
		   // 确定按钮
		   confirm=new JButton();
		   n.add(confirm);
		   ImageIcon IconU =new ImageIcon("src/images/QR.jpg");
		   confirm.setBorder(BorderP);
		   confirm.setIcon(IconU);
		   confirm.setBounds(150,460,60,22);
		   
		   confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Pattern J=new Pattern();
				Boolean i=J.isNumber(JTe2.getText());
				if(i) {//验证非法金额
					if(JTe4.getText().equals(JTe5.getText())) 
					{//验证密码
						
						//验证是否是非法存款账户
					
						String sql="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JTe1.getText()+"'";
						ResultSet rs = jdbcdq.slectData(sql);
						Boolean flag=false;
						//检测返回值是否为空
						try {
								if(rs.next())
								{
									flag=true;
								}else {
									ShowMessage Facnum=new ShowMessage();
									Facnum.init("  	非法账户");
								}
							//如果是合法账户则下一步
								
								
								if(flag) {
									//校验MD5算法密码
									int UstateNumber = 0;
									String sqlNumber="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JTe1.getText()+"'";
									ResultSet rsNumber = jdbcdq.slectData(sqlNumber);
									try {
										while(rsNumber.next()) {
											UstateNumber=rsNumber.getInt(14);
										}
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									if(UstateNumber==1) {
										
										String Upassword=null;
										String sqlpassword="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JTe1.getText()+"'";
										ResultSet rspassword = jdbcdq.slectData(sqlpassword);
										while(rspassword.next()) {
											Upassword = rspassword.getString(2);
										}
										//校验密码
										
										String Password=null;
							 			try {
							 					EncryptUtils encryptUtils = new EncryptUtils();
							 					String source =JTe4.getText();
							 					Password=encryptUtils.encryptToMD5(source);
										//解密
									
							 			}catch(Exception e1) {
							 				 e1.printStackTrace();
							 			}
							 			
							 			//如果比对成功
										if(Upassword.equals(Password)) {
											
											
											String HQ="活期存款",DQone="定期一年",DQtwo="定期两年",DQthree="定期三年",DQfive="定期五年",DQmonth="定期三个月",DQhalf="定期半年";
											String str=deposit.getSelectedItem().toString();
											serialnumber se=new serialnumber();
											//先找出账号余额 
											String sqlbalance="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JTe1.getText()+"'";
											ResultSet rsbalance = jdbcdq.slectData(sqlbalance);
											BigDecimal Ubalance=null,Money=null,balance=null;
											while(rsbalance.next()){
												Ubalance=rsbalance.getBigDecimal(8);
											}
											//转换存入金额为BigDecimal类型
											Double money=Double.parseDouble(JTe2.getText());
											Money=new BigDecimal(money);
											
											balance=Ubalance.add(Money);
											//测试活期计算
											//System.out.println("帐户本金"+Ubalance);
											//System.out.println("总额"+balance);
											//System.out.println("存入金额"+Money);
											if(str.equals(HQ))
											{
												//更新账户余额
												String sqlUbalance="UPDATE yhcxgl_User SET Ubalance='"+balance+"' WHERE Uacnum='"+JTe1.getText()+"'";
												int result2 =jdbcdq.excuteData(sqlUbalance);
												//更新流水号
												String Hnumber=se.StringGetnum();
												String sqlUnumber="UPDATE yhcxgl_User SET Unumber='"+Hnumber+"' WHERE Uacnum='"+JTe1.getText()+"'";
												int resultnumber =jdbcdq.excuteData(sqlUnumber);
												//更新存款类型
												String sqlUstyle="UPDATE yhcxgl_User SET Ustyle='1' WHERE Uacnum='"+JTe1.getText()+"'";
												int reUstyle =jdbcdq.excuteData(sqlUstyle);
												
												//System.out.println(result2);
												
												//活期利息
											    //插入记录到活期表
												
												String sql3="INSERT INTO yhcxgl_HQ VALUES('"+Hnumber+"','"+JTe1.getText()+"','"+JTe2.getText()+"','"+str+"','"+se.getStringDay()+"','"+balance+"')";
												int result = jdbcdq.excuteData(sql3);
												
												
												String PLUS="+"+JTe2.getText();
												String sqlHQMX="INSERT INTO yhcxgl_HQMX VALUES('"+se.StringGetnum()+"','"+JTe1.getText()+"','"+PLUS+"','"+str+"','"+se.getStringDay()+"','0','"+balance+"','"+Hnumber+"','"+str+"')";
												int resultHQMX = jdbcdq.excuteData(sqlHQMX);
												
												if((result==1)&&(1==resultHQMX)) {
													ShowMessage success=new ShowMessage();
													success.success("活期存款成功!");
													if(w==3) {
														
													}else {
														JTe1.setText(null);
													}
												
													JTe2.setText(null);
													JTe4.setText(null);
													JTe5.setText(null);
												}else {
													ShowMessage fail=new ShowMessage();
													fail.init("活期存款失败!");
												}
										
										
											}else {
												//计算利息
													BigDecimal interest=null,total=null;
													Bank computer=new Bank();
													String Dyear = null;
													String sqlrate="SELECT * FROM yhcxgl_LX WHERE Lproject='"+str+"'";
													ResultSet rsrate = jdbcdq.slectData(sqlrate);
													BigDecimal rate=null;
													while(rsrate.next()) {
														rate=rsrate.getBigDecimal(3);
													}
													//测试利率
													//System.out.println(rate);
												if(str.equals(DQone)) {
												
													
													BigDecimal a=new BigDecimal("1");
													interest=computer.computerInterest(a,rate,Money);
													Dyear="一年";
													total=interest.add(balance);
													//测试
												
												
													}else if(str.equals(DQtwo)) {
												
														BigDecimal a=new BigDecimal("2");
													
														interest=computer.computerInterest(a,rate,Money);
														total=interest.add(balance);
														Dyear="两年";
														//测试利息
													
													}else if(str.equals(DQthree)) {
												
														BigDecimal a=new BigDecimal("3");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="三年";
														total=interest.add(balance);
														//测试利息
													
													}else if(str.equals(DQfive)){
												
														BigDecimal a=new BigDecimal("5");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="五年";
														total=interest.add(balance);
													}else if(str.equals(DQmonth)) {
														BigDecimal a=new BigDecimal("0.3");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="三个月";
														total=interest.add(balance);
													}else if(str.equals(DQhalf)) {
														BigDecimal a=new BigDecimal("0.5");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="半年";
														total=interest.add(balance);
													}
													//System.out.println(interest);
													//更新账户余额
													String sqlDUbalance="UPDATE yhcxgl_User SET Ubalance='"+total+"' WHERE Uacnum='"+JTe1.getText()+"'";
													int resultD =jdbcdq.excuteData(sqlDUbalance);
													//更新流水号\
													String DQnumber=se.StringGetnum();
													String sqlDnumber="UPDATE yhcxgl_User SET Unumber='"+DQnumber+"' WHERE Uacnum='"+JTe1.getText()+"'";
													int resultnumber =jdbcdq.excuteData(sqlDnumber);
													
													//更新存款类型
													String sqlUstyle="UPDATE yhcxgl_User SET Ustyle='2' WHERE Uacnum='"+JTe1.getText()+"'";
													int reUstyle =jdbcdq.excuteData(sqlUstyle);
													
													//System.out.println(resultD);
													//插入定期表记录
													String strstyle=deposit.getSelectedItem().toString();
													String sqlDQ="INSERT INTO yhcxgl_DQ VALUES('"+DQnumber+"','"+JTe1.getText()+"','"+JTe2.getText()+"','"+se.getStringDay()+"','"+total+"','"+Dyear+"','"+interest+"','"+strstyle+"')";
													int resultDQ = jdbcdq.excuteData(sqlDQ);
													//插入定期明细表记录
													String PLUS="+"+JTe2.getText();
													String sqlDQMX="INSERT INTO yhcxgl_DQMX VALUES('"+se.StringGetnum()+"','"+JTe1.getText()+"','"+se.getStringDay()+"','"+PLUS+"','"+interest+"','"+total+"','"+Dyear+"','"+strstyle+"','"+DQnumber+"','"+str+"')";
													int resultDQMX = jdbcdq.excuteData(sqlDQMX);
													
													
													if((resultDQ==1&&(resultDQMX==1))) {
														ShowMessage success=new ShowMessage();
														success.success("定期存款成功!");
														if(w!=3) {
															JTe1.setText(null);
														}
														
														JTe2.setText(null);
														JTe4.setText(null);
														JTe5.setText(null);
													}else {
														ShowMessage fail=new ShowMessage();
															fail.init("定期存款失败!");
															JTe4.setText(null);
															JTe5.setText(null);
													}
											}
										}else {
											ShowMessage fail=new ShowMessage();
											fail.init("密码不正确!");
											JTe4.setText(null);
											JTe5.setText(null);
										}
									}else {
										ShowMessage fail=new ShowMessage();
										fail.initAcnum("账户:"+JTe1.getText(),"     已被冻结!");
										if(w!=3) {
											JTe1.setText(null);
										}
										JTe2.setText(null);
										JTe4.setText(null);
										JTe5.setText(null);
									}
									
								}
							  } catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								}
						
						}else {
							ShowMessage failNumber=new ShowMessage();
							failNumber.init("密码不一致,请重新输入");
							JTe4.setText(null);
							JTe5.setText(null);
						}
				}
				else {
					ShowMessage failNumber=new ShowMessage();
					failNumber.init("  	金额输入有误");
					JTe2.setText(null);
					JTe4.setText(null);
					JTe5.setText(null);
				}
			}
			   
		   });
		   //取消按钮
		   cancel=new JButton();
		   n.add(cancel);
		   ImageIcon IconU2 =new ImageIcon("src/images/QX.jpg");
		   cancel.setBorder(BorderP);
		   cancel.setIcon(IconU2);
		   cancel.setBounds(300,460,60,21);
		   cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JTe2.setText(null);
				JTe4.setText(null);
				JTe5.setText(null);
			}
			   
		   });
	   }
	   
	   
}
