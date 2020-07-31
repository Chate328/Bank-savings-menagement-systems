package 银行储蓄管理界面;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPeanlForLI {
	JDBCDQ jdbcdq ;
	public static int W;
	JPeanlForLI(int n){
		this.W=n;
		jdbcdq = new JDBCDQ(W);
		
	}
	
	 public void LI(JPanel n,JPanel m) {
		   JLabel JP1 = new JLabel("利率调整");
		   TextBorderUtlis Border5=new TextBorderUtlis(new Color(255,255,255),1,true);
		   n.add(JP1);
		   JP1.setBounds(2,2,100,20);
		   JP1.setForeground(Color.BLUE);
		   
		   JComboBox Jc=new JComboBox();
		   n.add(Jc);
		   TextBorderUtlis Border=new TextBorderUtlis(new Color(0,191,255),1,true);
		   Jc.setBounds(100, 420,80, 25);
		   Jc.addItem("活期存款");
		   Jc.addItem("定期三个月");
		   Jc.addItem("定期半年");
		   Jc.addItem("定期一年");
		   Jc.addItem("定期两年");
		   Jc.addItem("定期三年");
		   Jc.addItem("定期五年");
		   Jc.setBorder(Border);
		   Jc.setBackground(Color.white);
		   
		   //输入框 
		   JComboBox JT=new  JComboBox();
		   n.add(JT);
		   JT.addItem("0.0025");
		   JT.addItem("0.0026");
		   JT.addItem("0.0027");
		   JT.addItem("0.0028");
		   JT.addItem("0.0029");
		   JT.addItem("0.0030");
		   JT.addItem("0.0031");
		   JT.addItem("0.0032");
		   JT.addItem("0.0033");
		   JT.addItem("0.0034");
		   JT.addItem("0.0035");
		   JT.addItem("0.0150");
		   JT.addItem("0.0151");
		   JT.addItem("0.0152");
		   JT.addItem("0.0153");
		   JT.addItem("0.0154");
		   JT.addItem("0.0155");
		   JT.addItem("0.0156");
		   JT.addItem("0.0157");
		   JT.addItem("0.0158");
		   JT.addItem("0.0159");
		   JT.addItem("0.0160");
		   JT.addItem("0.0170");
		   JT.addItem("0.0171");
		   JT.addItem("0.0172");
		   JT.addItem("0.0173");
		   JT.addItem("0.0174");
		   JT.addItem("0.0175");
		   JT.addItem("0.0176");
		   JT.addItem("0.0177");
		   JT.addItem("0.0224");
		   JT.addItem("0.0225");
		   JT.addItem("0.0226");
		   JT.addItem("0.0227");
		   JT.addItem("0.0275");
		   JT.addItem("0.0276");
		   JT.addItem("0.0277");
		   JT.setBounds(260,420,70,25);
		   JT.setBorder(Border);
		   JT.setBackground(Color.white);
		   
		   JButton commit=new JButton("提交更新");
		   n.add(commit);
		   commit.setBounds(410, 420, 70, 25);
		   commit.setBorder(Border5);
		   commit.setBackground(new Color(222,235,255));
		   commit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String Lproject=Jc.getSelectedItem().toString().trim();
				String rate=JT.getSelectedItem().toString().trim();
				
			
				String sql="UPDATE yhcxgl_LX SET Limplement='"+rate+"' WHERE Lproject='"+Lproject+"'";
				int result=jdbcdq.excuteData(sql);
				if(1==result) {
					ShowMessage success=new  ShowMessage();
					success.successW("更新成功!");
				}else {
					ShowMessage fail=new  ShowMessage();
					fail.init("拒绝更改!");
				}
			}
			   
		   });
		   
		   JButton CXLI=new JButton("刷新表格");
		   n.add(CXLI);
		   CXLI.setBounds(560,420, 70, 25);
		   CXLI.setBackground(new Color(222,235,255));
		   CXLI.setBorder(Border5);
		   CXLI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				LXB(m) ;
				
			}
			   
		   });
		   
		   
		   
		   
	   }
	 public void LXB(JPanel m) {
	 	 List<String> columnZ=new ArrayList<>(Arrays.asList("项目","基准利率","执行利率"));
	     List<List<String>> rowZ=new ArrayList<>();
	   
		 String sql="SELECT * FROM yhcxgl_LX order by Lproject desc ";
		 ResultSet rsLI = jdbcdq.slectData(sql);
		  try {
				while(rsLI.next()){
					String Lproject =rsLI.getString(1);
					BigDecimal Lrate=rsLI.getBigDecimal(2);
					BigDecimal Limplement=rsLI.getBigDecimal(3);
					
					List<String> row=new ArrayList<>();
						row.add(Lproject);
						row.add(Lrate.toString());
						row.add(Limplement.toString());
						rowZ.add(row);
					
						
					}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  Table LXtbale=new Table();
		    LXtbale.MyTableL(columnZ,rowZ," ",m);
			   
		   }
  
}
