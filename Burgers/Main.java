import java.util.Scanner;
/**
  *@author Carson Graham
  *Date: 2018-9-19
  *Note: Main is classname because of issues with javac
  */
public class Main{
    public static void main(String[] args){
         double total = 0;
         Scanner scan = new Scanner(System.in);
         final double perHour = 5.15;
         final double leftAfterTaxes = 1 - 0.3; 
         //perHour = perHour*leftAfterTaxes;//would reduce computations if taxes were taken out here instead of every 
         //paycheck
        for(int i = 0;i<4;i++){
           System.out.print("How many hours did you work in week " + i + "? ");
           int hours = scan.nextInt();
           double pay = perHour * hours;
           pay = pay * leftAfterTaxes;
           total+=pay;
           System.out.println("Your take-home pay is $" + pay + "\n");
        }
        System.out.println("Your total pay for the month is $" + total);
        System.out.println("Hope you enjoyed working at Babbage Burgers");
    }
}

/*
[ carson-arch school ]$ javac Main.java;java Main
How many hours did you work in week 0? 35
Your take-home pay is $126.175

How many hours did you work in week 1? 41
Your take-home pay is $147.805

How many hours did you work in week 2? 37
Your take-home pay is $133.385

How many hours did you work in week 3? 45
Your take-home pay is $162.22500000000002

Your total pay for the month is $569.59
Hope you enjoyed working at Babbage Burgers
*/
