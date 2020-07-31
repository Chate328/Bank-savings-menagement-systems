package 银行储蓄管理界面;




import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
 
 

 
public class LoginJFrame extends JFrame  implements ActionListener {
 JLabel lb_backgroud;
 JLabel jLabel,jLabel2,jLabel3;
 JTextField jt_usename,jt_code;
 JPasswordField jPasswordField;
 JPanel jPanel,jPanel2,jPanel3;
 JButton Login,regist;
 public String User,Password,Uname;
 public String UPassword=null;
 public boolean Falg=false,loss=false;
 public static int m;
 public int Ustate;
 //设置用户名和密码
 final String use_name="6";  
    final String use_pwd="1";    
 
 
 
 private ValidCode vcode = new ValidCode();
 public LoginJFrame(int n) {
  // TODO Auto-generated constructor stub
  this.m=n;
  Image logo = Toolkit.getDefaultToolkit().getImage("src/images/BT.jpeg");
  setIconImage(logo);
  TrayIcon icon = new TrayIcon(logo);
  icon.setImageAutoSize(true);
  SystemTray systemTray = SystemTray.getSystemTray();
  try {
   systemTray.add(icon);
  } catch (AWTException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  
  
  setBackgroudImage();  
  jLabel = new JLabel("账户");
  jLabel2 = new JLabel("密码");
  jLabel3 = new JLabel("验证码:");
  
  jt_usename = new JTextField();
  jPasswordField = new JPasswordField();
  jt_code = new JTextField();
  
  jLabel.setBounds(150, 140, 60, 40);
  jLabel2.setBounds(150, 175, 60, 40);
  jLabel3.setBounds(150, 220, 60, 40);
  TextBorderUtlis Border=new TextBorderUtlis(new Color(0,191,255),2,true);
  jt_usename.setBounds(200, 150, 170, 28);
  jt_usename.setBorder(Border);
  jPasswordField.setBounds(200, 185, 170,28);
  jPasswordField.setBorder(Border);
  jt_code.setBounds(200, 230, 50, 28);
  jt_code.setBorder(Border);
  vcode.setBounds(275, 225,20, 28);
  
  Login = new JButton("登录");
  Login.setBounds(200, 270, 40, 28);
  setJButton(Login);
  regist = new JButton("退出");  
  regist.setBounds(320, 270, 40, 28);
  setJButton(regist);
  regist.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	  
  });
  Login.addActionListener(this);
  
  
  
  
  
  this.setLayout(null);
  this.add(jLabel);
  this.add(jLabel2);
  this.add(jLabel3);
  
  this.add(jt_usename);
  this.add(jPasswordField);
  this.add(jt_code);
  this.add(vcode);
  this.add(Login);
  this.add(regist);
  
  this.setTitle("银行储蓄管理系统");
  this.setSize(600,352);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.setVisible(true);
  this.setResizable(false);
 }
 private void setBackgroudImage() {
  // TODO Auto-generated method stub
   ((JPanel) this.getContentPane()).setOpaque(false);  
         ImageIcon img = new ImageIcon("src/images/BJ6.jpg"); // 添加图片  
         lb_backgroud = new JLabel(img);  
         this.getLayeredPane().add(lb_backgroud, new Integer(Integer.MIN_VALUE));  
         lb_backgroud.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());  
 }
 
 /*
  * 设置按钮风格：透明 
  */
 private void setJButton(JButton btn) {  
  btn.setBackground(new Color(102, 0, 204));// 紫色 
  btn.setFont(new Font("Dialog", Font.BOLD, 17));  
  btn.setOpaque(false);  
  btn.setBorder(BorderFactory.createEmptyBorder());  
 }
 @Override
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
  if(e.getActionCommand() == "登录") {
   if(jt_code.getText().isEmpty()) {
	   ShowMessage fail=new ShowMessage();
		fail.init("请输入验证码!");
   }else {
    if(!isValidCodeRight()) {
    	ShowMessage fail=new ShowMessage();
			fail.init("验证码错误!");
     clear();
    }else if(isValidCodeRight()) {
    	
    	if((jt_usename.getText().equals("201835020710"))||(jt_usename.getText().equals("201835020711"))){
    		
    	}else {
    		//查询账号
        	JDBCDQ jdbcdq=new JDBCDQ(2);
        	String sql="SELECT * FROM yhcxgl_User WHERE Uacnum='"+jt_usename.getText()+"'";
    		ResultSet rs= jdbcdq.slectData(sql);
    		Boolean flagQ=false;
    		
    			try {
    				if(rs.next()) {
    					flagQ=true;
    				}
    				
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    		if(flagQ) {
    			
    			String sqlpassword="SELECT * FROM yhcxgl_User WHERE Uacnum='"+jt_usename.getText()+"'";
    			ResultSet rspassword = jdbcdq.slectData(sqlpassword);
    			try {
    				while(rspassword.next()) {
    					Password = rspassword.getString(2);
    					Uname=rspassword.getString(3);
    					Ustate=rspassword.getInt(14);
    				}
    			} catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			if(2==Ustate) {
    				loss=true;
    				
    			}else {
    				try {
    					EncryptUtils encryptUtils = new EncryptUtils();
    					String source =jPasswordField.getText();
    					UPassword=encryptUtils.encryptToMD5(source);
    		//解密
    					
    					
    	
    			}catch(Exception e1) {
    				 e1.printStackTrace();
    			}
    			// 如果密码配对成功
    					if(UPassword.equals(Password)) {
    							Falg=true;
    					}
    					
    					
    					
    					
    			}
    			
    		}
    		
    	}
    	
    	
			
 
     if((jt_usename.getText().equals("201835020710")) && 
    		 (jPasswordField.getText().equals("201835020710"))||(jt_usename.getText().equals("201835020711")) 
    		 && (jPasswordField.getText().equals("201835020711"))||Falg) {
    	if(jt_usename.getText().equals("201835020710")) {
    		TestFrame J= new TestFrame(2,2,"");
    		
    		J.setStyle("你好! 黄锦泉柜员");
    		
    	}else if(jt_usename.getText().equals("201835020711")){
    		TestFrame J= new TestFrame(m,2,"");
    		J.setStyle("你好! 黄炎松管理员");
    		
    		
    	}else {
    		TestFrame J= new TestFrame(2,3,jt_usename.getText());
    		J.setStyle("您好! 尊敬的"+Uname);
    		
    	}
    	
		dispose();
      clear();
     }else if(jt_usename.getText().isEmpty()&&jPasswordField.getText().isEmpty()) {
    	 			ShowMessage fail=new ShowMessage();
    	 			fail.init("请输入用户名和密码!");
      clear();
     }else if(jt_usename.getText().isEmpty()) {
    	 ShowMessage fail=new ShowMessage();
			fail.init("请输入用户名");
      clear();
     }else if(jPasswordField.getText().isEmpty()) {
    	 ShowMessage fail=new ShowMessage();
			fail.init("请输入密码!");
      clear();
     }else {
    	 if(loss) {
    		 ShowMessage fail=new ShowMessage();
 			fail.initAcnum("账户:"+jt_usename.getText(), "    已被冻结!");
    	 }else {
    		 ShowMessage fail=new ShowMessage();
 			fail.init("用户名或密码错误!");
    	 }
    	
      clear();
     }
     
		}
    }
   
   }
   
 }  
 
 
 private void clear() {
  // TODO Auto-generated method stub
  jt_usename.setText("");
  jPasswordField.setText("");
  jt_code.setText("");
 }
 //验证码的确认
 public boolean isValidCodeRight() {
  if(jt_code == null) {
   return false;
  }else if(vcode == null) {
   return true;
  }else if(vcode.getCode() .equals(jt_code.getText())) {
   return true;
  }else 
   return false;
 }
}