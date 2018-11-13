import java.util.Scanner;
/**
  *@author Carson Graham
  *Date: 2018-9-19
  *Notes: none
  */
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("first number:");
        int i1 = scan.nextInt();
	System.out.print("second number:");
        int i2 = scan.nextInt();
        if(i1 > i2){//i1 is the smaller number!!!
            int temp = i1;
            i1 = i2;
            i2 = temp;
        }
        while(i1!=0){
            int remainder = i2 % i1;
            i2 = i1;
            i1 = remainder;
            if(i1 > i2){
                int temp = i1;
                i1 = i2;
                i2 = temp;
           }
           System.out.println("i1:" + i1 + "    i2:" + i2);
       }
       System.out.println("gcd is:" + i2);
   }
}
/*
[ carson-arch school ]$ java Main
first number:102
second number:321
i1:15    i2:102
i1:12    i2:15
i1:3    i2:12
i1:0    i2:3
gcd is:3
*/
