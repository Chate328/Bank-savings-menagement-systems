package ���д���������;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JPeanlForZH {
	//����J5���//ת�����
	JDBCDQ jdbcdq;
	public static int w;
	public static String User_id;
	private String name;
	JPeanlForZH(int n,String str,int w){
		this.w=w;
		User_id=str;
		jdbcdq = new JDBCDQ(n);
	}
	   void setJ5Panel(JPanel n) {
		   JLabel JP1,JP2,JP3,JP4,JP5,JP6,JP7,JP8,JP9,JP10,JP11;
		   JTextField JT1,JT2,JT3,JT5,JT6,JT7;
		   JPasswordField JPa,JPa2;
		   JButton JBP1,JBP2;
		   TextBorderUtlis BorderP=new TextBorderUtlis(new Color(255,255,255),1,true);
		   TextBorderUtlis Border=new TextBorderUtlis(new Color(0,191,255),2,true);
		   JP1=new JLabel("����ת�˻��");
		   n.add(JP1);
		   JP1.setBounds(2,2,100,20);
		   JP1.setForeground(Color.BLUE);
		   JP2=new JLabel("����ѡ�񸶿��˻�");
		   n.add(JP2);
		   JP2.setBounds(40,40,250,30);
		   JP3=new JLabel("�����˻�:");
		   n.add(JP3);
		   JP3.setBounds(60,70,100,30);
		   JT1=new JTextField();
		   n.add(JT1);
		   JT1.setBounds(140,70,200,25);
		   if(w==3) {
			   JT1.setText(User_id);
			   JT1.setBorder(BorderP);
			   JT1.setBackground(Color.white);
			   JT1.setEditable(false);
		   }else {
			   JT1.setBorder(Border);
		   }
		   
		  
			
			JP4=new JLabel("������д�տ��˻���Ϣ");
			n.add(JP4);
			JP4.setBounds(40,100,250,30);
			JP5=new JLabel("�տ����˻� :");
			n.add(JP5);
			JP5.setBounds(60,140,200,30);
			
			JLabel Jpayee = new JLabel("�տ���:");
			n.add(Jpayee);
			Jpayee.setBounds(60, 190, 70, 25);
			
			JT2=new JTextField();
			n.add(JT2);
			JT2.setBounds(140,140,200,25);
			JT2.setBorder(Border);
			
			
			
			JT2.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					if(w!=3) {
						
						if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
							JDBCDQ jdbc=new JDBCDQ(2);
							String sql="SELECT * FROM yhcxgl_User Where Uacnum='"+JT2.getText()+"'";
							ResultSet  rs=jdbc.slectData(sql);
							
							try {
								while(rs.next()) {
									 name=rs.getString(3);
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							JTextField payeename=new JTextField();
							n.add(payeename);
							payeename.setBounds(140, 190, 90, 25);
							payeename.setBorder(BorderP);
							payeename.setForeground(new Color(0,191,255));
							payeename.setText(name);
						}
						}
						
				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
			if(w==3) {
				JTextField Jpayeename=new JTextField();
				n.add(Jpayeename);
				Jpayeename.setBounds(140,190,90,25);
				Jpayeename.setBorder(Border);
			}
			
			JP7=new JLabel("������дת�˽������Ϣ");
			n.add(JP7);
			JP7.setBounds(40,230,200,25);
			JP8=new JLabel("ת�˽�� :");
			n.add(JP8);
			JP8.setBounds(60,260,100,25);
			
			JFormattedTextField JT4=new JFormattedTextField();
			n.add(JT4);
			JT4.setBounds(140,260,200,25);
			JT4.setBorder(Border);
			
			JP8=new JLabel("�տ����:");
			n.add(JP8);
			JP8.setBounds(60,290,100,25);
			
			TextBorderUtlis BorderJ=new TextBorderUtlis(new Color(0,191,255),2,true);
			JComboBox<String> JC=new JComboBox<String>();
			JC.addItem("��Ժ����");
			/*JC.addItem("��ͨ����");
			JC.addItem("�й�ũҵ����");
			JC.addItem("��������");
			JC.addItem("�㶫ũ��������");
			JC.addItem("�㷢����");
			JC.addItem("�ַ�����");
			JC.addItem("������������");*/
			JC.setBorder(BorderJ);
			JC.setBackground(new Color(255,255,255));
			JC.setBounds(140, 290, 200, 25);
			n.add(JC);
			
			JP9=new JLabel("���������˻�����:");
			n.add(JP9);
			JP9.setBounds(40,320,120,25);

			 JBP1=new JButton();
			   n.add(JBP1);
			   JBP1.setPreferredSize(new Dimension(60,22));
			   ImageIcon IconP =new ImageIcon("src/images/QR.jpg");
			   JBP1.setIcon(IconP);
			  
			   JBP1.setBorder(BorderP);
			   JBP1.setBounds(140,450,60,22);
			   //ת�����ȷ�ϰ�ť�¼�
			  
			   JPa =new JPasswordField();
			   n.add(JPa);
			   JPa.setBounds(140,350,100,25);
			   JPa.setBorder(Border);
			   
			   JP10=new JLabel("��������:");
			   n.add(JP10);
			   JP10.setBounds(60,350,100,25);
			   
			   JP11 =new JLabel("ȷ������:");
			   n.add(JP11);
			   JP11.setBounds(60,380,100,25);
			   
			   JPa2=new JPasswordField();
			   n.add(JPa2);
			   JPa2.setBounds(140,380,100,25);
			   JPa2.setBorder(Border);
			   /*
			    * 
			    * ���ӹ��� �����տ��� ����
			    */
			   JBP1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
						JT1.getText();
						JT2.getText();
						if(JT1.getText().equals(JT2.getText())) {
							ShowMessage fail=new ShowMessage();
							fail.init("�˺���д����!");
						}
						else {
								Pattern J=new Pattern();
								Boolean i=J.isNumber(JT4.getText());
								if(i) 
								{
							
									if(JPa.getText().equals(JPa2.getText())) 
											{
													
										
											try {
													
												
													String sql1="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
													ResultSet rs = jdbcdq.slectData(sql1);
													Boolean flag=false,flag2=false;
													//��ⷵ��ֵ�Ƿ�Ϊ��
													if(rs.next()) {
														flag=true;
													}else {
														ShowMessage Facnum=new ShowMessage();
														Facnum.init("  	�Ƿ������˻�");
													}
													String sqlZ="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT2.getText()+"'";
													ResultSet reZ=jdbcdq.slectData(sqlZ);
													if(reZ.next()) {
														flag2=true;
													}else {
														ShowMessage Zacnum=new ShowMessage();
														Zacnum.init("  	�Ƿ��տ��˻�");
													}
													//����ֵ��Ϊ��
													if(flag&&flag2) 
													{	
														
														int UstateNumber = 0;
														String sqlNumber="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
														ResultSet rsNumber = jdbcdq.slectData(sqlNumber);
														try {
															while(rsNumber.next()) {
																UstateNumber=rsNumber.getInt(14);
															}
														} catch (SQLException e1) {
															// TODO Auto-generated catch block
															e1.printStackTrace();
														}
														if(UstateNumber==1) {
															String Upassword=null;
															String sqlpassword="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
															ResultSet rspassword = jdbcdq.slectData(sqlpassword);
															while(rspassword.next()) {
																Upassword = rspassword.getString(2);
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
												 		
															if(Password.equals(Upassword)) {
																
																//��ѯ���������
																String sqlre="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT1.getText()+"'";
																ResultSet rsre = jdbcdq.slectData(sqlre);
																BigDecimal Ubalance = null,balance=null;
							    	
																while(rsre.next()) {
																	Ubalance = rsre.getBigDecimal(8);
																}
																Double money=Double.parseDouble(JT4.getText());
																BigDecimal Money=new BigDecimal(money);
																balance=Ubalance.subtract(Money);
																if(-1==Ubalance.compareTo(Money)) {
																	ShowMessage Show2=new ShowMessage();
																	Show2.init("�����˻�����");
																}else {
																	//��ѯ�տ��˺����
																	String sqlr="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JT2.getText()+"'";
																	ResultSet rsr=jdbcdq.slectData(sqlr);
																	String Zname = null;
																	BigDecimal Zbalance=null,Zmoney=null;
																	while(rsr.next()) {
																		Zbalance=rsr.getBigDecimal(8);
																		Zname=rsr.getString(3);
																	}
																	Zmoney=Zbalance.add(Money);
																	//����ת�˷����˻����
																	String sql2="UPDATE yhcxgl_User SET Ubalance='"+balance+"' WHERE Uacnum='"+JT1.getText()+"'";
																	int result2 =jdbcdq.excuteData(sql2);
																	//�����տ�˻����
																	String sql4="UPDATE yhcxgl_User SET Ubalance='"+Zmoney+"' WHERE Uacnum='"+JT2.getText()+"'";
																	int result4=jdbcdq.excuteData(sql4);
																	serialnumber se=new serialnumber();
																	//����ת�ʱ�
																	String sql3="INSERT INTO yhcxgl_ZH VALUES('"+se.StringGetnum()+"','"+JT1.getText()+"','"+JT2.getText()+"','"+se.getStringDay()+"','"+JT4.getText()+"','"+JC.getSelectedItem().toString()+"','"+Zname+"')";
																	int result = jdbcdq.excuteData(sql3);
																	if(1==result) {
																		ShowMessage success=new ShowMessage();
																		success.success("        ת�˳ɹ�!");
																		if(w!=3) {
																			JT1.setText(null);
																		}
																		JT2.setText(null);
																		JT4.setText(null);
																		JPa.setText(null);
																		JPa2.setText(null);
																	}else {
																		ShowMessage fail=new ShowMessage();
																		fail.init("        ת��ʧ��");
																	}
																}
							   
																}
																else {
																	ShowMessage fail=new ShowMessage();
																	fail.init("���벻��ȷ!");
																	JPa.setText(null);
																	JPa2.setText(null);
																}
									
															
														}else {
															ShowMessage fail=new ShowMessage();
															fail.init("���˻�������!");
															JT1.setText(null);
															JT2.setText(null);
															JT4.setText(null);
															JPa.setText(null);
															JPa2.setText(null);
														}
														
													}
						    
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
						
											}else {
												ShowMessage Show=new ShowMessage();
												Show.init("���벻һ��,����������");
												JPa.setText(null);
												JPa2.setText(null);
											}
						
								}
								else
								{
									ShowMessage fail =new ShowMessage();
									fail.init("ת�˽������");
									JT4.setText(null);
									JPa.setText(null);
									JPa2.setText(null);
								}
							
						}			
					}
							
						
						
					} );
				   
				   
			   JBP2=new JButton();
			   n.add(JBP2);
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
					JT2.setText(null);
					JT4.setText(null);
					JPa.setText(null);
					JPa2.setText(null);
				}
				   
			   });
	   }
}
