package 银行储蓄管理界面;


	 
	import java.awt.Color;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	 
	import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
	import javax.swing.JFrame;
	 
	public class NowTime extends JFrame {
	 
	 
	 private static final long serialVersionUID = 4306803332677233920L;
	 
	 
	 // 设置Timer 1000ms实现一次动作 实际是一个线程
	 public void setTimer(JLabel time) {
	  final JLabel varTime = time;
	  Timer timeAction = new Timer(100, new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	    long timemillis = System.currentTimeMillis();
	    // 转换日期显示格式
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    varTime.setText(df.format(new Date(timemillis)));
	   }
	  });
	  timeAction.start();
	 }
	 
	
	}

