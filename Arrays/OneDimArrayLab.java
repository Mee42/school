package arrays.com.carson;

public class OneDimArrayLab {
    public static void main(String[] args) {
        int[] arr = new int[16];
        for(int i = 0;i<arr.length;i++)
            arr[i] = (int)(Math.random() * 10 - 5);
        printArr(arr);
        System.out.println(stats(arr));
    }

    private static String stats(int[] arr){
        int max = arr[0];
        int sum = 0;
        int min = arr[0];
        for(int i : arr){
            if(i > max)
                max = i;
            if(i < min)
                min = i;
            sum+=i;
        }
        double avg = (double)sum / arr.length;
        return "Max:" + max + "  Min:" + min + "  Sum:" + sum + "  Average:" + avg;
    }

    private static void printArr(int[] arr) {
        StringBuilder builder = new StringBuilder("{");
        for(int i = 0;i<arr.length-1;i++)
            builder.append(arr[i]).append(",");
        builder.append(arr[arr.length - 1]).append("}");
        System.out.println(builder.toString());
    }
}
