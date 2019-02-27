import java.util.Scanner;
/**
*Author: Carson Graham
*
*Notes: The class Board was designed to be able to used in multiple situations, 
* extrapolating the tic-tac-toe logic out and
* Allowing it to be used across platforms and implementations
* 
* I also have input handling, which makes sure that users don't
* put in invalid inputs
*/
class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
	while(!board.hasAnyoneWon() && !board.isFull()){
            System.out.println(board.getTurn() + "'s turn");
            System.out.println(board);
            int position = getPosition(scan);
            boolean result = board.place(position);
            if(!result)System.err.println("Unable to move there.");

	}
        if(board.winner() != 0 )
            System.out.println(board.s(board.winner()) + " Won!");
        else
            System.out.println("Tie");
        System.out.println(board);
    }
    private static int getPosition(Scanner scan){
      boolean error = false;
      while(true){
        if(error)System.err.println("Error");
        System.out.print("Enter position:");
        error = true;
        String out = scan.nextLine();
        try{
          int i = Integer.parseInt(out);
          if(i < 0 || i > 8)continue;
          return i;
        }catch(NumberFormatException e){}
      }
    }
}
