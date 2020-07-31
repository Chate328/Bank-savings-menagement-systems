package 银行储蓄管理界面;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class TableStyleForAcnum {
	  public  void StyleTable(JTable table) {
	        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(){
	            /**serialVersionUID*/
	            private static final long serialVersionUID = 1234579841267L;

	            @Override
	            public Component getTableCellRendererComponent(JTable table,
	                    Object value, boolean isSelected,boolean hasFocus,
	                    int row, int column) {
	                if(row%2==0){
	                    setBackground(new Color(222,235,255));
	                }else{
	                    setBackground(new Color(222,235,255));
	                }

	                setHorizontalAlignment(JLabel.CENTER);// 表格内容居中
	                ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
	                .setHorizontalAlignment(DefaultTableCellRenderer.CENTER);// 列头内容居中
	                 //table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 13));
	                 table.getTableHeader().setResizingAllowed(true);
	                 table.setRowHeight(25);//设置行高

	                return super.getTableCellRendererComponent(table, value, 
	                        isSelected, hasFocus, row, column);
	            }
	        };

	        Dimension size = table.getTableHeader().getPreferredSize();
	        size.height = 25;//设置新的表头高度32
	        table.getTableHeader().setPreferredSize(size);

	        for (int i = 0; i < table.getColumnCount(); i++) {
	            TableColumn col = table.getColumn(
	                    table.getColumnName(i));
	            col.setCellRenderer(renderer);
	            setTableHeaderColor(table,i,new Color(222, 235, 255));
	        }

	       
	    }

	   
	    public static void setTableHeaderColor(JTable table, int columnIndex, Color c) {
	        TableColumn column = table.getTableHeader().getColumnModel()
	                .getColumn(columnIndex);
	        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
	            /** serialVersionUID */
	            private static final long serialVersionUID = 43279841267L;

	            @Override
	            public Component getTableCellRendererComponent(JTable table, 
	                    Object value, boolean isSelected,boolean hasFocus,
	                    int row, int column) {

	                setHorizontalAlignment(JLabel.CENTER);// 表格内容居中
	                ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer())
	                        .setHorizontalAlignment(DefaultTableCellRenderer.CENTER);// 列头内容居中

	                return super.getTableCellRendererComponent(table, value, 
	                        isSelected, hasFocus, row, column);
	            }
	        };
	        cellRenderer.setBackground(c);
	        column.setHeaderRenderer(cellRenderer);
	    }
}
