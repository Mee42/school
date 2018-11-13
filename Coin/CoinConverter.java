/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: lots of code could be copied from the Dispenser lab back in first quarter
  *
  */
import java.util.Scanner;

public class CoinConverter {
    private final int quarters,dimes,nickels,pennies;
    public CoinConverter(int totalCents){
        quarters = totalCents / 25;
        totalCents = totalCents % 25;
        dimes = totalCents / 10;
        totalCents = totalCents % 10;
        nickels = totalCents / 5;
        totalCents = totalCents % 5;
        pennies = totalCents;
    }

    @Override
    public String toString() {
        return  (quarters+dimes+nickels+pennies == 0)?"nothing":
                ((quarters != 0)?((quarters == 1)?"1 quarter":quarters +" quarters") + ((dimes+nickels+pennies!=0)?" and ":""):"") +
                ((dimes != 0)?(((dimes == 1)?"1 dime":dimes + " dimes") + ((nickels+pennies!=0)?" and ":"")):"") +
                ((nickels != 0)?(((nickels == 1)?"1 nickel" :nickels + " nickels") + ((pennies!=0)?" and ":"")):"") +
                ((pennies != 0)?((pennies == 1)?"1 penny":pennies + " pennies"):"");
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print ("Enter the amount you want to convert: ");
        int amountInCents = input.nextInt() ;
        CoinConverter machine = new CoinConverter (amountInCents) ;
        System.out.println(machine);
    }
    /*output:

        Enter the amount you want to convert: 65
        2 quarters and 1 dime and 1 nickel

        Enter the amount you want to convert: 0
        nothing

        Enter the amount you want to convert: 95
        3 quarters and 2 dimes

        Enter the amount you want to convert: 99
        3 quarters and 2 dimes and 4 pennies

        Enter the amount you want to convert: 60
        2 quarters and 1 dime

        Enter the amount you want to convert: 75
        3 quarters
     */


}

