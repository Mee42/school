package com.carson;

import java.util.Scanner;

public class Rectangle {//class name should be a singular noun
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the width:");
        int width = scan.nextInt();
        System.out.print("Enter the length:");
        int length= scan.nextInt();
        int area = width*length;
        int perimeter = width+width+length+length;
        System.out.println();//to match example
        System.out.println("The rectangle's area is " + area);
        System.out.println("The rectangle's perimeter is " + perimeter);
        scan.close();
    }
}
