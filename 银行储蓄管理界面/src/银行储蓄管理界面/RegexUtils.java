package ���д���������;



import java.util.regex.Pattern;
 
/**
 * Created with IDEA
 * author:Dingsheng Huang
 * Date:2019/7/2
 * Time:����6:51
 */
public class RegexUtils {
 
    /**
     *  �����ֻ��ţ��򵥣�, 1��ͷ��10λ���ּ���.
     * @param in
     * @return
     */
    public static boolean validateMobilePhone(String in) {
        Pattern pattern = Pattern.compile("^((147)|(17[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        return pattern.matcher(in).matches();
    }
   
    
}