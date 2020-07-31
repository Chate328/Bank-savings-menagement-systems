package 银行储蓄管理界面;

import java.math.BigDecimal;

public class Bank {

	 BigDecimal Money=null ,interest=null;
	 public BigDecimal computerInterest(BigDecimal n,BigDecimal interestRate,BigDecimal savedMoney){
	//  interest=n*interestRate*savedMoney;
	  Money=interestRate.multiply(savedMoney);
	  interest=Money.multiply(n);
	  return interest;
	}
}
