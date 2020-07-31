package ���д���������;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class JDBCJPanel extends JFrame{
		JPanel J1,J2;
		JComboBox JC;
		JTextField JT;
		JTable jTable;
		public JButton JB1,JB2,JB3;
		public  static int Row,Column;
		public static boolean Mouse=false,ENTER=false;
		public static String Oldervalue,Newvalue;
			JDBCJPanel(){
				setTitle("��9���ϻ�����");
		        setSize(700,450);
		        setResizable(false);
		        setLocationRelativeTo(null);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setVisible(true);
		        Toolkit took =Toolkit.getDefaultToolkit();
				Image img = took.getImage("src/images/BT.jpeg");
				setIconImage(img);
				setLayout(null);
				
				add(J2=new JPanel());
				add(J1=new JPanel(null));
				TextBorderUtlis Border = new TextBorderUtlis(new Color(0,191,255),1,true);
				TextBorderUtlis BorderA = new TextBorderUtlis(new Color(255,255,255),1,true);
				TextBorderUtlis BorderB = new TextBorderUtlis(new Color(222,235,255),1,true);
				JT=new JTextField();
				JB1=new JButton("¼��");
				J1.add(JB1);
				JB1.setBounds(230, 370, 60, 25);
				JB1.setBackground(new Color(222,235,255));
				JB1.setBorder(BorderB);
				JB1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JDBCDQ jdbcdq=new JDBCDQ(1);
						if(Mouse&&ENTER) {
							
								Object value=jTable.getValueAt(Row, 0);
						    	
						    	 
						    	 Object value1=jTable.getValueAt(Row, 1);
						    	
						    	 
						    	 Object value2=jTable.getValueAt(Row, 2);
						    	
						    	 
						    	 Object value3=jTable.getValueAt(Row, 4);
						    	 
						    	 Object value4=jTable.getValueAt(Row, 3);
						    	  	 
						if(value!=null) {
							 String Sno=value.toString();
							 String Sname=value1.toString();
							 String sex=value2.toString();
							 String Sdept=value3.toString(); 
							 String Sage=value4.toString();
							 String sql="insert into S values('"+Sno+"','"+Sname+"','"+sex+"','"+Sage+"','"+Sdept+"')";
							 int Result=jdbcdq.excuteData(sql);
							 if(Result==1) {
								 ShowMessage success=new ShowMessage();
									success.successW("¼��ɹ�!");
							 }else {
								 ShowMessage Facnum=new ShowMessage();
									Facnum.init("¼��ʧ��!");
							 }
						}else {
							ShowMessage Facnum=new ShowMessage();
							Facnum.init("�뽫��Ϣ��д����!");
						}
							
					    	 
					    	 
					}else {
						ShowMessage Facnum=new ShowMessage();
						Facnum.init("δд������");
					}
					}
					
				});
				
				JB2=new JButton("�޸�");
				J1.add(JB2);
				JB2.setBounds(330, 370, 60, 25);
				JB2.setBackground(new Color(222,235,255));
				JB2.setBorder(BorderB);
				JB2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						JDBCDQ jdbcdq=new JDBCDQ(2);
						if(Mouse&&ENTER) {
							if(Newvalue.equals(Oldervalue)) {
								ShowMessage Facnum=new ShowMessage();
								Facnum.init("δ�޸�����");

							}else {
								if(Column==1) {
									
								}
							}
					}
						
					}
				});
				
				JB3=new JButton("ɾ��");
				J1.add(JB3);
				JB3.setBounds(430, 370, 60, 25);
				JB3.setBackground(new Color(222,235,255));
				JB3.setBorder(BorderB);
				JB3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(Mouse&&ENTER) {
							JDBCDQ jdbcdq=new JDBCDQ(1);
							Object value=jTable.getValueAt(Row, 0);
							String Sno=value.toString();
							 String sql="DELETE FROM S WHERE Sno='"+Sno+"'";
							 int Result=jdbcdq.excuteData(sql);
							 if(Result==1) {
								 ShowMessage success=new ShowMessage();
									success.successW("ɾ�����!");
							 }else {
								 ShowMessage Facnum=new ShowMessage();
									Facnum.init("ɾ��ʧ��!");
							 }
						}else {
							ShowMessage Facnum=new ShowMessage();
							Facnum.init("δѡ���ֶ�");
						}		
					}	
				});
				
				J1.setBackground(Color.white);
				J1.setBounds(0, 0, 700, 500);
				J2.setBounds(0, 100, 700, 300);
				J2.setBackground(Color.white);
				J2.setBounds(0, 50, 700, 290);
				JC=new JComboBox();
				J1.add(JC);
				JC.setBounds(100, 10, 80, 22);
				
				JC.setBorder(Border);
				JC.setBackground(Color.white);
				JC.addItem("ѧ��");
				JC.addItem("ѧ������");
				JC.addItem("ϵ��");
				
				
				J1.add(JT);
				JT.setBounds(250, 10, 200, 25);
				JT.setBorder(Border);
				
				JButton J=new JButton();
				J1.add(J);
				J.setBounds(510, 10, 40, 25);
				ImageIcon Iconu = new ImageIcon("src/images/CX.jpg");
				J.setIcon(Iconu);
				J.setBorder(BorderA);
				J.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						List<String> columnZ=new ArrayList<>(Arrays.asList("ѧ��","����","�Ա�","����","ϵ��"));
					       List<List<String>> rowZ=new ArrayList<>();
						JDBCDQ jdbcdq = new JDBCDQ(1);
						   String str=JC.getSelectedItem().toString().trim();
						   String sql=null;
						   String strPLUS=JT.getText()+"%";
						   if(str.equals("ѧ��")) {
							   sql="SELECT * FROM S WHERE Sno like '"+strPLUS+"'";
						   }else if(str.equals("ѧ������")){
							   sql="SELECT * FROM S WHERE Sname like '"+strPLUS+"'";
						   }else if(str.equals("ϵ��")){
							   sql="SELECT * FROM S WHERE Sdept like '"+strPLUS+"'";
						   }
						  
						   ResultSet rsZH = jdbcdq.slectData(sql);
						  
							try {
								while(rsZH.next()){
									String Sno =rsZH.getString(1);
									String Sname=rsZH.getString(2);
									String Sex=rsZH.getString(3);
									Integer Sage=rsZH.getInt(4);
									String Sdept=rsZH.getString(5);
									List<String> row=new ArrayList<>();
									row.add(Sno);
									row.add(Sname);
									row.add(Sex);
									row.add(Sage.toString());
									row.add(Sdept);
									rowZ.add(row);
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							MyTable(columnZ,rowZ," ",J2);
					}
					
				});
				
			}
			public static void main(String[] args) {
				new JDBCJPanel();
			}
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
			       Vector<String[]> dataVector=new Vector<String[]>();
				   defaultTableModel.addRow(dataVector);//��ӿհ���
			       
			      
			      
					
					
			      
			       //��ʼ�����
			       
			       TextBorderUtlis Border=new TextBorderUtlis(new Color(255,255,255),3,true);
			       jTable.setBorder(Border);
			       TableStyleUI JTable2=new TableStyleUI();
			       JTable2.setTableHeaderColor(jTable,1,new Color(255,255,255));
			       JTable2.StyleTable(jTable);
			       //�رձ���Զ�������С
			       //jTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			       //������ӱ��
			       jTable.setShowGrid(false);
			       jsp=new JScrollPane(jTable){
			    	  //���ñ��ߴ�
			    	   public Dimension getPreferredSize() {
			    	   return new Dimension(700,290);
			    	  }
			     };
			    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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
			    		 if(value!=null) {
			    			String Sno=value.toString();
			    		 }
			    		
			    		Object Oldervalue1=jTable.getValueAt(Row, Column);
			    		//Oldervalue=Oldervalue1.toString();
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
						 if(value1!=null) {
							 Newvalue=value1.toString();
						 }
				    
				    	//System.out.println(Newvalue);
					}
			    	  
			      });
			      //�Զ�����
			      ActionMap am3=(ActionMap)UIManager.get("Table.actionMap");
			     am3.put("selectNextRow",new AbstractAction(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
						int count=jTable.getRowCount();//���������
						jTable.requestFocus();
						jTable.setRowSelectionInterval(count-1, count-1);//���һ�л�ý���
					}
			    	 
			     });
			      jTable.setActionMap(am2);
			      jTable.setActionMap(am3);
			     
			   }
			  
}
