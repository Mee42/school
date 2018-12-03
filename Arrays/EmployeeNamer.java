package arrays.com.carson;

import java.util.Scanner;

public class EmployeeNamer {
    public static String[] parse(String[] arr){
        String[] formatted = new String[arr.length];
        for(int i = 0;i<arr.length;i++){
            char first = arr[i].charAt(arr[i].length() - 1);
            char second = arr[i].charAt(arr[i].length() - 2);
            formatted[i] = (first + "").toUpperCase() + ". " +
                    (second + "").toUpperCase() + ". " +
                    arr[i];

        }
        return formatted;
    }

    //tester
    public static void main(String[] args) {
        String[] arr = new String[7];
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i<arr.length;i++){
            System.out.print(">");
            String in = scan.nextLine();
            if(in == null || in.isEmpty()){//if it is empty, copy the array into a smaller one, and replace arr with it
                String[] newArr = new String[i];
                for(int x = 0;x<newArr.length;x++)
                    newArr[x] = arr[x];
                arr = newArr;
                break;
            }
            arr[i] = in;
        }
        arr = EmployeeNamer.parse(arr);
        System.out.println("New employee names:");
        for(String str : arr)
            System.out.println(str);
    }
}
