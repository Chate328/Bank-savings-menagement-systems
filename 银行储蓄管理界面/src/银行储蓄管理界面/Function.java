package 银行储蓄管理界面;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class Function extends JFrame{
	
	private Toolkit took;
	private Image img;
	private JPanel J1;
	private ImageIcon logo ;
	private JLabel JL1;
	private JTextField User;
	private JPasswordField Password;
	private JButton JBu3;
	private JTextField name;
	public Function() {
		init();
		setTitle("数据库登录");
		setLayout(null);
		add(J1=new JPanel());
		setVisible(true);
		setResizable(false);
		setBounds(0,0,500,372);
		setLocationRelativeTo(null);
		Toolkit took =Toolkit.getDefaultToolkit();
		img=took.getImage("src/images/BT.jpeg");
		setIconImage(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		J1.setBackground(Color.white);
		J1.setBounds(0, 0, 500, 375);
		logo = new ImageIcon("src/images/sql.jpg");
		JL1=new JLabel();
		JL1.setIcon(logo);
    	J1.add(JL1,new Integer (Integer.MIN_VALUE));
    	JL1.setBounds(0,0,logo.getIconWidth(),logo.getIconHeight());
    	 TextBorderUtlis Border = new TextBorderUtlis(new Color(225,245,255),2,true);
    	 TextBorderUtlis BorderB = new TextBorderUtlis(new Color(255,255,255),1,true);
    	name=new JTextField();
		JL1.add(name);
		name.setBounds(210, 120, 130, 28);
		name.setBorder(Border);
		
		User=new JTextField();
		JL1.add(User);
		User.setBounds(210, 180, 130, 28);
		User.setBorder(Border);
		
		Password=new JPasswordField();
		JL1.add(Password);
		Password.setBounds(210, 240, 130, 28);
		Password.setBorder(Border);
		
		JBu3 = new JButton("登录");
		JL1.add(JBu3);
		JBu3.setBorder(BorderB);
		JBu3.setBounds(100,300,80,28);
		JBu3.setBackground(new Color(215,233,255));
		   //挂失功能
		  
		   JBu3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(name.getText().equals("yhgxgl")) {
					//Employee
					if(User.getText().equals("Employee")||(User.getText().equals("sa"))) {
						if(User.getText().equals("Employee"))
						{
							if(Password.getText().equals("123456")) {
								LoginJFrame L=new LoginJFrame(2);
								
								dispose();
							}else {
								ShowMessage Facnum=new ShowMessage();
								Facnum.init("密码错误!");
								Password.setText(null);
							}
						}else {
							if(Password.getText().equals("123456")) {
								LoginJFrame L=new LoginJFrame(1);
								dispose();
							}else {
								ShowMessage Facnum=new ShowMessage();
								Facnum.init("密码错误!");
								Password.setText(null);
							}
						}
					}else {
						ShowMessage Facnum=new ShowMessage();
						Facnum.init("用户名不存在!");
						User.setText(null);
						Password.setText(null);
					}
					
					
				}else {

					ShowMessage Facnum=new ShowMessage();
					Facnum.init("数据库名错误!");
					name.setText(null);
					User.setText(null);
					Password.setText(null);
				}
						
					}
		
			
		   });
		   
		   
		   JButton JBu4 = new JButton("退出");
			JL1.add(JBu4);
			JBu4.setBorder(BorderB);
			JBu4.setBounds(310,300,80,28);
			JBu4.setBackground(new Color(215,233,255));
			   //挂失功能
			  
			   JBu4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
				   
			   });
	}
	private void init() {
		
	}
}

