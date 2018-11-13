/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: testCarDistance may be redundent
  *
  */
public class Car {
    private final String make;
    private final int year;
    private final double cost;
    private final double millage;
    private int testCarDistance;

    public Car(String make, int year, double cost, double millage) {
        this.make = make;
        this.year = year;
        this.cost = cost;
        this.millage = millage;
        this.testCarDistance = 0;
    }

    public double testDrive(double miles){
        testCarDistance+=miles;
        return getMillage();
    }


    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public double getCost() {
        return cost;
    }

    public double getMillage() {
        return millage + testCarDistance;
    }

    @Override
    public String toString() {
        return make + "," + year + " cost:" + cost + " millage:" + getMillage();
    }

    public static void main(String[] args) {
        Car car = new Car("Ford",1997,1239.8,20_2000);
        System.out.println(car.getMake());
        System.out.println(car.getYear());
        System.out.println(car.getCost());
        System.out.println(car.getMillage());
        System.out.println(car.testDrive(10_000));
        System.out.println(car.getMillage());
        System.out.println(car);
        /* output:
            Ford
            1997
            1239.8
            202000.0
            212000.0
            212000.0
         */
    }
}

