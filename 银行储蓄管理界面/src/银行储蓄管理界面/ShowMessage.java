package 银行储蓄管理界面;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShowMessage extends JFrame{
	private JPanel J1;
	private JLabel message,J2;
	private Image img;
	private JButton confirm,cancel;
	private Boolean HQflag=false,DQflag=false,ZHflag=false;
	private TextBorderUtlis BorderText;
	private JPasswordField JTA, JTF;
	private JDBCDQ jdbcdq;
	public int m;

	public ShowMessage() {
		setTitle("消息提示");
		setVisible(true);
		setResizable(false);
		setBounds(0,0,300,200);
		setLocationRelativeTo(null);
		setVisible(true);
		Toolkit took =Toolkit.getDefaultToolkit();
		img=took.getImage("src/images/BT.jpeg");
		setIconImage(img);
		add(J1=new JPanel(null));
		J1.setBackground(Color.WHITE);
		BorderText=new TextBorderUtlis(new Color(0,191,255),1,true);
		JTA = new JPasswordField();
		JTF = new JPasswordField();
		jdbcdq=new JDBCDQ(2);
	}
	
	
	void init(String s) {
		 
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		message=new JLabel();
		J1.add(message);
		J1.setBounds(0,0,300,200);
		//显示消息提示信息
		JLabel JTS = new JLabel(s);
		J1.add(JTS);
		JTS.setBorder(Border);
		JTS.setBounds(100,60,200,25);
		
		J2=new JLabel();
		J1.add(J2);
		ImageIcon image = new ImageIcon("src/images/JG1.jpg");
		J2.setIcon(image);
		J2.setBounds(20,40,60,60);
	}
	public void success(String n) {
		
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		message=new JLabel();
		J1.add(message);
		J1.setBounds(0,0,300,200);
		//显示消息提示信息
		JTextField JTZ = new JTextField(n);
		JTZ.setEditable(false);
		JTZ.setBackground(Color.white);
		J1.add(JTZ);
		JTZ.setBorder(Border);
		JTZ.setBounds(100,60,250,25);
		
		
		
		J2=new JLabel();
		J1.add(J2);
		ImageIcon image = new ImageIcon("src/images/success.jpg");
		J2.setIcon(image);
		J2.setBounds(20,40,60,60);
	}
	
	public void successPLUS(String n,String m,String S) {
		
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		message=new JLabel();
		J1.add(message);
		J1.setBounds(0,0,300,200);
		//显示消息提示信息
		JTextField JTB = new JTextField(n);
		JTB.setBackground(Color.white);
		JTB.setEditable(false);
		J1.add(JTB);
		JTB.setBorder(Border);
		JTB.setBounds(100,40,250,25);
		
		JTextField JTA = new JTextField(m);
		JTA.setEditable(false);
		JTA.setBackground(Color.white);
		J1.add(JTA);
		JTA.setBorder(Border);
		JTA.setBounds(100,65,250,25);
		
		JTextField JTF = new JTextField(S);
		JTF.setEditable(false);
		JTF.setBackground(Color.white);
		J1.add(JTF);
		JTF.setBorder(Border);
		JTF.setBounds(100,90,250,25);
		
		JLabel J2B = new JLabel();
		J1.add(J2B);
		ImageIcon image = new ImageIcon("src/images/success.jpg");
		J2B.setIcon(image);
		J2B.setBounds(20,40,60,60);
	}
	//普通完成
	public void successW(String n) {
		 
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		JLabel messageB = new JLabel();
		J1.add(messageB);
		J1.setBounds(0,0,300,200);
		//显示消息提示信息
		JTextField JTZB = new JTextField(n);
		JTZB.setEditable(false);
		JTZB.setBackground(Color.white);
		J1.add(JTZB);
		JTZB.setBorder(Border);
		JTZB.setBounds(100,60,250,25);
		
		
		
		JLabel J2B = new JLabel();
		J1.add(J2B);
		ImageIcon image = new ImageIcon("src/images/完成1.jpg");
		J2B.setIcon(image);
		J2B.setBounds(20,40,60,60);
	}
	
	public void initAcnum(String acnum,String str) {
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		message=new JLabel();
		JLabel acnumnumber=new JLabel(acnum);
		J1.add(acnumnumber);
		acnumnumber.setBounds(80, 45, 150, 25);
		J1.add(message);
		J1.setBounds(0,0,300,200);
		//显示消息提示信息
		JLabel JTSE = new JLabel(str);
		J1.add(JTSE);
		JTSE.setBorder(Border);
		JTSE.setBounds(100,65,200,25);
		
		J2=new JLabel();
		J1.add(J2);
		ImageIcon image = new ImageIcon("src/images/JG1.jpg");
		J2.setIcon(image);
		J2.setBounds(20,40,60,60);
	}
	//销户功能
	public void  Qusition(String n,String m,String S,String Uacnum,int style) {
		
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		message=new JLabel();
		J1.add(message);
		J1.setBounds(0,0,300,200);
		//显示消息提示信息
		JTextField JTB = new JTextField(n);
		JTB.setBackground(Color.white);
		JTB.setEditable(false);
		J1.add(JTB);
		JTB.setBorder(Border);
		JTB.setBounds(100,20,250,25);
		
		JTextField JTA = new JTextField(m);
		JTA.setEditable(false);
		JTA.setBackground(Color.white);
		J1.add(JTA);
		JTA.setBorder(Border);
		JTA.setBounds(100,45,250,25);
		
		JTextField JTF = new JTextField(S);
		JTF.setEditable(false);
		JTF.setBackground(Color.white);
		J1.add(JTF);
		JTF.setBorder(Border);
		JTF.setBounds(100,70,250,25);
		
		JLabel J2B = new JLabel();
		J1.add(J2B);
		ImageIcon image = new ImageIcon("src/images/qd.jpg");
		J2B.setIcon(image);
		J2B.setBounds(20,30,60,60);
		
		confirm=new JButton("确认");
		J1.add(confirm);
		confirm.setBorder(Border);
		confirm.setBackground(new Color(222,235,255));
		confirm.setBounds(40, 125, 60, 25);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			   if(style==1){
			Password(Uacnum);
			   }
			   else if(style==2) {
				   Passwordloss(Uacnum);
			   }
				
				
			}
			
		});
		
		cancel=new JButton("取消");
		J1.add(cancel);
		cancel.setBorder(Border);
		cancel.setBounds(180,125,60,25);
		cancel.setBackground(new Color(222,235,255));
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
			
		});
		
	}
	public void Password(String acnum) {
		//刷新JPanel
		 J1.removeAll();
	     J1.repaint();
	     J1.updateUI();
	    
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		
		message=new JLabel();
		J1.add(message);
		J1.setBounds(0,0,300,200);
		
		JLabel JJ=new JLabel("账户密码:");
		J1.add(JJ);
		JJ.setBounds(20, 45, 100,25);
		
		JLabel JJB=new JLabel("确认密码:");
		J1.add(JJB);
		JJB.setBounds(20, 75, 100,25);
		
		//显示消息提示信息
		
		
		
		
		J1.add(JTA);
		JTA.setBorder(BorderText);
		JTA.setBounds(100,45,80,25);
		
		
		
		
		J1.add(JTF);
		JTF.setBorder(BorderText);
		JTF.setBounds(100,80,80,25);
		
	
		
		JButton J2=new JButton("确认");
		J2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(JTF.getText().equals(JTA.getText())){
					JDBCDQ jdbcdq=new JDBCDQ(m);
					String Upassword=null;
					System.out.println(acnum);
					String sqlpassword="SELECT * FROM yhcxgl_User WHERE Uacnum='"+acnum+"'";
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
		 					String source =JTA.getText();
		 					Password=encryptUtils.encryptToMD5(source);
					//解密
		 					
		 					
				
		 			}catch(Exception e1) {
		 				 e1.printStackTrace();
		 			}
		 			if(Upassword.equals(Password)) {
		 				String HQMX="DELETE  FROM yhcxgl_HQMX WHERE Hacnum='"+acnum+"'";
						int result=jdbcdq.excuteData(HQMX);
						if(1==result) {
							String HQ="DELETE  FROM yhcxgl_HQ WHERE Hacnum='"+acnum+"'";
							int resultHQ=jdbcdq.excuteData(HQ);
							if(1==resultHQ) {
								HQflag=true;
							}
							
						}

						String DQMX="DELETE  FROM yhcxgl_DQMX WHERE Dacnum='"+acnum+"'";
						int resultDQMX=jdbcdq.excuteData(DQMX);
						if(1==resultDQMX) {
							String DQ="DELETE  FROM yhcxgl_DQ WHERE Dacnum='"+acnum+"'";
							int resultDQ=jdbcdq.excuteData(DQ);
							if(1==resultDQ) {
								DQflag=true;
							}
							
						}
						
						if(HQflag&&DQflag) {
							String ZH="DELETE  FROM yhcxgl_ZH WHERE acnum='"+acnum+"'";
							int resultZH=jdbcdq.excuteData(ZH);
							if(1==resultZH) {
								ZHflag=true;
							}
							
						}
						if(ZHflag) {
							String User="DELETE  FROM yhcxgl_User WHERE Uacnum='"+acnum+"'";
							int resultUser=jdbcdq.excuteData(User);
							if(1==resultUser) {
								 J1.removeAll();
							     J1.repaint();
							     J1.updateUI();
								success("销户成功!");
							}else {
								 J1.removeAll();
							     J1.repaint();
							     J1.updateUI();
								init("销户失败!");
							}
						}
		 				
		 			}else {
		 				 J1.removeAll();
		 			     J1.repaint();
		 			     J1.updateUI();
		 				init("密码错误!");
		 			}
				}else {
					 J1.removeAll();
				     J1.repaint();
				     J1.updateUI();
					init("密码不一致!");
				}
			}
			
		});
		J1.add(J2);
		J2.setBounds(105, 130, 70, 25);
		J2.setBorder(Border);
		J2.setBackground(new Color(222,235,255));
	}
	//挂失账户输入密码
	public void Passwordloss(String acnum) {
		//刷新JPanel
		 J1.removeAll();
	     J1.repaint();
	     J1.updateUI();
	    
		TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
		
		message=new JLabel();
		J1.add(message);
		J1.setBounds(0,0,300,200);
		
		JLabel JJ=new JLabel("账户密码:");
		J1.add(JJ);
		JJ.setBounds(40, 45, 100,25);
		
		JLabel JJB=new JLabel("确认密码:");
		J1.add(JJB);
		JJB.setBounds(40, 75, 100,25);
		
		//显示消息提示信息
		
		
		
		
		J1.add(JTA);
		JTA.setBorder(BorderText);
		JTA.setBounds(120,45,80,25);
		
		
		
		
		J1.add(JTF);
		JTF.setBorder(BorderText);
		JTF.setBounds(120,80,80,25);
		
	
		
		JButton J2=new JButton("确认");
		
		J2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JTF.getText().equals(JTA.getText())) {
					String sqlpassword="SELECT * FROM yhcxgl_User WHERE Uacnum='"+acnum+"'";
					ResultSet rspassword = jdbcdq.slectData(sqlpassword);
					String Upassword=null;
					try {
						while(rspassword.next()) {
							Upassword = rspassword.getString(2);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//校验密码
					String Password=null;
		 			try {
		 					EncryptUtils encryptUtils = new EncryptUtils();
		 					String source =JTF.getText();
		 					Password=encryptUtils.encryptToMD5(source);
					//解密
		 					
		 					
				
		 			}catch(Exception e1) {
		 				 e1.printStackTrace();
		 			}
		 			
		 			if(Upassword.equals(Password)) {
		 				//更新状态
		 				String sqlUstate="UPDATE yhcxgl_User SET Ustate='挂失' WHERE Uacnum='"+acnum+"'";
						int result=jdbcdq.excuteData(sqlUstate);
						//更新数字
						String sqlU="UPDATE yhcxgl_User SET UstateNumber='2' WHERE Uacnum='"+acnum+"'";
						int resultU=jdbcdq.excuteData(sqlU);
						if((result==1)&&(resultU==1)) {
							 J1.removeAll();
						     J1.repaint();
						     J1.updateUI();
							successW("挂失成功!");
						}else {
							J1.removeAll();
						     J1.repaint();
						     J1.updateUI();
							init("挂失失败!");
						}
		 			}else {
		 				ShowMessage fail=new ShowMessage();
						fail.init("密码不正确!");
						JTA.setText(null);
						JTF.setText(null);
		 			}
				}else {
					JTA.setText(null);
					JTF.setText(null);
					ShowMessage fail=new ShowMessage();
					fail.init("密码不一致!");
				}
			}});
		
		JTA.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
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
		J1.add(J2);
		J2.setBounds(120, 130, 70, 25);
		J2.setBorder(Border);
		J2.setBackground(new Color(222,235,255));
	}
	
	//销户功能
		public void  exit(String m) {
			
			TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
			message=new JLabel();
			J1.add(message);
			J1.setBounds(0,0,300,200);
			//显示消息提示信息
			
			
			JTextField JTA = new JTextField(m);
			JTA.setEditable(false);
			JTA.setBackground(Color.white);
			J1.add(JTA);
			JTA.setBorder(Border);
			JTA.setBounds(100,45,250,25);
			
		
			
			JLabel J2B = new JLabel();
			J1.add(J2B);
			ImageIcon image = new ImageIcon("src/images/qd.jpg");
			J2B.setIcon(image);
			J2B.setBounds(20,30,60,60);
			
			confirm=new JButton("确认");
			J1.add(confirm);
			confirm.setBorder(Border);
			confirm.setBackground(new Color(222,235,255));
			confirm.setBounds(40, 125, 60, 25);
			confirm.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				   
				System.exit(0);
					
					
				}
				
			});
			
			cancel=new JButton("取消");
			J1.add(cancel);
			cancel.setBorder(Border);
			cancel.setBounds(180,125,60,25);
			cancel.setBackground(new Color(222,235,255));
			cancel.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					dispose();
				}
				
			});
			
		}
		//更改密码
		public void Passwordchance(String acnum) {
			//刷新JPanel
			 J1.removeAll();
		     J1.repaint();
		     J1.updateUI();
		    
			TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
			
			message=new JLabel();
			J1.add(message);
			J1.setBounds(0,0,300,200);
			
			JLabel JJ=new JLabel("账户密码:");
			J1.add(JJ);
			JJ.setBounds(40, 45, 100,25);
			
			JLabel JJB=new JLabel("确认密码:");
			J1.add(JJB);
			JJB.setBounds(40, 75, 100,25);
			
			//显示消息提示信息
			
			
			
			
			J1.add(JTA);
			JTA.setBorder(BorderText);
			JTA.setBounds(120,45,80,25);
			
			
			
			
			J1.add(JTF);
			JTF.setBorder(BorderText);
			JTF.setBounds(120,80,80,25);
			
		
			
			JButton J2=new JButton("确认");
			
			J2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(JTF.getText().equals(JTA.getText())) {
						String sqlpassword="SELECT * FROM yhcxgl_User WHERE Uacnum='"+acnum+"'";
						ResultSet rspassword = jdbcdq.slectData(sqlpassword);
						String Upassword=null;
						try {
							while(rspassword.next()) {
								Upassword = rspassword.getString(2);
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//校验密码
						String Password=null;
			 			try {
			 					EncryptUtils encryptUtils = new EncryptUtils();
			 					String source =JTF.getText();
			 					Password=encryptUtils.encryptToMD5(source);
						//解密
			 					
			 					
					
			 			}catch(Exception e1) {
			 				 e1.printStackTrace();
			 			}
			 			
			 			if(Upassword.equals(Password)) {
			 				JTA.setText(null);
							JTF.setText(null);
			 				NewPassword(acnum);
			 				
			 			}else {
			 				ShowMessage fail=new ShowMessage();
							fail.init("密码不正确!");
							JTA.setText(null);
							JTF.setText(null);
			 			}
					}else {
						JTA.setText(null);
						JTF.setText(null);
						ShowMessage fail=new ShowMessage();
						fail.init("密码不一致!");
					}
				}});
			
			JTA.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
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
			J1.add(J2);
			J2.setBounds(120, 130, 70, 25);
			J2.setBorder(Border);
			J2.setBackground(new Color(222,235,255));
		}
		//更改新的密码
		public void NewPassword(String acnum) {
			//刷新JPanel
			 J1.removeAll();
		     J1.repaint();
		     J1.updateUI();
		    
			TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
			
			message=new JLabel();
			J1.add(message);
			J1.setBounds(0,0,300,200);
			
			JLabel JJ=new JLabel("新密码:");
			J1.add(JJ);
			JJ.setBounds(40, 45, 100,25);
			
			JLabel JJB=new JLabel("确认密码:");
			J1.add(JJB);
			JJB.setBounds(40, 75, 100,25);
			
			//显示消息提示信息
			
			
			
			
			J1.add(JTA);
			JTA.setBorder(BorderText);
			JTA.setBounds(120,45,80,25);
			
			
			
			
			J1.add(JTF);
			JTF.setBorder(BorderText);
			JTF.setBounds(120,80,80,25);
			
		
			
			JButton J2=new JButton("确认");
			
			J2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(JTF.getText().equals(JTA.getText())) {
						
						String Password=null;
			 			try {
			 					EncryptUtils encryptUtils = new EncryptUtils();
			 					String source =JTF.getText();
			 					Password=encryptUtils.encryptToMD5(source);
						//加密
			 			}catch(Exception e1) {
			 				 e1.printStackTrace();
			 			}
			 			String sql4="UPDATE yhcxgl_User SET Upassword='"+Password+"' WHERE Uacnum='"+acnum+"'";
						int result4=jdbcdq.excuteData(sql4);
						if(result4==1) {
							 J1.removeAll();
						     J1.repaint();
						     J1.updateUI();
						     successW("更改密码成功!");
						}else {
							J1.removeAll();
						     J1.repaint();
						     J1.updateUI();
						     init("更改密码失败!");
						}
						
					}else {
						JTA.setText(null);
						JTF.setText(null);
						ShowMessage fail=new ShowMessage();
						fail.init("密码不一致!");
					}
				}});
			
			JTA.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
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
			J1.add(J2);
			J2.setBounds(120, 130, 70, 25);
			J2.setBorder(Border);
			J2.setBackground(new Color(222,235,255));
		}
}
