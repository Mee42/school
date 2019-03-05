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
            System.out.println(board.getTurn() + "'s turn");//the board controls what turn it is
            System.out.println(board);
            int position = getPosition(scan);
            boolean result = board.place(position);//place returns false if we are unable to place there
            if(!result)System.err.println("Unable to move there.");

	}
        if(board.winner() != 0 )
            System.out.println(board.s(board.winner()) + " Won!");//board#s(int) replaces the integer with the right character: X or O
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
          return i;//only return if it parses and falls within the bounds
        }catch(NumberFormatException e){}
      }
    }
}
/*
Outputs:

X's turn
  |   |  
----------
  |   |  
----------
  |   |  
Enter position:0
O's turn
X |   |  
----------
  |   |  
----------
  |   |  
Enter position:4
X's turn
X |   |  
----------
  | O |  
----------
  |   |  
Enter position:5
O's turn
X |   |  
----------
  | O | X
----------
  |   |  
Enter position:7
X's turn
X |   |  
----------
  | O | X
----------
  | O |  
Enter position:1
O's turn
X | X |  
----------
  | O | X
----------
  | O |  
Enter position:9
Error
Enter position:10
Error
Enter position:Hello
Error
Enter position:8
X's turn
X | X |  
----------
  | O | X
----------
  | O | O
Enter position:3
O's turn
X | X |  
----------
X | O | X
----------
  | O | O
Enter position:6
O Won!
X | X |  
----------
X | O | X
----------
O | O | O

*/
