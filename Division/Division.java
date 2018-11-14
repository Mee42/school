package com.carson;

import java.util.Scanner;
/**
  *@author carson graham
  *Notes: easy swaping. would be interesting to think of a solution that
  *didn't need swaping
  */
public class Division {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("A:");
        int a = scan.nextInt();
        System.out.print("B:");
        int b = scan.nextInt();
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println((a / b) + "r" + (a%b));
        scan.close();
    }
}
