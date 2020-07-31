package 银行储蓄管理界面;

import java.util.List;
import java.util.Stack;
import java.util.Vector;
 

public class RandomCreditCardNumberGenerator {
 
 
 public static final String[] VISA_PREFIX_LIST = new String[] { "6459",
   "6456", "6916", "6532", "6929", "60240071", "6485", "6716", "6" };
 
 public static final String[] MASTERCARD_PREFIX_LIST = new String[] { "61",
   "62", "63", "64", "65" };
 
 public static final String[] AMEX_PREFIX_LIST = new String[] { "34", "37" };
 
 public static final String[] DISCOVER_PREFIX_LIST = new String[] { "6011" };
 
 public static final String[] DINERS_PREFIX_LIST = new String[] { "300",
   "301", "302", "303", "36", "38" };
 
 public static final String[] ENROUTE_PREFIX_LIST = new String[] { "2014",
   "2149" };
 
 public static final String[] JCB_PREFIX_LIST = new String[] { "35" };
 
 public static final String[] VOYAGER_PREFIX_LIST = new String[] { "8699" };
 
 static String strrev(String str) {
  if (str == null)
   return "";
  String revstr = "";
  for (int i = str.length() - 1; i >= 0; i--) {
   revstr += str.charAt(i);
  }
 
  return revstr;
 }
 
 static String completed_number(String prefix, int length) {
 
  String ccnumber = prefix;
 
 
 
  while (ccnumber.length() < (length - 1)) {
   ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
  }
 
 
  String reversedCCnumberString = strrev(ccnumber);
 
  List reversedCCnumberList = new Vector();
  for (int i = 0; i < reversedCCnumberString.length(); i++) {
   reversedCCnumberList.add(new Integer(String
     .valueOf(reversedCCnumberString.charAt(i))));
  }
 
  
 
  int sum = 0;
  int pos = 0;
 
  Integer[] reversedCCnumber = (Integer[]) reversedCCnumberList
    .toArray(new Integer[reversedCCnumberList.size()]);
  while (pos < length - 1) {
 
   int odd = reversedCCnumber[pos] * 2;
   if (odd > 9) {
    odd -= 9;
   }
 
   sum += odd;
 
   if (pos != (length - 2)) {
    sum += reversedCCnumber[pos + 1];
   }
   pos += 2;
  }
 
  
 
  int checkdigit = new Double(
    ((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
  ccnumber += checkdigit;
 
  return ccnumber;
 
 }
 
 public static String[] credit_card_number(String[] prefixList, int length,
   int howMany) {
 
  Stack result = new Stack();
  for (int i = 0; i < howMany; i++) {
   int randomArrayIndex = (int) Math.floor(Math.random()
     * prefixList.length);
   String ccnumber = prefixList[randomArrayIndex];
   result.push(completed_number(ccnumber, length));
  }
 
  return (String[]) result.toArray(new String[result.size()]);
 }
 
 public static String[] generateMasterCardNumbers(int howMany) {
  return credit_card_number(MASTERCARD_PREFIX_LIST, 16, howMany);
 }
 
 public static String generateMasterCardNumber() {
  return credit_card_number(MASTERCARD_PREFIX_LIST, 16, 1)[0];
 }
 
 public static boolean isValidCreditCardNumber(String creditCardNumber) {
  boolean isValid = false;
 
  try {
   String reversedNumber = new StringBuffer(creditCardNumber)
     .reverse().toString();
   int mod10Count = 0;
   for (int i = 0; i < reversedNumber.length(); i++) {
    int augend = Integer.parseInt(String.valueOf(reversedNumber
      .charAt(i)));
    if (((i + 1) % 2) == 0) {
     String productString = String.valueOf(augend * 2);
     augend = 0;
     for (int j = 0; j < productString.length(); j++) {
      augend += Integer.parseInt(String.valueOf(productString
        .charAt(j)));
     }
    }
 
    mod10Count += augend;
   }
 
   if ((mod10Count % 10) == 0) {
    isValid = true;
   }
  } catch (NumberFormatException e) {
  }
 
  return isValid;
 }
 //测试
 //public static void main(String[] args) {
 // System.out.println(get_Bank_account());

 //}
 
 public static String get_Bank_account(){
  int howMany = 0;
  String arg="1";//写几就是出来几个不同的卡号
  try {
   howMany = Integer.parseInt(arg);
  } catch (Exception e) {
   System.err
     .println("Usage error. You need to supply a numeric argument (ex: 500000)");
  }
  String[] creditcardnumbers = generateMasterCardNumbers(howMany);
  String bandcard_NO="";
  
  for (int i = 0; i < creditcardnumbers.length; i++) {
   bandcard_NO=creditcardnumbers[i];
  }
  
  return bandcard_NO;
 }
}

 