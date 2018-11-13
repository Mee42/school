package com.carson;

import java.util.Scanner;

/**
 * @author Carson Graham
 * Date: 2018-9-18
 */
public class Lock {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int first = (int)(Math.random()*50);
        int second = (int)(Math.random()*50);
        int third = (int)(Math.random()*50);//0 to 49 inclusive

        System.out.println(first + "," + second + "," + third);

        System.out.println(openLock(first,second,third)?"The lock has been opened":"The lock will not open");
        scan.close();
    }

    private static boolean openLock(int first, int second, int third) {
        int firstGuess = read("first");
        int secondGuess = read("second");
        int thirdGuess = read("last");
        scan.close();
        return works(first,firstGuess) && works(second, secondGuess) && works(third,thirdGuess);
    }


    private static boolean works(int real, int guess) {
        int apart = Math.abs(real - guess);
        if(apart <= 3){
            return true;
        }
        if((real == 48 && guess <= 2) ||
            (real == 49 && guess <= 3) ||
            (real == 47 && guess <= 1) ||
            (guess == 48 && real <= 2) ||
            (guess == 49 && real <= 3) ||
            (guess == 47 && real <= 1))return true;
        //hardcoded to get over the fact that 49 is less then three away from 1. combo locks are 0-49
        return false;
    }

    private static int read(String name) {
        int i;
        while(true){
            System.out.print(name + " number:");
            try {
                i = Integer.parseInt(scan.nextLine());
            }catch(NumberFormatException e){
                System.err.print("error: number format exception  ");
                try {Thread.sleep(10);} catch (InterruptedException e1) {e1.printStackTrace();}
                //there have been problems with err printing after the next out. this fixes those^
                continue;
            }
            if(i < 0 || i > 49){
                System.err.print("error:         out of bounds    ");
                try {Thread.sleep(10);} catch (InterruptedException e1) {e1.printStackTrace();}
                //see about for ^
                continue;
            }else{
                break;
            }
        }
        return i;
    }
}
/*
45,40,40
first number:48
second number:37
last number:41
The lock has been opened


1,4,35
first number:1
second number:4
last number:1
The lock will not open



 */
