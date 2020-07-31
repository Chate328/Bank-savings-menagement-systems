package 银行储蓄管理界面;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
//加密算法
public class EncryptUtils {
 //进行MD5加密
 public String encryptToMD5(String info) {
  byte[] digesta = null;
  try {
   // 得到一个md5的消息摘要
   MessageDigest alga = MessageDigest.getInstance("MD5");
   // 添加要进行计算摘要的信息
   alga.update(info.getBytes());
   // 得到该摘要
   digesta = alga.digest();
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }
  // 将摘要转为字符串
  String rs = byte2hex(digesta);
  return rs;
 }
 
 
 
 
  //将二进制转化为16进制字符串
 
  //@return String
  
 public static String byte2hex(byte[] b) {
  String hs = "";
  String stmp = "";
  for (int n = 0; n < b.length; n++) {
   stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
   if (stmp.length() == 1) {
    hs = hs + "0" + stmp;
   } else {
    hs = hs + stmp;
   }
  }
  return hs.toUpperCase();
 }
 
 /*测试
 public static void main(String[] args) {
  EncryptUtils encryptUtils = new EncryptUtils();
  String source = "123456";
  System.out.println("经过MD5:" + encryptUtils.encryptToMD5(source));
 
 }*/
}