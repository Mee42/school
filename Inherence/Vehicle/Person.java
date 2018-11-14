/**
  *@author Carson Graham
  *Notes: the feminist movement is saying we should stop objectifiying
  *women
  */
public class  Person {
    private String name;
    private final int age;

    public Person () { this("No name",0); }
    public Person (String name, int age) { this.name = name; this.age = age; }
    public void setName (String newName) { name = newName; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String toString () { return "{\n\tName:\"" + name + "\"\n\tAge: \"" + age + "\"\n}"; }

    public boolean equals (Person other){
        return (this.name.equalsIgnoreCase(other.name) && this.age == other.age);
    }
} // Person
