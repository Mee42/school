package com.carson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dispenser {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        if(args.length == 1 && args[0].equals("all")){
            testMain(args);//to run testMain from terminal
        }
        while(true) {//loop
            System.out.print("price (cents):");
            int cost = scan.nextInt();
            int due = 100 - cost;
            int quarters = due / 25;
            due = due % 25;

            int dimes = due / 10;
            due = due % 10;

            int nickels = due / 5;
            due = due % 5;

            int pennys = due;
            System.out.println(generateStringOne(quarters, dimes, nickels, pennys));
        }
    }
    //this was a horrible idea. However, it returns the exact same output as the method below(tested) with 7 times less code, so I'm keeping it
    //this is probably a lot faster as well becuase there is no object creation/manipualtion, just comparison operators and string concatination, but we are running it so few times the difference is undetectable
    private static String generateStringOne(int quarters, int dimes, int nickels, int pennies) {
        return  (quarters+dimes+nickels+pennies == 0)?"nothing":
                ((quarters != 0)?((quarters == 1)?"1 quarter":quarters + " quarters") + ((dimes+nickels+pennies!=0)?" and ":""):"") +
                ((dimes != 0)?(((dimes == 1)?"1 dime":dimes + " dimes") + ((nickels+pennies!=0)?" and ":"")):"") +
                ((nickels != 0)?(((nickels == 1)?"1 nickel" :nickels + " nickels") + ((pennies!=0)?" and ":"")):"") +
                ((pennies != 0)?((pennies == 1)?"1 penny":pennies + " pennies"):"");
    }

    //a cleaner alternative to the above method
    private static String generateStringTwo(int quarters, int dimes, int nickels, int pennies){
        List<String> strs = new ArrayList<>();
        if(quarters != 0){
            if(quarters == 1){
                strs.add("1 quarter");
            }else{
                strs.add(quarters + " quarters");
            }
        }
        if(dimes != 0){
            if(dimes == 1){
                strs.add("1 dime");
            }else{
                strs.add(dimes + " dimes");
            }
        }
        if(nickels != 0){
            if(nickels == 1){
                strs.add("1 nickel");
            }else{
                strs.add(nickels + " nickels");
            }
        }
        if(pennies != 0){
            if(pennies == 1){
                strs.add("1 penny");
            }else{
                strs.add(pennies + " pennies");
            }
        }
        String all = "";
        for(int i = 0;i<strs.size();i++){
            all+=strs.get(i);
            if(i + 1 != strs.size()){
                all+=" and ";
            }
        }
        return all;
    }


    //for testing String generation. accepts String[] so I can run it as the main method easily
    public static void testMain(String args[]){
        for(int i = 0;i<101;i++){
            //runs through all coin configurations, 0c to 100c
            int due = i;
            int quarters = due / 25;
            due = due % 25;

            int dimes= due / 10;
            due = due % 10;

            int nickels = due / 5;
            due = due % 5;
            int pennys = due;
            
            System.out.println(generateStringOne(quarters,dimes,nickels,pennys));
        }
    }

    /*
     output:
        price (cents):1
        3 quarters and 2 dimes and 4 pennies
        price (cents):22
        3 quarters and 3 pennies
        price (cents):75
        1 quarter
        price (cents):80
        2 dimes
        price (cents):95
        1 nickel
        price (cents):99
        1 penny
        price (cents):98
        2 pennies  //note the plural/singular handling
     */
}
