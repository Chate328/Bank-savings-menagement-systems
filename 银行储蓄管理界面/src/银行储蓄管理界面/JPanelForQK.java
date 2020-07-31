package 银行储蓄管理界面;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPanelForQK {
	JDBCDQ jdbcdq ;
	private static int W,E;
	public static String User_id;
	public TextBorderUtlis BorderT;
	JPanelForQK(int n,String str,int e){
		this.E=e;
		this.W=n;
		User_id=str;
		jdbcdq = new JDBCDQ(W);
		BorderT=new TextBorderUtlis(new Color(255,255,255),2,true);
	}
	 public void QK(JPanel m) {
		   
		   
		   JLabel JP1 = new JLabel("取款业务");
		   m.add(JP1);
		   JP1.setBounds(2,2,100,20);
		   JP1.setForeground(Color.BLUE);
		   
		 
		   JP1.setForeground(Color.BLUE);
		   JLabel JP2 = new JLabel("请您填写取款账户");
		   m.add(JP2);
		   JP2.setBounds(40,40,250,30);
		   
		   JLabel JP3 = new JLabel("取款账户:");
		   m.add(JP3);
		   JP3.setBounds(60,70,100,30);
		   
		   
		   JTextField JT1 = new JTextField();
		   m.add(JT1);
		   JT1.setBounds(140,70,200,25);
		   
		   TextBorderUtlis Border=new TextBorderUtlis(new Color(0,191,255),2,true);
		  
		  
		   
		   if(E==3) {
			   JT1.setText(User_id);
			  
			   JT1.setEditable(false);
			   JT1.setBackground(Color.white);
			   JT1.setBorder(BorderT);
		   }else {
			   JT1.setBorder(Border);
		   }
		   System.out.println(E);
		   JLabel JP4 = new JLabel("请您填写取款账户信息");
		   m.add(JP4);
		   JP4.setBounds(40,120,250,30);
		   
		   JLabel JP8 = new JLabel("取款金额 :");
		   m.add(JP8);
		   JP8.setBounds(60,210,100,25);
		   
		   JFormattedTextField JT4=new JFormattedTextField();
		   m.add(JT4);
		   JT4.setBounds(140,210,200,25);
		   JT4.setBorder(Border);
		   
		   JLabel JP9 = new JLabel("请您输入账户密码:");
		   m.add(JP9);
		   JP9.setBounds(40,280,120,25);

		   JPasswordField JPa = new JPasswordField();
		   m.add(JPa);
		   JPa.setBounds(140,310,100,25);
		   JPa.setBorder(Border);
		   
		   JLabel JP10 = new JLabel("输入密码:");
		   m.add(JP10);
		   JP10.setBounds(60,310,100,25);
		   
		   JLabel JP11 = new JLabel("确认密码:");
		   m.add(JP11);
		   JP11.setBounds(60,340,100,25);
		   
		   JPasswordField JPa2 = new JPasswordField();
		   m.add(JPa2);
		   JPa2.setBounds(140,340,100,25);
		   JPa2.setBorder(Border);
		   
		   JButton JBP1 = new JButton();
		   m.add(JBP1);
		   JBP1.setPreferredSize(new Dimension(60,22));
		   ImageIcon IconP =new ImageIcon("src/images/QR.jpg");
		   JBP1.setIcon(IconP);
		   TextBorderUtlis BorderP=new TextBorderUtlis(new Color(255,255,255),1,true);
		   JBP1.setBorder(BorderP);
		   JBP1.setBounds(140,450,60,22);
		   JBP1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Pattern J=new Pattern();
				Boolean i=J.isNumber(JT4.getText());
				if(i) {
						if(JPa2.getText().equals(JPa.getText())) {
					
					
					String sql="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
					ResultSet rs= jdbcdq.slectData(sql);
					Boolean flagQ=false;
					try {
						if(rs.next()) {
							flagQ=true;
						}else {
							ShowMessage Facnum=new ShowMessage();
							Facnum.init("  	非法取款账户");
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
					if(flagQ) {
						
						int UstateNumber = 0;
						String sqlNumber="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
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
					
						String sqlpassword="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
						ResultSet rspassword = jdbcdq.slectData(sqlpassword);
						try {
							while(rspassword.next()) {
								Upassword = rspassword.getString(2);
								
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//校验密码
						String Password=null;
			 			try {
			 					EncryptUtils encryptUtils = new EncryptUtils();
			 					String source =JPa.getText();
			 					Password=encryptUtils.encryptToMD5(source);
						//解密
			 					
			 					
					
			 			}catch(Exception e1) {
			 				 e1.printStackTrace();
			 			}
			 			// 如果密码配对成功
			 			if(Upassword.equals(Password)) {
			 				//查询该账号余额
			 				String sqlre="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
							ResultSet rsre = jdbcdq.slectData(sqlre);
							BigDecimal Ubalance = null,balance=null;

							try {
								while(rsre.next()) {
									Ubalance = rsre.getBigDecimal(8);
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Double money=Double.parseDouble(JT4.getText());
							BigDecimal Money=new BigDecimal(money);
							balance=Ubalance.subtract(Money);
							if(-1==Ubalance.compareTo(Money)) {
								ShowMessage Show2=new ShowMessage();
								Show2.init("您的账户余额不足");
								JT4.setText(null);
								JPa.setText(null);
								JPa2.setText(null);
							}else {
								//更新账户取款后余额
								String sql4="UPDATE yhcxgl_User SET Ubalance='"+balance+"' WHERE Uacnum='"+JT1.getText()+"'";
								int result4=jdbcdq.excuteData(sql4);
								//查询账户类型
								String sqlrS="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
								ResultSet rsrS = jdbcdq.slectData(sqlre);
								String number=null;
								int style = 0;
								try {
									while(rsrS.next()) {
										style = rsrS.getInt(10);
										number=rsrS.getString(11);
									}
							    
								
									
										
										if(style==2) 
										{
										//更新定期存取记录
										//待测试
										serialnumber se=new serialnumber();
										//查询该流水号 年限 
										String Dyear=null;
										String sqlyear="SELECT * FROM yhcxgl_DQ WHERE Dnumber='"+number+"'";
										ResultSet rsryear = jdbcdq.slectData(sqlyear);
										while(rsryear.next()) {
											Dyear=rsryear.getString(6);
										}
										//给交易金额加负号
										String PLUS="-"+JT4.getText();
									
										String sqlDQMX="INSERT INTO yhcxgl_DQMX VALUES('"+se.StringGetnum()+"','"+JT1.getText()+"','"+se.getStringDay()+"','"+PLUS+"','0','"+balance+"','"+Dyear+"','定期取款','"+number+"','定期整存整取项目')";
										int resultDQMX = jdbcdq.excuteData(sqlDQMX);
												if(1==resultDQMX) {
													ShowMessage fail=new ShowMessage();
													fail.success("取款成功");
													if(E==3) {
														
													}else {
														JT1.setText(null);
													}
													
													JT4.setText(null);
													JPa.setText(null);
													JPa2.setText(null);
												}else {
													ShowMessage fail=new ShowMessage();
													fail.init("取款失败!");
												}
										}
										else {
										//不是定期就是活期	
											serialnumber se=new serialnumber();
									
									
										//计算利息
										Bank computer=new Bank();
										BigDecimal interest=null,total=null;
										BigDecimal a=new BigDecimal("1");
										BigDecimal b=new BigDecimal("0.003");
										interest=computer.computerInterest(a,b,Money);
										total=interest.add(balance);
										//更新活期明细表
										String PLUS="-"+JT4.getText();
										String sqlHQMX="INSERT INTO yhcxgl_HQMX VALUES('"+se.StringGetnum()+"','"+JT1.getText()+"','"+PLUS+"','活期取款','"+se.getStringDay()+"','"+interest+"','"+total+"','"+number+"','活期项目')";
										int resultHQMX = jdbcdq.excuteData(sqlHQMX);
										//更新账户
								
										if(1==resultHQMX) {
											ShowMessage fail=new ShowMessage();
											fail.success("取款成功");
											if(E==3) {
													
											}else {
												JT1.setText(null);
											}
													
											JT4.setText(null);
											JPa.setText(null);
											JPa2.setText(null);
										}
										else {
											ShowMessage fail=new ShowMessage();
											fail.init("取款失败");
										}
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								//如果是定期
								
								
								
								
							}
							
			 			}else {
			 				ShowMessage fail=new ShowMessage();
							fail.init("密码输入有误!");
			 			}
						}else {
							ShowMessage fail=new ShowMessage();
							fail.initAcnum("账户:"+JT1.getText(),"    已被冻结!");
							if(E==3) {
								
							}else {
								JT1.setText(null);		
							}
								
							JT4.setText(null);
							JPa.setText(null);
							JPa2.setText(null);
						}
						//校验密码
						
						
					}
				}else {
					ShowMessage fail=new ShowMessage();
					fail.init("密码不一致!");
				}
					
				}else {
					ShowMessage Facnum=new ShowMessage();
					Facnum.init("金额输入有误!");
				}
				
			
			}
			   
		   });
		   
		   JButton JBP2 = new JButton();
		   m.add(JBP2);
		   JBP2.setPreferredSize(new Dimension(60,22));
		   ImageIcon IconJ=new ImageIcon("src/images/QX.jpg");
		   JBP2.setIcon(IconJ);
		   TextBorderUtlis BorderJ1=new TextBorderUtlis(new Color(255,255,255),1,true);
		   JBP2.setBorder(BorderJ1);
		   JBP2.setBounds(280,450,60,22);
		   //转账取消事件按钮
		   JBP2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JT1.setText(null);
				
				JT4.setText(null);
				JPa.setText(null);
				JPa2.setText(null);
			}
			   
		   });
	   }
}
