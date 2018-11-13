/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: This doesn't seem like a fun game, but what do i know, I've never played it
  *
  *
  */

import java.util.Scanner;

public class Craps {
    private static int roll1;
    private static int roll2;
    private static int set = -1;
    private static int total;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("ROLL #1");
        roll();
        set = total;
        System.out.println("Your set point is " + set);
        if(total == 7 || total == 11){
            System.out.println("You win!");
            return;
        }
        if(total == 2 || total == 12){
            System.out.println("You lose");
        }
        for(int i = 2;i<=5;i++) {
            System.out.println("ROLL #" + i);
            roll();
            if (total == set) {
                System.out.println("You win!");
                return;
            } else if (total == 7 || total == 11) {
                System.out.println("You lose");
                return;
            }else{
                System.out.println("Press return to continue");
                scan.nextLine();
            }
        }
    }

    private static void roll() {
        roll1 = (int) (Math.random()*6)+1;
        roll2 = (int) (Math.random()*6)+1;
        total = roll1+roll2;
        System.out.println("You rolled a " + roll1 + " and a " + roll2);
    }

}
