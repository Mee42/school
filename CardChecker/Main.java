import java.util.*;
/**
  *@author Carson Graham
  *Date: 2018-9-19
  * Notes:
  *  Runs iterations left-to-right, but the side effect of that (check number is doubled) is counteracted by adding a "0" to the begining of the
  *    string if has an odd number of characters (ie all credit card numbers except the ones in the tutorial I was following)
  *
  *  The instructions on the lab packet were not clear, so I looked in up and found a better example (https://www.revolvy.com/page/Luhn-algorithm) and
  *  followed that instead. This lead to the seperation of the addition of the check number, which ended up actually helping me with generating a
  *  corrent check number.
  *
  *  Small loops have been shortened (and brackets removed)for readability.
  *
  *  You wanted a Integer input in the lab, but this is digit manipulation and a horrible place to use integers. If it pleases you, however, I could
  *  simply replace
  *     scan.nextLine()
  *  with
  *     scan.nextLong() + "";
  *
  *
  * PostScript: I have a super redundent parse-to-long, and all it does it cast it back to String. longs and Integers should be compleatly avoided
  * when representing the number in its entirity, because of its size if you use 16 digit numbers.
  *
  */
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a any-digit credit card number:");
        String in = scan.nextLine();
        if(in.length() % 2 == 0)
            in = "0" + in;
        int[] arr = new int[in.length()];
        for(int i = 0;i<arr.length;i++)
            arr[i] = Integer.parseInt(in.charAt(i) + "");
        for(int i = 1;i<arr.length;i+=2)
            arr[i] = calcSumOfDigits(arr[i]*2);
        String all = "";
        for(int i : arr)
            all+=i;
        //this number is a long to allow for bigger numbers
        long lastNumberNoCheck = Long.parseLong(all)/10;//due to reasons I actually add the check digit apart from all of the other digits.
           //I'd tell you that it was to make the creation of a check digit easier, but actually it was cause I missread a tutorial.
          //see the class's javadoc comment
        long added = calcSumOfDigits(lastNumberNoCheck);
        System.out.println("---all:" + all + "\n---lastNumberNoCheck:" + lastNumberNoCheck + "\n---added:" + added);//third row
        System.out.println("---testing:" + ((added+arr[arr.length-1])));
        if((added+arr[arr.length-1])%10==0){
          System.out.println(in + " is a valid number!");
        }else{
          System.err.println(in + " is not a valid number.");
          int should = (int)(10-((added%10)));
          System.out.println("The check digit should be " + should);
        }
    }

    private static int calcSumOfDigits(long n){
        String str =  n + "";
        int total = 0;
        for(char c : str.toCharArray())
          total+=Integer.parseInt(c + "");
       System.out.println("------------ "+n+" --> " + total);
       return total;
    }
}

/*
note, dubug prints(starting with ---) have been removed from the output

[ carson-arch school ]$ java Main
Please enter a any-digit credit card number:43589795
043589795 is a valid number!

[ carson-arch school ]$ java Main
Please enter a any-digit credit card number:43589798
043589798 is not a valid number.
The check digit should be 5

*/
