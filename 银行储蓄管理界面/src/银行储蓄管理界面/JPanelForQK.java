package ���д���������;

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
		   
		   
		   JLabel JP1 = new JLabel("ȡ��ҵ��");
		   m.add(JP1);
		   JP1.setBounds(2,2,100,20);
		   JP1.setForeground(Color.BLUE);
		   
		 
		   JP1.setForeground(Color.BLUE);
		   JLabel JP2 = new JLabel("������дȡ���˻�");
		   m.add(JP2);
		   JP2.setBounds(40,40,250,30);
		   
		   JLabel JP3 = new JLabel("ȡ���˻�:");
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
		   JLabel JP4 = new JLabel("������дȡ���˻���Ϣ");
		   m.add(JP4);
		   JP4.setBounds(40,120,250,30);
		   
		   JLabel JP8 = new JLabel("ȡ���� :");
		   m.add(JP8);
		   JP8.setBounds(60,210,100,25);
		   
		   JFormattedTextField JT4=new JFormattedTextField();
		   m.add(JT4);
		   JT4.setBounds(140,210,200,25);
		   JT4.setBorder(Border);
		   
		   JLabel JP9 = new JLabel("���������˻�����:");
		   m.add(JP9);
		   JP9.setBounds(40,280,120,25);

		   JPasswordField JPa = new JPasswordField();
		   m.add(JPa);
		   JPa.setBounds(140,310,100,25);
		   JPa.setBorder(Border);
		   
		   JLabel JP10 = new JLabel("��������:");
		   m.add(JP10);
		   JP10.setBounds(60,310,100,25);
		   
		   JLabel JP11 = new JLabel("ȷ������:");
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
							Facnum.init("  	�Ƿ�ȡ���˻�");
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
						//У������
						String Password=null;
			 			try {
			 					EncryptUtils encryptUtils = new EncryptUtils();
			 					String source =JPa.getText();
			 					Password=encryptUtils.encryptToMD5(source);
						//����
			 					
			 					
					
			 			}catch(Exception e1) {
			 				 e1.printStackTrace();
			 			}
			 			// ���������Գɹ�
			 			if(Upassword.equals(Password)) {
			 				//��ѯ���˺����
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
								Show2.init("�����˻�����");
								JT4.setText(null);
								JPa.setText(null);
								JPa2.setText(null);
							}else {
								//�����˻�ȡ������
								String sql4="UPDATE yhcxgl_User SET Ubalance='"+balance+"' WHERE Uacnum='"+JT1.getText()+"'";
								int result4=jdbcdq.excuteData(sql4);
								//��ѯ�˻�����
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
										//���¶��ڴ�ȡ��¼
										//������
										serialnumber se=new serialnumber();
										//��ѯ����ˮ�� ���� 
										String Dyear=null;
										String sqlyear="SELECT * FROM yhcxgl_DQ WHERE Dnumber='"+number+"'";
										ResultSet rsryear = jdbcdq.slectData(sqlyear);
										while(rsryear.next()) {
											Dyear=rsryear.getString(6);
										}
										//�����׽��Ӹ���
										String PLUS="-"+JT4.getText();
									
										String sqlDQMX="INSERT INTO yhcxgl_DQMX VALUES('"+se.StringGetnum()+"','"+JT1.getText()+"','"+se.getStringDay()+"','"+PLUS+"','0','"+balance+"','"+Dyear+"','����ȡ��','"+number+"','����������ȡ��Ŀ')";
										int resultDQMX = jdbcdq.excuteData(sqlDQMX);
												if(1==resultDQMX) {
													ShowMessage fail=new ShowMessage();
													fail.success("ȡ��ɹ�");
													if(E==3) {
														
													}else {
														JT1.setText(null);
													}
													
													JT4.setText(null);
													JPa.setText(null);
													JPa2.setText(null);
												}else {
													ShowMessage fail=new ShowMessage();
													fail.init("ȡ��ʧ��!");
												}
										}
										else {
										//���Ƕ��ھ��ǻ���	
											serialnumber se=new serialnumber();
									
									
										//������Ϣ
										Bank computer=new Bank();
										BigDecimal interest=null,total=null;
										BigDecimal a=new BigDecimal("1");
										BigDecimal b=new BigDecimal("0.003");
										interest=computer.computerInterest(a,b,Money);
										total=interest.add(balance);
										//���»�����ϸ��
										String PLUS="-"+JT4.getText();
										String sqlHQMX="INSERT INTO yhcxgl_HQMX VALUES('"+se.StringGetnum()+"','"+JT1.getText()+"','"+PLUS+"','����ȡ��','"+se.getStringDay()+"','"+interest+"','"+total+"','"+number+"','������Ŀ')";
										int resultHQMX = jdbcdq.excuteData(sqlHQMX);
										//�����˻�
								
										if(1==resultHQMX) {
											ShowMessage fail=new ShowMessage();
											fail.success("ȡ��ɹ�");
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
											fail.init("ȡ��ʧ��");
										}
									}
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								//����Ƕ���
								
								
								
								
							}
							
			 			}else {
			 				ShowMessage fail=new ShowMessage();
							fail.init("������������!");
			 			}
						}else {
							ShowMessage fail=new ShowMessage();
							fail.initAcnum("�˻�:"+JT1.getText(),"    �ѱ�����!");
							if(E==3) {
								
							}else {
								JT1.setText(null);		
							}
								
							JT4.setText(null);
							JPa.setText(null);
							JPa2.setText(null);
						}
						//У������
						
						
					}
				}else {
					ShowMessage fail=new ShowMessage();
					fail.init("���벻һ��!");
				}
					
				}else {
					ShowMessage Facnum=new ShowMessage();
					Facnum.init("�����������!");
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
		   //ת��ȡ���¼���ť
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
