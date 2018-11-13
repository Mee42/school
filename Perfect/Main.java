import java.util.*;
/**
  *@author Carson Graham
  *Date: 2018-9-19
  *Notes: I used a map to lazy load a search table for the aliquot sums
  *       for optomization
  */
public class Main{
    public static void main(String[] args){
        System.out.print("Perfect numbers between 2 and 500 inclusive are:");
        for(int i = 2;i<=500;i++){
            if(aliquotSum(i)==i){
              System.out.print(i + "  ");
            }
        }
        System.out.println();
        System.out.println("Amicable pairs between 2 and 500 inclusive are:");
        for(int n1 = 2;n1<=500;n1++){
          for(int n2 = n1;n2<=500;n2++){
            if(isPerfectPair(n1,n2)){
              System.out.println(n1 + "," + n2);
            }
          }
        }
    }

   //to speed up calculations, hopefully?
    private static Map<Integer,Integer> pairs = new HashMap<>();

    private static boolean isPerfectPair(int n1, int n2){
        int a1 = getFor(n1);
        int a2 = getFor(n2);
        return (a1 == n2) && (a2 == n1);
    }

    private static int getFor(int i){
        if(pairs.containsKey(i)){
          return pairs.get(i);
        }else{
          int a = aliquotSum(i);
          pairs.put(i,a);
          return a;
        }
    }


    private static int aliquotSum(int n){
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for(int i = 2;i<n-1;i++){
            if(n % i == 0){
                if(!factors.contains(i))
                    factors.add(i);
                if(!factors.contains(n / i))
                   factors.add(n / i);
            }
        }
        int total = 0;
        for(int i : factors){
          total+=i;
          //System.out.println("factor for " + n + " is " + i);
        }
        return total;
    }
}
/*
[ carson-arch school ]$ java Main
Perfect numbers between 2 and 500 inclusive are:6  28  496
Amicable pairs between 2 and 500 inclusive are:
6,6
28,28
220,284
496,496
*/
