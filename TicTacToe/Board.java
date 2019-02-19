class Board{
  private int[] board;
  private int turn;

  Board(){
    board = new int[9];
    turn = 1;
  }

  public boolean place(int place){
    if(place < 0 || place > 8)return false;
    if(board[place] != 0)return false;
    board[place] = turn;
    turn = (turn == 1) ? 2 : 1;
    return true;
  }


  public int winner(){
    int[] b = board;
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
    int[] b = board;
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


  public String s(int i){return (i == 1) ? "X" : (i == 0) ? " " : "O"; } 
  
  @Override
  public String toString(){
    int[] b = board;
    return "" +
        s(b[0]) + " | " + s(b[1]) + " | " + s(b[2]) + "\n" +
        "----------\n" +
        s(b[3]) + " | " + s(b[4]) + " | " + s(b[5]) + "\n" +
        "----------\n" +
        s(b[6]) + " | " + s(b[7]) + " | " + s(b[8]);
  }

}

