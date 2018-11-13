package com.carson;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
  * @author Carson Graham
  * Date: 2018-9-16
  * Notes: Decimal Formating should have been done in the findPayment method
  */
public class LoanPayment {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter amount to be borrowed:");
        double amount = getDouble();
        System.out.print("Enter annual interest rate as a percent:");
        double rate = getDouble();
        System.out.print("Enter the length of the loan in years:");
        int years = getInt();
        System.out.println("Monthly payment: $" + new DecimalFormat("0.00").format(findPayment(amount,rate,years)));
    }

    private static double findPayment(double amount, double rate, int years) {
        double value = Math.pow((rate/1200)+1,years*12);
        value =  amount * (rate/1200) * (value / (value-1));
        return value;
    }

    //997.5 per year
    //


    private static int getInt() {
        String in = scan.nextLine();
        while(true){
            try{
                int i = Integer.valueOf(in);
                if(i > 0 && i <= 100_000)
                    return i;
            }catch (NumberFormatException e){}
            //if its not a integer, or if it does not pass the bounds for doubles, it will go to this line
            System.err.print("Error. Try again:");
            in = scan.nextLine();
        }
    }
    //use getInt instead of getAmount and getRate to avoid duplicate code
    private static double getDouble() {
        String in = scan.nextLine();
        while(true){
            try{
                double d = Double.valueOf(in);
                if(d > 0 && d <= 100_000)
                    return d;
            }catch (NumberFormatException e){}
            //if its not a double, or if it does not pass the bounds for doubles, it will go to this line
            System.err.print("Error. Try again:");
            in = scan.nextLine();
        }
    }
}


