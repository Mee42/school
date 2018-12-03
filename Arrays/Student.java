package arrays.com.carson;

public class Student {
    private final int ID;
    private final String name;
    private final double gpa;

    public Student(int ID, String name, double gpa) {
        this.ID = ID;
        this.name = name;
        this.gpa = gpa;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
