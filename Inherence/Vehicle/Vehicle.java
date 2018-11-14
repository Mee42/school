/**
  *@author Carson Graham
  *Notes: none
  */
public class Vehicle {
    protected final String manufacturer;
    protected final int cylinders;
    protected final Person owner;

    public Vehicle(String manufacturer, int cylinders, Person owner) {
        this.manufacturer = manufacturer;
        this.cylinders = cylinders;
        this.owner = owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getCylinders() {
        return cylinders;
    }

    public Person getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    @Override
    public String toString() {
        return "{\n" +
                "\tmanufacturer:\"" + manufacturer + "\",\n" +
                "\tcylinders:\"" + cylinders + "\",\n" +
                "\towner:\"" + owner.toString().replace("\n","\n\t") + "\"\n}";
    }
}
