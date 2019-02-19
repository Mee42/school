import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner();
        Board board = new Board();
        System.out.println(board);
    }
    private static int getPosition(Scanner scan){
      while(true){
        System.out.print("Enter position:");
        String out = scan.nextLine();
        try{
          int i = Integer.parseInt(out);

      }
    }
}
