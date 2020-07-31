package 银行储蓄管理界面;



import java.util.regex.Pattern;
 
/**
 * Created with IDEA
 * author:Dingsheng Huang
 * Date:2019/7/2
 * Time:下午6:51
 */
public class RegexUtils {
 
    /**
     *  正则：手机号（简单）, 1字头＋10位数字即可.
     * @param in
     * @return
     */
    public static boolean validateMobilePhone(String in) {
        Pattern pattern = Pattern.compile("^((147)|(17[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        return pattern.matcher(in).matches();
    }
   
    
}