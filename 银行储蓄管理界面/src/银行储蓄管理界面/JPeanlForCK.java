package ���д���������;

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
		   JLb1=new JLabel("���ҵ��");
		   JLb1.setForeground(Color.BLUE);
		   JLb1.setBounds(0,0,100,25);
		   n.add(JLb1);
		   
		   JLb2=new JLabel("������д����˻�:");
		   JLb2.setBounds(40,40,120,25);
		   n.add(JLb2);
		   
		   JLb3=new JLabel("����˻� :");
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
		   
		   JLb2=new JLabel("������д�����Ϣ :");
		   JLb2.setBounds(40,100,120,25);
		   n.add(JLb2);
		   
		   JLb6=new JLabel("������ :");
		   JLb6.setBounds(60,140,100,25);
		   n.add(JLb6);
		   
		   JTe2=new JTextField();
		   JTe2.setBorder(Border);
		   n.add(JTe2);
		   JTe2.setBounds(150,140,200,25);
		   
		   
		   JLb8=new JLabel("�������:");
		   JLb8.setBounds(60,250,100,25);
		   n.add(JLb8);
		   
		   JComboBox<String> deposit=new JComboBox<String>();
			deposit.addItem("���ڴ��");
			deposit.addItem("����������");
			deposit.addItem("���ڰ���");
			deposit.addItem("����һ��");
			deposit.addItem("��������");
			deposit.addItem("��������");
			deposit.addItem("��������");
			deposit.setBorder(Border);
			deposit.setBackground(new Color(255,255,255));
			deposit.setBounds(150, 250, 200, 25);
			n.add(deposit);
		   
		   //�������� 
		   JLb5=new JLabel("������������:");
		   JLb5.setBounds(60,320,100,25);
		   n.add(JLb5);
		   //���������
		   JTe4=new JPasswordField();
		   JTe4.setBorder(Border);
		   n.add(JTe4);
		   JTe4.setBounds(150,320,100,25);
		   //ȷ������
		   JLb9=new JLabel("ȷ������:");
		   JLb9.setBounds(60,370,100,25);
		   n.add(JLb9);
		   //ȷ�������
		   JTe5=new JPasswordField();
		   JTe5.setBorder(Border);
		   n.add(JTe5);
		   JTe5.setBounds(150,370,100,25);
		   
		   JLb7=new JLabel("����ѡ��������:");
		   JLb7.setBounds(40,190,120,25);
		   n.add(JLb7);
		   
		   
		   
		   // ȷ����ť
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
				if(i) {//��֤�Ƿ����
					if(JTe4.getText().equals(JTe5.getText())) 
					{//��֤����
						
						//��֤�Ƿ��ǷǷ�����˻�
					
						String sql="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JTe1.getText()+"'";
						ResultSet rs = jdbcdq.slectData(sql);
						Boolean flag=false;
						//��ⷵ��ֵ�Ƿ�Ϊ��
						try {
								if(rs.next())
								{
									flag=true;
								}else {
									ShowMessage Facnum=new ShowMessage();
									Facnum.init("  	�Ƿ��˻�");
								}
							//����ǺϷ��˻�����һ��
								
								
								if(flag) {
									//У��MD5�㷨����
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
										//У������
										
										String Password=null;
							 			try {
							 					EncryptUtils encryptUtils = new EncryptUtils();
							 					String source =JTe4.getText();
							 					Password=encryptUtils.encryptToMD5(source);
										//����
									
							 			}catch(Exception e1) {
							 				 e1.printStackTrace();
							 			}
							 			
							 			//����ȶԳɹ�
										if(Upassword.equals(Password)) {
											
											
											String HQ="���ڴ��",DQone="����һ��",DQtwo="��������",DQthree="��������",DQfive="��������",DQmonth="����������",DQhalf="���ڰ���";
											String str=deposit.getSelectedItem().toString();
											serialnumber se=new serialnumber();
											//���ҳ��˺���� 
											String sqlbalance="SELECT * FROM yhcxgl_User WHERE Uacnum='"+JTe1.getText()+"'";
											ResultSet rsbalance = jdbcdq.slectData(sqlbalance);
											BigDecimal Ubalance=null,Money=null,balance=null;
											while(rsbalance.next()){
												Ubalance=rsbalance.getBigDecimal(8);
											}
											//ת��������ΪBigDecimal����
											Double money=Double.parseDouble(JTe2.getText());
											Money=new BigDecimal(money);
											
											balance=Ubalance.add(Money);
											//���Ի��ڼ���
											//System.out.println("�ʻ�����"+Ubalance);
											//System.out.println("�ܶ�"+balance);
											//System.out.println("������"+Money);
											if(str.equals(HQ))
											{
												//�����˻����
												String sqlUbalance="UPDATE yhcxgl_User SET Ubalance='"+balance+"' WHERE Uacnum='"+JTe1.getText()+"'";
												int result2 =jdbcdq.excuteData(sqlUbalance);
												//������ˮ��
												String Hnumber=se.StringGetnum();
												String sqlUnumber="UPDATE yhcxgl_User SET Unumber='"+Hnumber+"' WHERE Uacnum='"+JTe1.getText()+"'";
												int resultnumber =jdbcdq.excuteData(sqlUnumber);
												//���´������
												String sqlUstyle="UPDATE yhcxgl_User SET Ustyle='1' WHERE Uacnum='"+JTe1.getText()+"'";
												int reUstyle =jdbcdq.excuteData(sqlUstyle);
												
												//System.out.println(result2);
												
												//������Ϣ
											    //�����¼�����ڱ�
												
												String sql3="INSERT INTO yhcxgl_HQ VALUES('"+Hnumber+"','"+JTe1.getText()+"','"+JTe2.getText()+"','"+str+"','"+se.getStringDay()+"','"+balance+"')";
												int result = jdbcdq.excuteData(sql3);
												
												
												String PLUS="+"+JTe2.getText();
												String sqlHQMX="INSERT INTO yhcxgl_HQMX VALUES('"+se.StringGetnum()+"','"+JTe1.getText()+"','"+PLUS+"','"+str+"','"+se.getStringDay()+"','0','"+balance+"','"+Hnumber+"','"+str+"')";
												int resultHQMX = jdbcdq.excuteData(sqlHQMX);
												
												if((result==1)&&(1==resultHQMX)) {
													ShowMessage success=new ShowMessage();
													success.success("���ڴ��ɹ�!");
													if(w==3) {
														
													}else {
														JTe1.setText(null);
													}
												
													JTe2.setText(null);
													JTe4.setText(null);
													JTe5.setText(null);
												}else {
													ShowMessage fail=new ShowMessage();
													fail.init("���ڴ��ʧ��!");
												}
										
										
											}else {
												//������Ϣ
													BigDecimal interest=null,total=null;
													Bank computer=new Bank();
													String Dyear = null;
													String sqlrate="SELECT * FROM yhcxgl_LX WHERE Lproject='"+str+"'";
													ResultSet rsrate = jdbcdq.slectData(sqlrate);
													BigDecimal rate=null;
													while(rsrate.next()) {
														rate=rsrate.getBigDecimal(3);
													}
													//��������
													//System.out.println(rate);
												if(str.equals(DQone)) {
												
													
													BigDecimal a=new BigDecimal("1");
													interest=computer.computerInterest(a,rate,Money);
													Dyear="һ��";
													total=interest.add(balance);
													//����
												
												
													}else if(str.equals(DQtwo)) {
												
														BigDecimal a=new BigDecimal("2");
													
														interest=computer.computerInterest(a,rate,Money);
														total=interest.add(balance);
														Dyear="����";
														//������Ϣ
													
													}else if(str.equals(DQthree)) {
												
														BigDecimal a=new BigDecimal("3");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="����";
														total=interest.add(balance);
														//������Ϣ
													
													}else if(str.equals(DQfive)){
												
														BigDecimal a=new BigDecimal("5");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="����";
														total=interest.add(balance);
													}else if(str.equals(DQmonth)) {
														BigDecimal a=new BigDecimal("0.3");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="������";
														total=interest.add(balance);
													}else if(str.equals(DQhalf)) {
														BigDecimal a=new BigDecimal("0.5");
														interest=computer.computerInterest(a,rate,Money);
														Dyear="����";
														total=interest.add(balance);
													}
													//System.out.println(interest);
													//�����˻����
													String sqlDUbalance="UPDATE yhcxgl_User SET Ubalance='"+total+"' WHERE Uacnum='"+JTe1.getText()+"'";
													int resultD =jdbcdq.excuteData(sqlDUbalance);
													//������ˮ��\
													String DQnumber=se.StringGetnum();
													String sqlDnumber="UPDATE yhcxgl_User SET Unumber='"+DQnumber+"' WHERE Uacnum='"+JTe1.getText()+"'";
													int resultnumber =jdbcdq.excuteData(sqlDnumber);
													
													//���´������
													String sqlUstyle="UPDATE yhcxgl_User SET Ustyle='2' WHERE Uacnum='"+JTe1.getText()+"'";
													int reUstyle =jdbcdq.excuteData(sqlUstyle);
													
													//System.out.println(resultD);
													//���붨�ڱ��¼
													String strstyle=deposit.getSelectedItem().toString();
													String sqlDQ="INSERT INTO yhcxgl_DQ VALUES('"+DQnumber+"','"+JTe1.getText()+"','"+JTe2.getText()+"','"+se.getStringDay()+"','"+total+"','"+Dyear+"','"+interest+"','"+strstyle+"')";
													int resultDQ = jdbcdq.excuteData(sqlDQ);
													//���붨����ϸ���¼
													String PLUS="+"+JTe2.getText();
													String sqlDQMX="INSERT INTO yhcxgl_DQMX VALUES('"+se.StringGetnum()+"','"+JTe1.getText()+"','"+se.getStringDay()+"','"+PLUS+"','"+interest+"','"+total+"','"+Dyear+"','"+strstyle+"','"+DQnumber+"','"+str+"')";
													int resultDQMX = jdbcdq.excuteData(sqlDQMX);
													
													
													if((resultDQ==1&&(resultDQMX==1))) {
														ShowMessage success=new ShowMessage();
														success.success("���ڴ��ɹ�!");
														if(w!=3) {
															JTe1.setText(null);
														}
														
														JTe2.setText(null);
														JTe4.setText(null);
														JTe5.setText(null);
													}else {
														ShowMessage fail=new ShowMessage();
															fail.init("���ڴ��ʧ��!");
															JTe4.setText(null);
															JTe5.setText(null);
													}
											}
										}else {
											ShowMessage fail=new ShowMessage();
											fail.init("���벻��ȷ!");
											JTe4.setText(null);
											JTe5.setText(null);
										}
									}else {
										ShowMessage fail=new ShowMessage();
										fail.initAcnum("�˻�:"+JTe1.getText(),"     �ѱ�����!");
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
							failNumber.init("���벻һ��,����������");
							JTe4.setText(null);
							JTe5.setText(null);
						}
				}
				else {
					ShowMessage failNumber=new ShowMessage();
					failNumber.init("  	�����������");
					JTe2.setText(null);
					JTe4.setText(null);
					JTe5.setText(null);
				}
			}
			   
		   });
		   //ȡ����ť
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
