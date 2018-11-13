package com.carson;

/**
 * @author Carson Graham
 * Date: 2018-09-16
 *
 * Notes: staticly importing java.lang.Math may have been a good idea due to the large amount of calls
 */
public class MultAdd {
    public static void main(String[] args) {
        System.out.println("multAdd(1,2,3) = " + multAdd(1,2,3));
        System.out.println("multAdd(sin(pi/4)+(cos(pi)/2)/2 = " + multAdd(Math.sin(Math.PI/4) + (Math.cos(Math.PI/2))/2,1,0));
        System.out.println("multAdd(log(10)+log(20)) = " + multAdd(Math.log(10) + Math.log(20),1,0));
        System.out.println("yikes(0) = " + yikes(0));
        System.out.println("yikes(1) = " + yikes(1));
    }


    private static double multAdd(double a,double b,double c){
        return shorten(a*b+c);
    }

    private static double yikes(double x){
        double sqrt = Math.sqrt(1 - Math.exp(-x));
        double two = x * Math.exp(-x);
        return shorten(sqrt+two);
    }

    /**
     * takes a double and cuts off digits past the thousands place with integer casting
     */
    private static double shorten(double d){
        int i = (int) (d * 1000);
        return (double)i/1000;
    }
}

/*
  outputs:
    multAdd(1,2,3) = 5.0
    multAdd(sin(pi/4)+(cos(pi)/2)/2 = 0.707
    multAdd(log(10)+log(20)) = 5.298
    yikes(0) = 0.0
    yikes(1) = 1.162

 */