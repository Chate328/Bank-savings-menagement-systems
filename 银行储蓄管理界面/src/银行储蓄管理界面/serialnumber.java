package 银行储蓄管理界面;

import java.text.SimpleDateFormat;
import java.util.Date;

public class serialnumber {
	 /**
	     * 获取现在时间
	     * @return返回字符串格式yyyyMMddHHmmss
	     */
	   public static String getStringDate() {
	       Date currentTime = new Date();
	       SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	       String dateString = formatter.format(currentTime);
	       return dateString;
	    }
	   /*
	    * 获取系统当前日期
	    */
	   public static String getStringDay() {
		   Date currentTime=new Date();
		   SimpleDateFormat Day=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String Daystring=Day.format(currentTime);
		   return Daystring;
	   }
	   /**
	    * 由年月日时分秒+3位随机数
	    * 生成流水号
	    * @return
	    */
	   public String  StringGetnum(){
	    String t = getStringDate();
	    int x=(int)(Math.random()*900)+100;
	    String serial = t + x;
	    return serial;
	   }
	   
	   
	/*   //主方法测试
	 public static void main(String[] args) {
	  String m= getStringDay();
	  System.out.println(m);
	 }
	 */
	}