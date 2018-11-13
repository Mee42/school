/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: all processing is done it the constructer, this lets me set some variables as final and it also lets me eliminate redundent processing
  */
public class QuadraticEquation {
    private final double a,b,c,disc;
    private int solCount;
    private double sol1,sol2;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.disc = genDisc();
        genSols();
    }

    private void genSols() {
        switch (solCount){
            case 0:
                sol1 = -1;
                sol2 = -1;
                break;
            case 1:
                sol1 = (-b - disc) / (2*a);
                sol2 = -1;
            case 2:
                sol1 = (-b - disc) / (2*a);
                sol2 = (-b + disc) / (2*a);
                break;
        }

    }

    private double genDisc() {
        double noSqrt =  (Math.pow(b,2) - (4 * a * c));
        System.out.println("discriminant:" + noSqrt);
        if(noSqrt < 0){
            solCount = 0;
        }else if(noSqrt == 0){
            solCount = 1;
        }else{
            solCount = 2;
        }
        return Math.sqrt(noSqrt);
    }

    public double getDisc() {
        return disc;
    }

    public double getSolution1() {
        return sol1;
    }

    public double getSolution2() {
        return sol2;
    }

    public boolean equalRoots(){
        return solCount == 1;
    }
    public boolean noSolution(){
        return solCount == 0;
    }

}

