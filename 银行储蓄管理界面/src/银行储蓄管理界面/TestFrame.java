package ���д���������;

import javax.crypto.SecretKey;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class TestFrame extends JFrame{
	private JPanel J1,J2,J3,J4,J5,J6,J7,J8,J9,J10,J11,ZH,HQ,HQB,DQB,QK,LX,LXB,KH,acnum,sqlsever,Employee,Employeetable;
	private JPanel centre,account;
	private JLabel JL1,JL2,JL3,user;
	private Toolkit took;
	private JButton exit;
	private Image img ,imgJ3;
	private ImageIcon logo,iconJ3,logoBottom;
	private int table=0;
	private TableStyleForAcnum JTable2;
	private JTable jTable;
	private String Uacnum,Newvalue,Oldervalue;
	private int Row,Column;
	private Boolean Mouse=false,ENTER=false;
	public Boolean qu=false;
	public static int n,w;
	public static String User_id;
	//��ʼ��10�����
        public TestFrame(int number,int W,String str){
        	this.n=number;
        	this.w=W;
        	this.User_id=str;
            this.setLayout(null);
            add(acnum=new JPanel());
            add(J1=new JPanel(null));
            add(J2=new JPanel()); 
			add(J3=new JPanel(null));
            add(J4=new JPanel());
            add(J5=new JPanel(null));
            add(J6=new JPanel());
            add(J7=new JPanel());
            add(J8=new JPanel(null));
            add(J9=new JPanel(null));
            add(J11=new JPanel());
            add(ZH=new JPanel());
            add(HQ=new JPanel());
            add(HQB=new JPanel());
            add(DQB=new JPanel());
            add(J10=new JPanel(null));
            add(QK=new JPanel(null));
            add(LXB=new JPanel());
            add(LX=new JPanel(null));
            add(KH=new JPanel(null));
            add(sqlsever=new JPanel(null));
            add(Employeetable=new JPanel());
            add(Employee=new JPanel(null));
            add(account=new JPanel());
            add(centre=new JPanel(null));
            JL1 = new JLabel();
   		    logo = new ImageIcon("src/images/Bank1.jpg");
   		    logoBottom = new ImageIcon("src/images/BQL.jpg");
   		    JL2 = new JLabel();
   		    JL3=new JLabel("ʱ��");
   		 
   		    exit=new JButton("�˳�ϵͳ");
   		    //���ô��ڶ��� �͵ײ�
   		           
            init();
            
            setButton(w);
          
            JPeanlForZH ZH=new JPeanlForZH(n,User_id,w);
            ZH.setJ5Panel(J5);
    		//������ҳ���J9
    		
    		//�˻���ѯģ��
           
    	    setJ1Panel(J1,acnum);
    		
    		//���ģ��
    		JPeanlForCK CK=new JPeanlForCK(n,w,User_id);
    		CK.setJ8Panel(J8);
    		
    		
    		setJ10Panel();
    		//��Ϣ��
    		
    		JPeanlForLI LXJPeanl=new  JPeanlForLI(n);
    		LXJPeanl.LI(LX, LXB);
    		
    		JPanelForQK JZ=new JPanelForQK(n,User_id,w);
    		JZ.QK(QK);
    		//����
    		JPeanlForOpen KHJPanel=new JPeanlForOpen(n);
    		KHJPanel.KH(KH);
    		JTable2=new TableStyleForAcnum();
    		
    		JPanelForSQL SQL=new JPanelForSQL(n);
    		SQL.setSQL(sqlsever);
    		
    		if(3==w) {
    			JPanelForUserselect JP=new JPanelForUserselect(Employee,Employeetable,User_id);
        		JP.setUserSelect();
        		Userforcrente U=new Userforcrente(centre,User_id,account);
        		U.ActionListenerforcentre();
    		}
    		
        }
        
     
	

		void   init() {
        setTitle("���д������ϵͳ");
        setSize(920,662);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Toolkit took =Toolkit.getDefaultToolkit();
		img=took.getImage("src/images/BT.jpeg");
		setIconImage(img);
		
        J1.setBackground(Color.WHITE);
        J2.setBackground(Color.WHITE);
        J3.setBackground(Color.WHITE);
        J4.setBackground(Color.WHITE);
        J5.setBackground(Color.WHITE);
        J6.setBackground(Color.WHITE);
        J7.setBackground(Color.WHITE);
        J8.setBackground(Color.WHITE);
        J9.setBackground(Color.WHITE);
        J10.setBackground(Color.WHITE);
        J11.setBackground(Color.WHITE);
        ZH.setBackground(Color.white);
        DQB.setBackground(Color.white);
        HQ.setBackground(Color.white);
        HQB.setBackground(Color.white);
        QK.setBackground(Color.white);
        LX.setBackground(Color.white);
        LXB.setBackground(Color.white);
        KH.setBackground(Color.white);
        sqlsever.setBackground(Color.white);
        Employee.setBackground(Color.white);
        Employeetable.setBackground(Color.white);
        centre.setBackground(Color.white);
        account.setBackground(new Color(222,235,255));
        acnum.setBackground(new Color(222,235,255));
        //����ÿһ������λ�úʹ�С
        J2.setBounds(0,0,920,100);
        J3.setBounds(0, 100, 180, 500);
        //J5��� ��ɫ
        J5.setBounds(180,100,735,500);
        //J1��� ��ɫ
        J1.setBounds(180,100,735,500);
        J4.setBounds(0,600,920,32);
        J7.setBounds(180,100,735,500);
        J8.setBounds(180,100,735,500);
        //J6 ��� ��ɫ
        J6.setBounds(180,150,735,449);
        //��ӭ���
        J9.setBounds(180,100,735,500);
        J10.setBounds(180,100,735,500);
        J11.setBounds(180,100,735,405);
        ZH.setBounds(180,150,735,449);
        DQB.setBounds(180, 150, 735, 449);
        HQ.setBounds(180,150,735,449);
        HQB.setBounds(180,150,735,449);
        QK.setBounds(180, 100, 735, 500);
        LX.setBounds(180,100,735,500);
        LXB.setBounds(180,120,735,290);
        KH.setBounds(180, 100, 735, 500);
        acnum.setBounds(180,170, 730,180);
        sqlsever.setBounds(180, 100, 735,500);
        Employee.setBounds(180, 100, 735,500);
        Employeetable.setBounds(180,150,735,449);
        centre.setBounds(180, 100, 735, 500);
        account.setBounds(180,165,720,82);
      
        //��ʼ�����ֻ��ʾ	
        if(w==3) {
        	J5.setVisible(true);
        	J1.setVisible(false);
        	acnum.setVisible(false);
        	
        }else {
        	J5.setVisible(false);
        	J1.setVisible(true);
        	acnum.setVisible(true);
        	
        }
        ZH.setVisible(false);
        J6.setVisible(false);
		
		J7.setVisible(false);
		J8.setVisible(false);
		J9.setVisible(false);
		J10.setVisible(false);
		J11.setVisible(false);
		HQ.setVisible(false);
		HQB.setVisible(false);
		DQB.setVisible(false);
		QK.setVisible(false);
		LX.setVisible(false);
		LXB.setVisible(false);
		KH.setVisible(false);
		sqlsever.setVisible(false);
		account.setVisible(false);
		centre.setVisible(false);
		
		//����J1��� ���
		 
		
    }
        
        
       
        	
        	
        
      
        	
        	 public  void setStyle(String S) {
        	    	//��������ͼƬ
        	    	
        	    	//�������
        		 user=new JLabel(S);
        		 TextBorderUtlis Border = new TextBorderUtlis(new Color(255,255,255),1,true);
        	    	
        	    	JL1.setIcon(logo);
        	    	J2.add(JL1,new Integer (Integer.MIN_VALUE));
        	    	JL1.setBounds(0,0,logo.getIconWidth(),logo.getIconHeight());
        	    	
        	    	//�ײ�����ͼƬ
        	    	JL2=new JLabel();
        	    	logoBottom=new ImageIcon("src/images/BQL.jpg");
        	    	JL2.setIcon(logoBottom);
        	    	J4.add(JL2,new Integer (Integer.MIN_VALUE));
        	    	JL2.setBounds(0,0,logoBottom.getIconWidth(),logoBottom.getIconWidth());
        	    	NowTime time=new NowTime();
        	    	JL1.add(JL3);
        	    	JL3.setBounds(680, 35, 140, 40);
        	    	JL3.setFont(new Font("����",Font.PLAIN,13));
        	    	JL3.setForeground(Color.BLACK);
        	    	time.setTimer(JL3);
        	    	
        	    	JL1.add(user);
        	    	user.setBounds(780,23,140,25);
        	    	
        	    	JL1.add(exit);
        	    	exit.setBounds(830, 43, 70, 25);
        	    	exit.setFont(new Font("����",Font.PLAIN,13));
        	    	exit.setForeground(new Color(50,147,215));
        	    	exit.setBackground(Color.white);
        	    	exit.setBorder(Border);
        	    	exit.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							ShowMessage S=new ShowMessage();
							 S.exit("�Ƿ��˳�ϵͳ?");
						}
        	    		
        	    	});
        	    }
        
    
    //�����б�
   public void setButton(int w) {
	   JButton JB1,JB2,JB3,JB4,JB5,JB6;
	   TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),1,true);
	   JButton JBQ2 = new JButton();
	   JPanel JP2=new JPanel(null);
	   JButton JBB8=new JButton();
	   JPanel JP4=new JPanel(null);
	   JButton JBB9=new JButton("������");
	   JPanel JP3=new JPanel(null);
	   JButton User=new JButton();
	   JButton User2=new JButton();
	  
	   JButton User3=new JButton();
	   User3.setVisible(false);
		  
	   JButton User4=new JButton();
	   User4.setVisible(false);
		  
		   J3.add(User3);
		   User3.setBounds(0, 10, 170, 32);
		   User3.setBorder(Border);
		   ImageIcon okIconB =new ImageIcon("src/images/GRZX.jpg");
		   User3.setIcon(okIconB);
		   User3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				User3.setVisible(false);
				User4.setVisible(true);
				User2.setVisible(false);
				User.setVisible(true);
				J6.setVisible(false);
				J5.setVisible(false);
				J1.setVisible(false);
				J7.setVisible(false);
				J8.setVisible(false);
				J9.setVisible(false);
				J10.setVisible(false);
				J11.setVisible(false);
				ZH.setVisible(false);
				HQ.setVisible(false);
				HQB.setVisible(false);
				DQB.setVisible(false);
				QK.setVisible(false);
				LX.setVisible(false);
				LXB.setVisible(false);
				KH.setVisible(false);
				acnum.setVisible(false);
				sqlsever.setVisible(false);
				Employee.setVisible(false);
				Employeetable.setVisible(false);
				centre.setVisible(true);
				account.setVisible(true);
			}
			   
		   });
		   
		   J3.add(User4);
		   User4.setBounds(0, 10, 170, 32);
		   User4.setBorder(Border);
		   ImageIcon okIcon4 =new ImageIcon("src/images/GR.jpg");
		   User4.setIcon(okIcon4);
		   
		   User4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User3.setVisible(true);
				User4.setVisible(false);
				
			}
			   
		   });
	
	   JB2=new JButton();
	   //�������ܲ˵������
	   JPanel JP=new JPanel(null);
   	   JP.setBackground(Color.WHITE);
   	   JP.setVisible(false);
   	   J3.add(JP);
   	   JP.setBounds(0, 10, 176, 120);
   	  
   	   //��ǩ����
   	   
   	   //��ť��ʾ�˻��������
   	   JButton JBB1 = new JButton("�˻���ѯ");
   	   
   	   JB1=new JButton();//�˻�����ť
	   JBB1.setBounds(190, 10, 40, 20);
	   JBB1.setBackground(Color.white);
	   JP.add(JBB1);
	   JBB1.setBorder(Border);
	   JBB1.setBounds(30, 40,100, 25);
	   JBB1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(true);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(true);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
			JB1.setContentAreaFilled(false);
			JP2.setVisible(false);
			JB2.setContentAreaFilled(false);
			JBQ2.setContentAreaFilled(false);
			
		}
		   
	   });
	   JButton KHB=new JButton("��������");
	   JP.add(KHB);
	   KHB.setBounds(30,70, 100, 25);
	   KHB.setBorder(Border);
	   KHB.setBackground(Color.white);
	  
	   KHB.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(true);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
			JB1.setContentAreaFilled(false);
			
		}
		   
	   });
   	   
	   JButton JBQ = new JButton();
	   JP.add(JBQ);
	   ImageIcon okIconBA =new ImageIcon("src/images/II.jpg");
	   JBQ.setIcon(okIconBA);
	   JBQ.setBorder(Border);
	   JBQ.setBounds(1, 2, 170, 30);
	   JBQ.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JP.setVisible(false);
			JBQ.setContentAreaFilled(false);
			JBB1.setContentAreaFilled(false);
			JB1.setContentAreaFilled(true);
			JP2.setVisible(false);
			JB2.setContentAreaFilled(false);
			JBQ2.setContentAreaFilled(false);
			JB1.setContentAreaFilled(false);
			
		}
		   
	   });
	   
	   //JB1 ��ť��ʽ
	  
	   J3.add(JB1);
	   JB1.setPreferredSize(new Dimension(170,32));
	   ImageIcon okIconS =new ImageIcon("src/images/JButton GL.jpg");
	   JB1.setIcon(okIconS);
	   
	   JB1.setBorder(Border);
	   JB1.setBounds(0, 10, 170, 32);
	   JB3=new JButton();
	   //����¼�JB1 ����JB1 ��ʾJ1���
	   JB1.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

				 //����J1���
				JP.setVisible(true);
				JP2.setVisible(false);
				JB2.setContentAreaFilled(false);
				JBB1.setContentAreaFilled(true);
				JB3.setContentAreaFilled(false);
				JP3.setVisible(false);
				JP4.setVisible(false);
			}
			
		});
	   
	   //JB2 ��ť��ʽ ����JB2 ��ʾJ5���
	   
	   
	   J3.add(JP2);
	   J3.add(JB2);
	   ImageIcon Icon =new ImageIcon("src/images/ת��.jpg");
	   JB2.setContentAreaFilled(false);
	   JB2.setIcon(Icon);
	   TextBorderUtlis Border2=new TextBorderUtlis(new Color(255,255,255),1,true);
	   JB2.setBorder(Border2);
	   JB2.setBounds(0,50,171,34);
	   
	   
	   //�����˵����
	   
	   
   	   JP2.setBackground(Color.WHITE);
   	   JP2.setVisible(false);
   	  // JP2.setVisible(false);
   	  
   	   JP2.setBounds(0,50, 171,85);
	   
   	   
	   JP2.add(JBQ2);
	   ImageIcon okIconBA2 =new ImageIcon("src/images/ת�˶���.jpg");
	   JBQ2.setIcon(okIconBA2);
	   JBQ2.setBorder(Border);
	   JBQ2.setBounds(1, 2, 170, 30);
	   JBQ2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JP2.setVisible(false);
			JP.setVisible(false);
			if(3==w) {
				User.setVisible(true);
			}
			
		}
		   
	   });
	   
	   //������ť
	   JButton JBB2=new JButton("����ת�˻��");
	   JBB2.setBounds(190, 10, 40, 20);
	   JBB2.setBackground(Color.white);
	   JP2.add(JBB2);
	   JBB2.setBorder(Border);
	   JBB2.setBounds(30,45,100, 25);
	   JBB2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			J6.setVisible(false);
			J5.setVisible(true);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
		}
	   
	   });
	   
	   JB5=new JButton();
	  
	  
	   //����¼�JB2
	   JB2.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JP2.setVisible(true);
				JP.setVisible(false);
				JB2.setContentAreaFilled(false);
				JB5.setContentAreaFilled(false);
				JB3.setContentAreaFilled(false);
				JP3.setVisible(false);
				User.setVisible(false);
				User2.setVisible(false);
			}
			
		});
	   
	   //�����˵� ��ѯ��¼
	   JButton JBQ3=new JButton();
	  
	 
   	   JP3.setBackground(Color.WHITE);
   	   JP3.setVisible(false);
   	   J3.add(JP3);
   	   JP3.setBounds(0,93, 171, 230);
	   
   	   JP3.add(JBQ3);
	   ImageIcon okIconBA3 =new ImageIcon("src/images/��¼����.jpg");
	   JBQ3.setIcon(okIconBA3);
	   JBQ3.setBorder(Border);
	   JBQ3.setBounds(1, 2, 170, 30);
	   JBQ3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			JP3.setVisible(false);
			JBQ3.setContentAreaFilled(false);
			JB3.setContentAreaFilled(true);
			JBB8.setContentAreaFilled(false);
			JP4.setVisible(false);
			
			
		}

   	   
	   });
	   
	   JButton JBB3=new JButton("��ѯת�˼�¼");
	   JBB3.setBackground(Color.white);
	   JP3.add(JBB3);
	   JBB3.setBorder(Border);
	   JBB3.setBounds(30,115,100, 25);
	   JBB3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(true);
			J11.setVisible(false);
			ZH.setVisible(true);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
			table=3;
			
		}
		   
	   });
	   
	   JButton JBB4=new JButton("��ѯ���ڼ�¼");
	  
	   JBB4.setBackground(Color.white);
	   JP3.add(JBB4);
	   JBB4.setBorder(Border);
	   JBB4.setBounds(30,80,100, 25);
	   JBB4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(true);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(true);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
			table=2;
			
		}
		   
	   });
	   
	   JButton JBB5=new JButton("��ѯ���ڼ�¼");
	   JBB5.setBackground(Color.white);
	   JP3.add(JBB5);
	   JBB5.setBorder(Border);
	   JBB5.setBounds(30,45,100, 25);
	   JBB5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			J5.setVisible(false);
			J1.setVisible(false);
			J6.setVisible(true);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(true);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
			table=1;
			
		}
		   
	   });
	   
	   JButton JBB6=new JButton("��ѯ���ڴ�ȡ��ϸ");
	  
	   JBB6.setBackground(Color.white);
	   JP3.add(JBB6);
	   JBB6.setBorder(Border);
	   JBB6.setBounds(20,150,120, 25);
	   JBB6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JBB8.setContentAreaFilled(false);
			JB5.setContentAreaFilled(false);
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(true);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(true);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
			table=4;
			
		}
		   
	   });
	   
	   JButton JBB7=new JButton("��ѯ���ڴ�ȡ��ϸ");
	   JBB7.setBackground(Color.white);
	   JP3.add(JBB7);
	   JBB7.setBorder(Border);
	   JBB7.setBounds(20,185,120, 25);
	   JBB7.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(true);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(true);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
			table=5;
			
		}
		   
	   });
	   
	  
	   J3.add(JB3);
	   
	   JB3.setPreferredSize(new Dimension(170,32));
	   ImageIcon Icon3 =new ImageIcon("src/images/��¼.png");
	   JB3.setIcon(Icon3);
	   TextBorderUtlis Border3=new TextBorderUtlis(new Color(255,255,255),1,true);
	   JB3.setBorder(Border3);
	   JB3.setBounds(0, 93, 171, 32);
	  
	   JButton XT=new JButton();
	   JPanel P5=new JPanel(null);
	   JButton XTE=new JButton();
	   P5.setVisible(false);
	   //����¼�JB3 ��ʾ����ת�˱��
	   JB3.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				JP3.setVisible(true);
				JB3.setContentAreaFilled(false);
				JBQ3.setVisible(true);
				JP4.setVisible(false);
				JB5.setContentAreaFilled(false);
				XT.setContentAreaFilled(false);
				P5.setVisible(false);
			}
			
		});
	   
	   JB4=new JButton();
	   J3.add(JB4);
	   JB4.setPreferredSize(new Dimension(170,32));
	   ImageIcon Icon4 =new ImageIcon("src/images/JButton DL.jpg");
	   JB4.setIcon(Icon4);
	   TextBorderUtlis Border4=new TextBorderUtlis(new Color(255,255,255),1,true);
	   JB4.setBorder(Border4);
	   //����¼�JB4
	   JB4.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				J6.setVisible(false);
				J5.setVisible(false);
				J1.setVisible(false);
				J7.setVisible(false);
				J8.setVisible(false);
				J9.setVisible(true);
				J10.setVisible(false);
				J11.setVisible(false);
				ZH.setVisible(false);
				HQ.setVisible(false);
				HQB.setVisible(false);
				DQB.setVisible(false);
				QK.setVisible(false);
				LX.setVisible(false);
				LXB.setVisible(false);
				KH.setVisible(false);
				acnum.setVisible(false);
				sqlsever.setVisible(false);
				Employee.setVisible(false);
				Employeetable.setVisible(false);
				centre.setVisible(false);
				account.setVisible(false);
			}
			
		});
	   //�����˵����
	   
	  
	   J3.add(JP4);
	   JP4.setVisible(false);
	   JP4.setBounds(0, 135, 170, 120);
	   JP4.setBackground(Color.WHITE);
	  
	  
	   JP4.add(JBB8);
	   ImageIcon Icon8 =new ImageIcon("src/images/��ȡ.jpg");
	   JBB8.setIcon(Icon8);
	   JBB8.setBounds(0, 0, 170, 32);
	   JBB8.setBorder(Border);
	   JBB8.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JBB8.setContentAreaFilled(false);
			JP4.setVisible(false);
			JBB9.setContentAreaFilled(false);
			XT.setContentAreaFilled(true);
		}
		   
	   });
	  
	   
	  
	   JP4.add(JBB9);
	   JBB9.setBounds(30,45,100,25);
	   JBB9.setBackground(Color.white);
	   JBB9.setBorder(Border);
	   JBB9.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			J5.setVisible(false);
			J1.setVisible(false);
			J6.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(true);
			J9.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
		}
		   
	   });
	   
	   J3.add(JB5);
	   ImageIcon Icon5 =new ImageIcon("src/images/CK.png");
	   JB5.setIcon(Icon5);
	   JB5.setBounds(0, 135, 170,32);
	   TextBorderUtlis Border5=new TextBorderUtlis(new Color(255,255,255),1,true);
	   JB5.setBorder(Border5);
	   JB5.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JB5.setContentAreaFilled(false);
				JP4.setVisible(true);
				JB3.setContentAreaFilled(false);
				JBQ3.setVisible(true);
				JP3.setVisible(false);
				JBB9.setContentAreaFilled(true);
				JBB8.setContentAreaFilled(true);
				XT.setContentAreaFilled(false);
				P5.setVisible(false);
			}
			
		});
	   
	   JB6=new JButton("ȡ�����");
	   JP4.add(JB6);
	   JB6.setBounds(30, 80, 100, 25);
	   JB6.setBorder(Border);
	   JB6.setBackground(Color.white);
	   JB6.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(true);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
		}
		   
	   });
	  
	   J3.add(P5);
	   J3.add(XT);
	   XT.setBounds(0,180,170,32);
	   ImageIcon IconXT =new ImageIcon("src/images/XTSZ.png");
	   XT.setIcon(IconXT);
	   XT.setBorder(Border5);
	  
	   P5.setVisible(false);
	 
	   XT.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			XT.setContentAreaFilled(false);
		
			P5.setVisible(true);
			JP3.setVisible(false);
		}
		   
	   });
	  
	 
	  
	   P5.setBounds(0, 180, 170, 130);
	   P5.setBackground(Color.white);
	 
	 
	   P5.add(XTE);
	   XTE.setBounds(0,0,170,32);
	   XTE.setBorder(Border5);
	   ImageIcon Iconerj =new ImageIcon("src/images/XTS.jpg");
	   XTE.setIcon(Iconerj);
	  
	   XTE.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		   P5.setVisible(false);
		   XT.setVisible(true);
		}
		   
	   });
	   
	   JButton LXZ=new JButton("���ʵ���");
	   P5.add(LXZ);
	   LXZ.setBounds(30, 40, 100, 25);
	   LXZ.setBorder(Border5);
	   LXZ.setBackground(Color.white);
	   
	   LXZ.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(true);
			LXB.setVisible(true);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
		}
		   
	   });
	   
	   JButton HF=new JButton("���ݻָ��뱸��");
	   P5.add(HF);
	   HF.setBounds(30, 80, 100, 25);
	   HF.setBorder(Border5);
	   HF.setBackground(Color.white);
	   HF.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(true);
			Employee.setVisible(false);
			Employeetable.setVisible(false);
			centre.setVisible(false);
			account.setVisible(false);
		}
		   
	   });
	   J3.add(User2);
	   J3.add(User);
	   User.setVisible(false);
	   User.setBounds(0,95, 170, 32);
	   ImageIcon Icon5w =new ImageIcon("src/images/��¼.png");
	   User.setIcon(Icon5w);
	   User.setBorder(Border5);
	   
	 
	   User2.setVisible(false);
	   User2.setBounds(0, 95,170, 32);
	   ImageIcon Icon5r =new ImageIcon("src/images/��¼����.jpg");
	   User2.setIcon(Icon5r);
	   User2.setBorder(Border5);
	   
	   User.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			User2.setVisible(true);
			User.setVisible(false);
			User3.setVisible(true);
			User4.setVisible(false);
			J6.setVisible(false);
			J5.setVisible(false);
			J1.setVisible(false);
			J7.setVisible(false);
			J8.setVisible(false);
			J9.setVisible(false);
			J10.setVisible(false);
			J11.setVisible(false);
			ZH.setVisible(false);
			HQ.setVisible(false);
			HQB.setVisible(false);
			DQB.setVisible(false);
			QK.setVisible(false);
			LX.setVisible(false);
			LXB.setVisible(false);
			KH.setVisible(false);
			acnum.setVisible(false);
			sqlsever.setVisible(false);
			Employee.setVisible(true);
			Employeetable.setVisible(true);
			centre.setVisible(false);
			account.setVisible(false);
		}
		   
	   });
	   User2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			User2.setVisible(false);
			User.setVisible(true);
			
		}
		   
	   });
	   
	   
	   if(w==3) {
		   
		   JB1.setVisible(false);
		   JB1.setContentAreaFilled(false);
		   User.setVisible(true);
		   JB3.setVisible(false);
		   User3.setVisible(true);
		   XT.setVisible(false);
		   
	   }
   }
   
    
   //��¼��ѯ�������
   
   public void setJ10Panel() {
	   JButton JB1,JB2,JB3;
	   //�û��ж�
	 
	   JLabel J1,J2,J3;
	   TextBorderUtlis Border=new TextBorderUtlis(new Color(222,235,255),1,true);
	   TextBorderUtlis BorderS=new TextBorderUtlis(new Color(0,191,255),1,true);
	 
	   J3=new JLabel("������:");
	   J10.add(J3);
	   J3.setBounds(0, 10, 100, 24);
	   J3.setForeground(Color.BLUE);
	   
	   JTextField JDQ=new JTextField();
	   JDQ.setBounds(250, 13, 200, 25);
	   J10.add(JDQ);
	   JDQ.setBorder(BorderS);
	   
	   JComboBox J4=new JComboBox();
	   J4.setBounds(150, 15, 70, 19);
	   J4.setBorder(BorderS);
	   J4.setBackground(Color.WHITE);
	   J10.add(J4);
	   J4.addItem("�˻�");
	   J4.addItem("��ˮ��");
	   J4.addItem("������");
	   J4.addItem("ȫ��");
	  
	  
	   JB3=new JButton();
	   JB3.setBounds(480, 14, 40, 23);
	   ImageIcon Icon3 =new ImageIcon("src/images/CX.jpg");
	   JB3.setIcon(Icon3);
	   J10.add(JB3);
	   JB3.setBorder(Border);
	   //new HQMX
	   HQMX H=new HQMX(n);
	   DQMX D=new DQMX(n);
	   ZH Z=new ZH(n);
	   DQ DQ=new DQ(n);
	   HQ HQJ=new HQ(n);
	   JB3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			//�жϲ�ѯ����
			 int flag = 0;
			 String str=JDQ.getText();
			 if(J4.getSelectedItem().toString().equals("�˻�"))
			 {
				 flag=1;
				
			 }
			 else if(J4.getSelectedItem().toString().equals("��ˮ��"))
			 {
				 flag=2;
		
			 }else if(J4.getSelectedItem().toString().equals("������"))
			 {
				
					  flag=3;
	
			 }
			 else if(J4.getSelectedItem().toString().equals("ȫ��")){
				 flag=4;
			 }
			 
			 //�жϵ������ű�
			 if(1==table) {
				 DQ.DQSELECTPanel(J6,flag,str);
			 }
			 else if(2==table) {
				 HQJ.HqSelectPanel(HQ,flag,str);
			 }else if(3==table) {
				 Z.ZHSELECTZH(ZH,flag,str);
			 }else if(4==table) {
				 D.DQMX(DQB,flag,str);
			 }else {
				 H.HQMX(HQB,flag,str);
			 }
			 	  
			}
		
		  
	   });
	   
	   
   }
   
  
   public void setJ1Panel(JPanel m,JPanel Table) {
		  
		 JLabel JLa1,JLa2,JLa3,JLa4;
		   JTextField state2;
		   JTextField JTe1,JTe2,JTe3,JTe4;
		   JButton JBu1,JBu2,JBu3,JBu4;
		   TextBorderUtlis Border;
		   TextBorderUtlis BorderB, BorderX;
		   ImageIcon Iconu;
		  
		   JComboBox Style;
		   int flag=0;
		
		 Border=new TextBorderUtlis(new Color(0,191,255),2,true);   
			JTe1 =new JTextField();
			JLa1=new JLabel("�˻�����");
			JLa2=new JLabel("��ѯ�˻�������Ϣ:");
			
			JLa4=new JLabel("ѡ���������:");
			BorderB=new TextBorderUtlis(new Color(255,255,255),1,true);	
			BorderX=new TextBorderUtlis(new Color(215,233,255),3,true);	
			JBu3=new JButton("�޸�"); 
			JBu4=new JButton("����");
			state2=new JTextField();
			JBu1=new JButton();
			Iconu =new ImageIcon("src/images/CX.jpg");
			Style=new JComboBox();
		   
		   m.add(Style);
		   Style.addItem("�˻�");
		   Style.addItem("֤������");
		   Style.addItem("��������");
		   Style.addItem("����");
		 
		 
		   Style.setBounds(130, 40, 80, 23);
		   Style.setBorder(BorderB);
		   Style.setBackground(Color.white);
		  
		   JTe1.setBorder(Border);
		   JTe1.setBounds(250,40,200,25);
		   m.add(JTe1);
		   
		   JLa1.setBounds(0,0,100,25);
		   JLa1.setForeground(Color.BLUE);
		   m.add(JLa1);
		 
		   JLa2.setBounds(10,20,120,25);
		   //m.add(JLa2);

		   JLa4.setBounds(10,260,100,25);
		   m.add(JLa4);
		  
		   m.add(JBu3);
		   JBu3.setBorder(BorderX);
		   JBu3.setBounds(250,400,70,25);
		   JBu3.setBackground(new Color(215,233,255));
		   //��ʧ����
		  
		   JBu3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JDBCDQ jdbcdq=new JDBCDQ(n);
							if(Mouse&&ENTER) {
								if(Newvalue.equals(Oldervalue)) {
									ShowMessage Facnum=new ShowMessage();
									Facnum.init("δ�޸�����");

								}else {
									
									if(Column==7) {
											RegexUtils Mobile=new RegexUtils();
											if(Mobile.validateMobilePhone(Newvalue)) {
												String sqlUphone="UPDATE yhcxgl_User SET Uphone='"+Newvalue+"' WHERE Uacnum='"+Uacnum+"'";
												int result4=jdbcdq.excuteData(sqlUphone);
												ShowMessage success=new ShowMessage();
												if(1==result4) {
										
													success.successW("�޸ĳɹ�!");
												}else {
													success.init("�޸�ʧ��!");
												}	
												}else {
													ShowMessage fail=new ShowMessage();
													fail.init("�绰�����ʽ����!");
												}
									
											
										}
									else if(Column==10) {
									    if(Newvalue.equals("����")||Newvalue.equals("��ʧ")) {
									    	//����״̬
									    	String sqlUstate="UPDATE yhcxgl_User SET Ustate='"+Newvalue+"' WHERE Uacnum='"+Uacnum+"'";
											int result=jdbcdq.excuteData(sqlUstate);
											//��������
											if(Newvalue.equals("����")) {
												String sqlU="UPDATE yhcxgl_User SET UstateNumber='1' WHERE Uacnum='"+Uacnum+"'";
												int resultU=jdbcdq.excuteData(sqlU);
											}else {
												String sqlU="UPDATE yhcxgl_User SET UstateNumber='2' WHERE Uacnum='"+Uacnum+"'";
												int resultU=jdbcdq.excuteData(sqlU);
											}
											ShowMessage success=new ShowMessage();
											if(1==result) {
											
												success.successW("�޸ĳɹ�!");
											}else {
												success.init("�޸�ʧ��!");
											}
									    } 
									    else {
									    	ShowMessage fail=new ShowMessage();
									    	fail.init("״̬��д����!");
									    }
										
									}
								
										else if(Column==1) {
								    	 Pattern P=new Pattern();
								    	if(P.isPassword(Newvalue)) {
								    		//MD5����
								    		EncryptUtils encryptUtils = new EncryptUtils();
											String source =Newvalue;
											String Password=encryptUtils.encryptToMD5(source);
								    		//�޸�����
								    		String sqlUstate="UPDATE yhcxgl_User SET Upassword='"+Password+"' WHERE Uacnum='"+Uacnum+"'";
											int result=jdbcdq.excuteData(sqlUstate);
											ShowMessage success=new ShowMessage();
											if(1==result) {
											
												success.successW("�޸ĳɹ�!");
											}else {
												success.init("�޸�ʧ��!");
											}
								    	}else {
								    		ShowMessage fail=new ShowMessage();
									    	fail.init("�����޸ĸ�ʽ����!");
								    	}
								    
									}else {
										ShowMessage Facnum=new ShowMessage();
										Facnum.init("����Ϣ�޷�����");
									}
									}
								
								}else {
									ShowMessage Facnum=new ShowMessage();
									Facnum.init("��δ�����޸�!");
								}
							
						
						
			
			}   
		   });
		   
		   
		   
		  
		   m.add(JBu4);
		   JBu4.setBorder(BorderX);
		   JBu4.setBounds(360,400,70,25);
		   JBu4.setBackground(new Color(215,233,255));
		   JBu4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ShowMessage q=new ShowMessage();
				q.m=n;
				if(Uacnum!=null) {
					q.Qusition("ע����ǰ�˻� ",Uacnum,"���������!",Uacnum,1);
				}else {
					q.init("��δѡ���˻�!");
				}
				
			}
			   
		   });
		   
		  
		   //�õ�����
		   
		  
		   
		   //�������
		   
		 
		   TextBorderUtlis BorderF=new TextBorderUtlis(new Color(222,235,255),1,true);
		  
		 
		   
		  
		   m.add(JBu1);
		  
		   JBu1.setIcon(Iconu);
		   JBu1.setBorder(BorderB);
		   JBu1.setBounds(490,43,40,18);
		   //�˻�����  ��ѯ��ť�¼�
		  JBu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ֱ�ӵ���public void MyTable ������
				//��ϴ�¼�
				Mouse=false;
				ENTER=false;
			   List<String> columnZ=new ArrayList<>(Arrays.asList("�˻�","����","����","��������","�Ա�","֤������","֤������","Ԥ���绰","��������","���","״̬"));
		       List<List<String>> rowZ=new ArrayList<>();
			  
				//��ѯ�˻���Ϣ
					JDBCDQ jdbcdq = new JDBCDQ(n);
					String strPLUS=JTe1.getText()+"%";
					String sql=null;
					  if(Style.getSelectedItem().toString().equals("�˻�"))
						 {
						  sql="SELECT * FROM yhcxgl_User WHERE Uacnum like '"+strPLUS+"'";
							
						 }
						 else if(Style.getSelectedItem().toString().equals("֤������"))
						 {
						 sql="SELECT * FROM yhcxgl_User WHERE UID like '"+strPLUS+"'";
					
						 }else if(Style.getSelectedItem().toString().equals("��������"))
						 {
							
						    sql="SELECT * FROM yhcxgl_User WHERE CONVERT(varchar,Uopen,120)LIKE'"+strPLUS+"'";
							
							
						 }
						 else {
							 sql="SELECT * FROM yhcxgl_User WHERE Uname like '"+strPLUS+"'";
						 }
				
					
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
					
		        
		        MyTable(columnZ, rowZ,"", Table);
			}
			   
		   });
		   
		   
		   
		   
	   }
	   
  
   //����캯��
   public void MyTable(List<String> columns,List<List<String>> rows,String title,JPanel n){
	   //���ñ����ʽ
	   
	  
	  
	    //������ʾ
	   JScrollPane jsp;
	    //rowData�������
	    //columnName�������
	   Vector rowData, columnName;
	   rowData=new Vector<String>();
       columnName=new Vector();
       for (int i=0;i<columns.size();i++)columnName.add(columns.get(i));
       for (int i=0;i<rows.size();i++){
           Vector row=new Vector();
           for (int j=0;j<rows.get(i).size();j++){
               row.add(rows.get(i).get(j));
           }
           rowData.add(row);
       }
       DefaultTableModel defaultTableModel = new DefaultTableModel(rowData,columnName);
       jTable=new JTable(defaultTableModel);
       rowData=new Vector<String>();
       columnName=new Vector();
       for (int i=0;i<columns.size();i++)columnName.add(columns.get(i));
       for (int i=0;i<rows.size();i++){
           Vector row=new Vector();
           for (int j=0;j<rows.get(i).size();j++){
               row.add(rows.get(i).get(j));
           }
           rowData.add(row);
       }
       defaultTableModel.getDataVector().clear();
       defaultTableModel.setDataVector(rowData, columnName);
      
      
       //��ʼ�����
       
       TextBorderUtlis Border=new TextBorderUtlis(new Color(222,235,255),3,true);
       jTable.setBorder(Border);
      // JTable2.setTableHeaderColor(jTable,1,new Color(255,255,255));
       JTable2.StyleTable(jTable);
       //�رձ���Զ�������С
       jTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
       //������ӱ��
       jTable.setShowGrid(false);
       jsp=new JScrollPane(jTable){
    	  //���ñ��ߴ�
    	   public Dimension getPreferredSize() {
    	   return new Dimension(735,180);
    	  }
     };
     //jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      jsp.setBackground(new Color(222,235,255));
      jsp.setBorder(Border);
      n.removeAll();
      n.repaint();
      n.updateUI();
      n.add(jsp);
      
     
      //��굥�����ظ����˺�
      jTable.addMouseListener(new MouseAdapter() {
    	  public void mouseClicked(MouseEvent e) {
    		  Row=jTable.getSelectedRow();
    		  Column=jTable.getSelectedColumn();
    		  Mouse=true;
    		  
    		  //ѡ�����˺�
    		 Object value=jTable.getValueAt(Row, 0);
    		Uacnum=value.toString();
    		Object Oldervalue1=jTable.getValueAt(Row, Column);
    		Oldervalue=Oldervalue1.toString();
    		//System.out.println(Oldervalue);
    		//System.out.println(Column);
    	  }
      });
      //�س���ȡ�޸ĺ��ֵ

      ActionMap am2=(ActionMap)UIManager.get("Table.actionMap");
      am2.put("selectNextRowCell", new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			 ENTER=true;
			 Object value1=jTable.getValueAt(Row, Column);
	    	 Newvalue=value1.toString();
	    	//System.out.println(Newvalue);
		}
    	  
      });
     
      jTable.setActionMap(am2);
     
   }
  
}
