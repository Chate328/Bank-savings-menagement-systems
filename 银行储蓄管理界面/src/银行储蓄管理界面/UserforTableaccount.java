package ���д���������;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserforTableaccount {
	DefaultTableModel defaultTableModel;
	 public void MyTableL(List<String> columns,List<List<String>> rows,String title,JPanel n){
		   //���ñ����ʽ
		   
		   TableStyleForAcnum JTable2=new TableStyleForAcnum();
		   JTable jTable;
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
	       defaultTableModel = new DefaultTableModel(rowData,columnName);
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
	    	   return new Dimension(730,100);
	    	  }
	     };
	     
	      jsp.setBackground(new Color(255,255,255));
	      jsp.setBorder(Border);
	      n.removeAll();
	      n.repaint();
	      n.updateUI();
	      n.add(jsp);
	   
	     
	      
	 }
	 
}
