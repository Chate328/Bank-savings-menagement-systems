package ���д���������;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
//�����㷨
public class EncryptUtils {
 //����MD5����
 public String encryptToMD5(String info) {
  byte[] digesta = null;
  try {
   // �õ�һ��md5����ϢժҪ
   MessageDigest alga = MessageDigest.getInstance("MD5");
   // ���Ҫ���м���ժҪ����Ϣ
   alga.update(info.getBytes());
   // �õ���ժҪ
   digesta = alga.digest();
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }
  // ��ժҪתΪ�ַ���
  String rs = byte2hex(digesta);
  return rs;
 }
 
 
 
 
  //��������ת��Ϊ16�����ַ���
 
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
 
 /*����
 public static void main(String[] args) {
  EncryptUtils encryptUtils = new EncryptUtils();
  String source = "123456";
  System.out.println("����MD5:" + encryptUtils.encryptToMD5(source));
 
 }*/
}