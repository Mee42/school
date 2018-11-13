/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: no notes, code was testing code from pdf
  */
import java.util.Scanner;
public class QuadraticEquationTest {

    public static void main (String [] args) {
        Scanner input = new Scanner (System.in);
        for (double k = 1; k <= 3; k++) {
            System.out.println("Enter a, b, and c: ");
            double a = input.nextInt();
            double b = input.nextInt();
            double c = input.nextInt();
            QuadraticEquation q = new QuadraticEquation (a,b,c);
            if (q.noSolution())
                System.out.println ("No real solution.");
            else if (q.equalRoots())
                System.out.println ("The only solution is: " + q.getSolution1());
            else{
                System.out.println("The two real solutions are:");
                System.out.println(q.getSolution1());
                System.out.println(q.getSolution2());
            }

        }
    }


}
