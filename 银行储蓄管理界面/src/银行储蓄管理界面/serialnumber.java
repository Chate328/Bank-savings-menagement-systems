package ���д���������;

import java.text.SimpleDateFormat;
import java.util.Date;

public class serialnumber {
	 /**
	     * ��ȡ����ʱ��
	     * @return�����ַ�����ʽyyyyMMddHHmmss
	     */
	   public static String getStringDate() {
	       Date currentTime = new Date();
	       SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	       String dateString = formatter.format(currentTime);
	       return dateString;
	    }
	   /*
	    * ��ȡϵͳ��ǰ����
	    */
	   public static String getStringDay() {
		   Date currentTime=new Date();
		   SimpleDateFormat Day=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String Daystring=Day.format(currentTime);
		   return Daystring;
	   }
	   /**
	    * ��������ʱ����+3λ�����
	    * ������ˮ��
	    * @return
	    */
	   public String  StringGetnum(){
	    String t = getStringDate();
	    int x=(int)(Math.random()*900)+100;
	    String serial = t + x;
	    return serial;
	   }
	   
	   
	/*   //����������
	 public static void main(String[] args) {
	  String m= getStringDay();
	  System.out.println(m);
	 }
	 */
	}