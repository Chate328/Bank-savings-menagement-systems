package 银行储蓄管理界面;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JPanelForSQL {
	JLabel JTextOne;
	JButton JB,JBu;
	TextBorderUtlis Border,BorderB;
	JTextArea JA;
	public static int m;
	JPanelForSQL(int n){
		this.m=n;
		JTextOne=new JLabel("数据备份");
		JB=new JButton("备份");
		JBu=new JButton("恢复");
		JA=new JTextArea();
		
		 Border=new TextBorderUtlis(new Color(222,235,255),2,true);
		 BorderB=new TextBorderUtlis(new Color(222,235,255),2,true);
	}
	public void setSQL(JPanel n) {
		n.add(JTextOne);
		JTextOne.setBounds(0, 10, 100, 25);
		JTextOne.setForeground(Color.blue);
		
		n.add(JB);
		JB.setBounds(50, 300, 70, 25);
		JB.setBorder(Border);
		
		n.add(JA);
		JA.setBounds(5, 40, 500, 200);
		JA.setBorder(Border);
		
		JB.setBackground(new Color(222,235,255));
		
		JB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(m==1) {
					DeleteFileUtil delete=new DeleteFileUtil();
				 String fileName = "E:\\SQL sever\\MSSQL13.MSSQLSERVER\\MSSQL\\Backup\\yhgxgl20200613.bak";
			     DeleteFileUtil.deleteFile(fileName);

				}
				
				JDBC J=new JDBC(m);
				String sql="{call dbo.p_BackupDB}";
				int rs = J.excuteData(sql);
				if(1==rs) {
					
					serialnumber se=new serialnumber();
					String Str=se.getStringDay();
					String meassage="backup database yhgxgl to disk='E:\\SQL sever\\MSSQL13.MSSQLSERVER\\MSSQL\\Backup'\r\n" + 
							"已为数据库 'yhgxgl'，文件 'yhgxgl'备份完成! \r\n" + 
							"已为数据库 'yhgxgl'，文件 'yhgxgl_log'备份完成!\r\n" + 
							"BACKUP DATABASE 成功处理任务\r\n" + 
							"\r\n" + 
							"完成时间:"+Str;
					JA.setText(meassage);
				}else {
					ShowMessage fail=new ShowMessage();
					fail.init("拒绝备份请求!");
				}
			}
			
		});
		
		n.add(JBu);
		JBu.setBounds(200, 300, 70, 25);
		JBu.setBorder(Border);
		JBu.setBackground(new Color(222,235,255));
		JBu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					JDBC Z=new JDBC(m);
					String sql="{call dbo.p_RestoreDB}";
					int rs = Z.excuteData(sql);
					if(1==rs) {
						
						
						serialnumber se=new serialnumber();
						String Str=se.getStringDay();
						String meassage="已为数据库 'yhgxgl'，文件 'yhgxgl'还原! \r\n" + 
								"已为数据库 'yhgxgl'，文件 'yhgxgl_log'还原! \r\n" + 
								"RESTORE DATABASE 成功处理任务!\r\n" + 
								"\r\n" + 
								"完成时间: " + Str;	
						JA.setText(meassage);
					
				
				}else {
					ShowMessage fail=new ShowMessage();
					fail.init("拒绝恢复请求!");
				}
			}
			
		});
	}
}
