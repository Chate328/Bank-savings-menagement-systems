package ���д���������;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelForUserselect {
	JButton HQ,DQ,HQMX,DQMX,ZH;
	JPanel m,w;
	TextBorderUtlis Border2,Border1,Border3;
	DateChooserJButton button,button2;
	JComboBox JC;
	public static String User_id;
	JLabel J1,J2;
	JPanelForUserselect(JPanel n,JPanel m,String str){
		this.w=m;
		this.m=n;
		this.User_id=str;
		HQ=new JButton();
		
		HQMX=new JButton("���ڴ�ȡ��¼");
		ZH=new JButton("ת�˼�¼");
		DQMX=new JButton("���ڴ�ȡ��¼");
		button=new DateChooserJButton();
		button2=new DateChooserJButton();
		JC=new JComboBox();
		JC.addItem("���ڴ���¼");
		JC.addItem("���ڴ���¼");
		JC.addItem("ת����ϸ��¼");
		JC.addItem("���ڴ�ȡ��¼");
		JC.addItem("���ڴ�ȡ��¼");
		Border2=new TextBorderUtlis(new Color(255,255,255),1,true);
		Border1=new TextBorderUtlis(new Color(0,191,255),1,true);
		Border3=new TextBorderUtlis(new Color(255,255,255),1,true);
		J1=new JLabel("��ֹ����:");
		J2=new JLabel("--");
	}
	public void setUserSelect() {
		m.add(J1);
		J1.setBounds(160, 30, 100, 25);
		m.add(J2);
		J2.setBounds(350, 25, 20, 25);
		
		m.add(JC);
		JC.setBounds(0,0, 105, 23);
		JC.setBorder(Border2);
		JC.setBackground(Color.white);
		m.add(button);
		button.setBounds(220, 30, 130, 20);
		button.setBorder(Border1);
		
		button.setBackground(Color.white);
		
		m.add(button2);
		button2.setBounds(360,30,130,20);
		button2.setBorder(Border1);
		
		button2.setBackground(Color.white);
		m.add(HQ);
		HQ.setBounds(550,30,40, 25);
		ImageIcon Iconu = new ImageIcon("src/images/CX.jpg");
		HQ.setIcon(Iconu);
		HQ.setBorder(Border2);
		HQ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str=JC.getSelectedItem().toString().trim();
				String start=button.getText().toString();
				String end=button2.getText().toString();
				if(str.equals("���ڴ���¼")) {
					UserforHQ U=new UserforHQ(User_id);
					U.ActionListenerforHQ(w, start, end);
				}else if(str.equals("���ڴ���¼")) {
					UserForDQ U=new UserForDQ(User_id);
					U.ActionListenerforDQ(w, start, end);
				}else if(str.equals("ת����ϸ��¼")) {
					UserforZH U=new UserforZH(User_id);
					U.ActionListenerforZH(w, start, end);
				}else if(str.equals("���ڴ�ȡ��¼")) {
					UserforDQMX U=new UserforDQMX(User_id);
					U.ActionListenerforDQMX(w, start, end);
				}else if(str.equals("���ڴ�ȡ��¼")){
					UserforHQMX U=new UserforHQMX(User_id);
					U.ActionListenerforDQMX(w, start, end);
				}
			}	
		});
		
		
		
		
		
	}
}
