package ���д���������;


	 
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
	 
	 
	 // ����Timer 1000msʵ��һ�ζ��� ʵ����һ���߳�
	 public void setTimer(JLabel time) {
	  final JLabel varTime = time;
	  Timer timeAction = new Timer(100, new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	    long timemillis = System.currentTimeMillis();
	    // ת��������ʾ��ʽ
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    varTime.setText(df.format(new Date(timemillis)));
	   }
	  });
	  timeAction.start();
	 }
	 
	
	}

