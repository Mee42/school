class Board{
  private int[] board;//store in 1d array. 
  /*
 0 | 1 | 2 
 ----------
 3 | 4 | 5
 ----------
 6 | 7 | 8
  
  0 = empty
  1 = player 1
  2 = player 2
  */
  private int turn;//keep the turn in this class

  Board(){
    board = new int[9];
    turn = 1;
  }

  public boolean place(int place){
    if(place < 0 || place > 8)return false;//don't move if out of bounds
    if(board[place] != 0)return false;//don't move if spot is already filled
    board[place] = turn;//move
    turn = (turn == 1) ? 2 : 1;//ONLY CHANGE IF THE PLAYER PLAYED
    return true;
  }


  public int winner(){
    int[] b = board;//for shorter notation
    //rows
    if(b[0] == b[1] && b[1] == b[2])return b[0];
    if(b[3] == b[4] && b[4] == b[5])return b[3];
    if(b[6] == b[7] && b[7] == b[8])return b[6];
    //columns
    if(b[0] == b[3] && b[3] == b[6])return b[0];
    if(b[1] == b[4] && b[4] == b[7])return b[1];
    if(b[2] == b[5] && b[5] == b[8])return b[2];
    //diagonals
    if(b[0] == b[4] && b[4] == b[8])return b[4];
    if(b[2] == b[4] && b[4] == b[6])return b[4];
    return 0;
  }

  public boolean hasAnyoneWon(){ return winner() != 0; }
  
  public boolean isFull(){
    int[] b = board;//for shorter notation
    return b[0] != 0 &&
        b[1] != 0 &&
        b[2] != 0 &&
        b[3] != 0 &&
        b[4] != 0 &&
        b[5] != 0 &&
        b[6] != 0 &&
        b[7] != 0 &&
        b[8] != 0;   
  }


  public String getTurn() { return s(turn); }

  /** Turns the integer passed into a string to make the output pretty. See public String getTurn() as well */
  public String s(int i){return (i == 1) ? "X" : (i == 0) ? " " : "O"; } 
  
  @Override
  public String toString(){
    int[] b = board;//for shorter notation
    return "" +
        s(b[0]) + " | " + s(b[1]) + " | " + s(b[2]) + "\n" +
        "----------\n" +
        s(b[3]) + " | " + s(b[4]) + " | " + s(b[5]) + "\n" +
        "----------\n" +
        s(b[6]) + " | " + s(b[7]) + " | " + s(b[8]);
  }

}

