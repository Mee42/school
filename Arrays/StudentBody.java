package arrays.com.carson;

import java.util.Arrays;
import java.util.Scanner;

public class StudentBody {
    private static final Scanner scan = new Scanner(System.in);

    private final Student[] arr;

    public StudentBody() {
        arr = new Student[3];
        init();
    }

    private void init() {
        for(int i = 0;i<arr.length;i++){
            System.out.print("Name:");
            String name = scan.nextLine();
            System.out.print("ID:");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.print("GPA:");
            double gpa = scan.nextDouble();
            scan.nextLine();
            Student student = new Student(id,name,gpa);
            arr[i] = student;
        }
    }

    @Override
    public String toString() {
        return "StudentBody{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public Student search(int id){
        for(Student student : arr)
            if(student.getID() == id)
                return student;
        return null;
    }


    //tester method
    public static void main(String[] args) {
        StudentBody students = new StudentBody();
        System.out.print("query student by id:");
        int id = scan.nextInt();scan.nextLine();
        System.out.println(students.search(id));
        System.out.println("Entire student body:" + students);
    }
}
