package ���д���������;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JPeanlForOpen {
	JLabel K,J1,J2,J3,J4,J5,J6,birthday,style,mobile;
	JTextField Uacnum2,Uname2,mobileNumber;
	JComboBox J,month,day,ID;
	JRadioButton JRB,JRB2;
	ButtonGroup bg;
	JButton submit,reset;
	TextBorderUtlis BorderF,Border,BorderB;
	ImageIcon IconP ,IconJ;
	String idStyle,sexStyle,yearSelect,monthSelect,daySelect,birthdaySelect,JRagioSex;
	JDBCDQ jdbc;
	JPeanlForOpen(int n){
		jdbc=new JDBCDQ(n);
		  K=new JLabel("����ҵ��");
		  J1=new JLabel("������д������Ϣ");
		  Uacnum2 = new JTextField();
		  J2=new JLabel("����д���֤����");
		  Uname2= new JTextField();
		  mobileNumber=new JTextField();
		  J3=new JLabel("����");
		  style=new JLabel("֤������");
		  mobile=new JLabel("��ϵ�绰");
		  JRB=new JRadioButton("��");
		  J=new JComboBox();
		  day=new JComboBox();
		  month=new JComboBox();
		  ID=new JComboBox();
		  J4=new JLabel("�Ա�");
		  J5=new JLabel("��");
		  J6=new JLabel("Ů");
		  JRB2=new JRadioButton("Ů");
		  bg=new ButtonGroup();
		  birthday=new JLabel("��������");
		  submit=new JButton();
		  reset=new JButton();
		  BorderF=new TextBorderUtlis(new Color(0,191,255),2,true);
		  Border=new TextBorderUtlis(new Color(0,191,255),1,true);
		  BorderB=new TextBorderUtlis(new Color(255,255,255),2,true);
		  IconJ=new ImageIcon("src/images/QX.jpg");
		  IconP =new ImageIcon("src/images/QR.jpg");
		  ID.addItem("�������֤");
		  ID.addItem("����ر��������������֤");
		  ID.addItem("�����ر��������������֤");
		  ID.addItem("̨��������֤");
		  ID.addItem("����������֤");
		  J.addItem("1970");
		  J.addItem("1971");
		  J.addItem("1972");
		  J.addItem("1973");
		  J.addItem("1974");
		  J.addItem("1975");
		  J.addItem("1976");
		  J.addItem("1977");
		  J.addItem("1978");
		  J.addItem("1979");
		  J.addItem("1980");
		  J.addItem("1980");
		  J.addItem("1981");
		  J.addItem("1982");
		  J.addItem("1983");
		  J.addItem("1984");
		  J.addItem("1985");
		  J.addItem("1986");
		  J.addItem("1987");
		  J.addItem("1988");
		  J.addItem("1989");
		  J.addItem("1990");
		  J.addItem("1991");
		  J.addItem("1992");
		  J.addItem("1993");
		  J.addItem("1994");
		  J.addItem("1995");
		  J.addItem("1996");
		  J.addItem("1997");
		  J.addItem("1998");
		  J.addItem("1999");
		  J.addItem("2000");
		  
		  month.addItem("01");
		  month.addItem("02");
		  month.addItem("03");
		  month.addItem("04");
		  month.addItem("05");
		  month.addItem("06");
		  month.addItem("07");
		  month.addItem("08");
		  month.addItem("09");
		  month.addItem("10");
		  month.addItem("11");
		  month.addItem("12");
		  
		  day.addItem("01");
		  day.addItem("02");
		  day.addItem("02");
		  day.addItem("04");
		  day.addItem("05");
		  day.addItem("06");
		  day.addItem("07");
		  day.addItem("08");
		  day.addItem("09");
		  day.addItem("10");
		  day.addItem("11");
		  day.addItem("12");
		  day.addItem("13");
		  day.addItem("14");
		  day.addItem("15");
		  day.addItem("16");
		  day.addItem("17");
		  day.addItem("18");
		  day.addItem("19");
		  day.addItem("20");
		  day.addItem("21");
		  day.addItem("22");
		  day.addItem("23");
		  day.addItem("24");
		  day.addItem("25");
		  day.addItem("26");
		  day.addItem("27");
		  day.addItem("28");
		  day.addItem("29");
		  day.addItem("30");
		  day.addItem("31");
		  
	}
	
  public void KH(JPanel n) {
	 
	  n.add(K);
	  K.setBounds(0,5,100,25);
	  K.setForeground(Color.blue);
	  
	  n.add(J1);
	  J1.setBounds(40, 30, 120, 25);
	  n.add(J2);
	  J2.setBounds(60, 140, 120, 25);
	  
	  
	 
	  n.add(J3);
	  J3.setBounds(60,200, 50,25);
	  Uacnum2.setBorder(BorderF);
	  n.add(Uacnum2);
	  Uacnum2.setBounds(180,140, 200, 25);
	  
	  n.add(style);
	  style.setBounds(60, 80,60,25);
	  n.add(ID);
	  ID.setBounds(180, 80, 200, 25);
	  ID.setBackground(Color.white);
	  ID.setBorder(Border);
	 
	
	  Uname2.setBorder(BorderF);
	  n.add(Uname2);
	  Uname2.setBounds(180,200, 60, 25);
	  
	  //��
	  n.add(J5);
	  J5.setBounds(180, 260, 20, 25);
	  //�е�ѡ
	  n.add(JRB);
	  JRB.setBounds(230, 260, 20, 20);
	  JRB.setBackground(Color.white);
	  JRB.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JRagioSex="��";
		}
		  
	  });
	  
	  n.add(J4);
	  J4.setBounds(60, 260, 50, 25);
	
	  //Ů
	  n.add(J6);
	  J6.setBounds(270,262,20,20);
	  //Ů��ѡ
	  n.add(JRB2);
	  JRB2.setBounds(310, 260, 20, 20);
	  JRB2.setBackground(Color.white);
	  JRB2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JRagioSex="Ů";
		}
		  
	  });
	  
	  bg.add(JRB2);
	  bg.add(JRB);
	  
	  n.add(birthday);
	  birthday.setBounds(60, 310, 100, 25);
	   
	  n.add(J);
	  J.setBounds(180, 310, 60, 20);
	  J.setBackground(Color.white);
	  J.setBorder(Border);
	 
	  
	  n.add(month);
	  month.setBounds(260,310, 45, 20);
	  month.setBackground(Color.white);
	  month.setBorder(Border);
	  
	  n.add(day);
	  day.setBounds(330, 310, 45, 20);
	  day.setBorder(Border);
	  day.setBackground(Color.white);
	 
	  n.add(mobile);
	  mobile.setBounds(60, 380, 70, 25);
	  
	  n.add(mobileNumber);
	  mobileNumber.setBounds(180, 380, 100, 25);
	  mobileNumber.setBorder(BorderF);
	  
	  //�ϳɳ�������
	 
	  //�ύ
	  n.add(submit);
	  submit.setBounds(180, 460, 60, 25);
	  submit.setBorder(BorderB);
	  submit.setIcon(IconP);
	  submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//������ɿ���
				
				if((mobileNumber.getText().trim().equals(""))||(Uacnum2.getText().trim().equals(""))||(Uname2.getText().trim().equals(""))||JRagioSex.equals("")) {
					ShowMessage fail1=new ShowMessage();
					fail1.init("�������������Ϣ");
				}else{
						
									Pattern Pa=new Pattern();
									//��֤���֤
									if(Pa.isIDNumber(Uacnum2.getText())) {
										
										//��֤�ֻ���
										
										RegexUtils Mobile=new RegexUtils();
										if(Mobile.validateMobilePhone(mobileNumber.getText())) {
									    RandomCreditCardNumberGenerator Random=new RandomCreditCardNumberGenerator();
										String BankNumber=Random.get_Bank_account();
										serialnumber seK=new serialnumber();
											//MD5 �㷨���ܳ�ʼ������  ���������
										EncryptUtils encryptUtils = new EncryptUtils();
										String source = "123456";
										String Password=encryptUtils.encryptToMD5(source);
										//����
										
										//���ϼ��
										//System.out.println(Password);
										//System.out.println(BankNumber);
										//System.out.println(seK.getStringDay());
										//System.out.println(Userld2.getText().trim());
										//��������
										birthdaySelect=J.getSelectedItem().toString()+month.getSelectedItem().toString()+day.getSelectedItem();
										idStyle=ID.getSelectedItem().toString();  
										
										
										
										String sqlZH="INSERT INTO yhcxgl_User VALUES('"+BankNumber+"','"+Password+"','"+Uname2.getText()+"','"+JRagioSex+"','"+Uacnum2.getText().trim()+"','"+mobileNumber.getText().trim()+"','"+seK.getStringDay()+"','0','����','1','00000000000000000','"+birthdaySelect+"','"+idStyle+"','1')";
										int result = jdbc.excuteData(sqlZH);
										if(result==1) {
											ShowMessage success=new ShowMessage();
											success.successPLUS("�����ɹ�!","�˺�:6214536512478954","��ʼ����:123456");
											Uname2.setText(null);
											mobileNumber.setText(null);
											Uacnum2.setText(null);
										}else {
											ShowMessage fail=new ShowMessage();
											fail.init("�˺ų�ͻ,������");
										} 
										
										}
										else {
											ShowMessage fail1=new ShowMessage();
											fail1.init("�绰��������");
										}
										
										}else {
											ShowMessage fail=new ShowMessage();
											fail.init("�Ƿ����֤ !");
										}
								
							}
							
							
					}
				 
				
			
			   
		   });
	   
	   
	  
	  //ȡ��
	  n.add(reset);
	  reset.setBounds(330, 460, 58, 25);
	  reset.setBorder(BorderB);
	  reset.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Uname2.setText(null);
			mobileNumber.setText(null);
			Uacnum2.setText(null);
		}
		  
	  });
	 
	  reset.setIcon(IconJ);
  }
}
