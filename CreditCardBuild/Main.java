import java.util.Scanner;

/**
  *@author Carson Graham
  *Date: 2018-9-19
  *Notes: final payment could have been a bit cleaner
  */
public class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the monthly payment:" );
    int monthly = scan.nextInt();
    double balance = 1000;
    double cost = 0.015;
    double totalPayment = 0;
    int month = 0;
    while(true){
      month++;
      balance+= balance*0.015;
      if(balance<monthly){
        totalPayment+=balance;
        balance = 0;
      }else{
        balance-=monthly;
        totalPayment+=monthly;
      }
      System.out.println("Month: " + month + "     Balance: " + balance + "     Total Payments:" + totalPayment);
      if(balance == 0)break;
    }
    System.out.println("Final payment in month " + month + ":"  + totalPayment % monthly);
  }
}

/*
[ carson-arch school ]$ java Main
Enter the monthly payment:100
Month: 1     Balance: 915.0     Total Payments:100.0
Month: 2     Balance: 828.725     Total Payments:200.0
Month: 3     Balance: 741.155875     Total Payments:300.0
Month: 4     Balance: 652.273213125     Total Payments:400.0
Month: 5     Balance: 562.057311321875     Total Payments:500.0
Month: 6     Balance: 470.4881709917031     Total Payments:600.0
Month: 7     Balance: 377.54549355657866     Total Payments:700.0
Month: 8     Balance: 283.20867595992735     Total Payments:800.0
Month: 9     Balance: 187.4568060993263     Total Payments:900.0
Month: 10     Balance: 90.26865819081618     Total Payments:1000.0
Month: 11     Balance: 0.0     Total Payments:1091.6226880636784
Final payment in month 11:91.62268806367842
*/
