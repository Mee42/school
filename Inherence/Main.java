/**
  *A testing driver class
  */
public class Main {
    public static void main(String[] args) {
        testOrder();
        testVehicle();
        testPackage();
    }

    private static void testPackage() {
        System.out.println(new Package(4, Package.Method.AIR));
        System.out.println(new InsuredPackage(4, Package.Method.AIR));
    }


    private static void testVehicle() {
        System.out.println(new Person("NAMEY",0));
        System.out.println(new Vehicle("MANUFACTURER",0,new Person("NAMEY",1000)));
        System.out.println(new Truck("MANUFACTURER",0,new Person("NAMEy",1234),123,234));

    }


    private static void testOrder(){
        Order smallOrder = new Order ("Tom", 123, 20, 12.99);
        Order secondOrder = new Order ("Tom", 123, 20, 12.99);
        ExtraChargeOrder largeOrder = new ExtraChargeOrder ("John", 456, 1000, 25.99);
        System.out.println (smallOrder.computePrice());
        System.out.println (largeOrder.computePrice());
        System.out.println (smallOrder);
        System.out.println (largeOrder);
        System.out.println (smallOrder == secondOrder); // Is the output true or false? Why?
        System.out.println (smallOrder.equals(secondOrder)); // Is the output true or false? Why?
    }
}
