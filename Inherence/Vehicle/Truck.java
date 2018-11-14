/**
  *@author Carson Graham
  *Notes: none
  */
public class Truck extends Vehicle {
    private final double loadCapacity;
    private final int towingCapacity;

    public Truck(String manufacturer, int cylinders, Person owner, double loadCapacity, int towingCapacity) {
        super(manufacturer, cylinders, owner);
        this.loadCapacity = loadCapacity;
        this.towingCapacity = towingCapacity;
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tloadCapacity:" + loadCapacity + ",\n" +
                "\ttowingCapacity:" + towingCapacity + ",\n" +
                "\tmanufacturer:" + manufacturer + ",\n" +
                "\tcylinders:" + cylinders + ",\n" +
                "\towner:" + owner.toString().replace("\n","\n\t") + "\n}";
    }
}
