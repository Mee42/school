import java.util.Scanner;
/**

Name: Carson Graham
Notes:

I'm used to the Pair<A,B> class in the bast, which is not avalibile in the standard java libraries, but is
in many libraries I use. So, I re-wrote it. More information in the Pair.java file

I use it to return two variables (x and y position) from the user input method.

The entire user interface is handled by the the Main class and the entire processing is handled by the Board.java class


*/
class Main{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    Board board = new Board(pollInt("Number of bombs:",scan),pollInt("Size of board:",scan));
    System.out.println(board.toPresentableString());
    while(true){
      Pair<Integer,Integer> in = pollCords("Uncover Position:",scan);
      try{
        board.uncover(in.a,in.b);
      }catch(RuntimeException e){
        System.out.println(board.toPresentableString());
        System.err.println("YOU CLICKED THE BOMB");
        System.exit(0);
      }
      System.out.println(board.toPresentableString());
      if(board.complete()){
       System.out.println("You Win!!");
       break;
      }
    }
  }

  private static Pair<Integer,Integer> pollCords(String message, Scanner scan){
    while(true){
      System.out.print(message);
      String out = scan.nextLine();
      try{
        String[] split = out.split(",");
        if(split.length != 2)throw new NumberFormatException();
        int r = Integer.parseInt(split[0]);
        int c = Integer.parseInt(split[1]);
        if(r < 0 || c < 0)throw new NumberFormatException();
        return new Pair<Integer,Integer>(r,c);
      }catch(NumberFormatException e){
        System.err.println("Error processing cords. Try again");
      }
    }
  }
  private static int pollInt(String message, Scanner scan){
    while(true){
      System.out.print(message);
      String out = scan.nextLine();
      try{
        int i = Integer.parseInt(out);
        if(i <= 0)throw new NumberFormatException();
        return i;
      }catch(NumberFormatException e){
        System.err.println("Error processing integer. Try again");
      }
    }
  }

}


