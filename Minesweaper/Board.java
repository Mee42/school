import java.util.List;
import java.util.ArrayList;

class Board{
  private int[][] squares;
  private int[][] shown;
  private List<Pair<Integer,Integer>> bombs;

  public Board(int bombCount, int size){
     shown = new int[size][size];
     for(int r = 0;r<size;r++){
       for(int c = 0;c<size;c++){
         shown[r][c] = -2;
       }
     }
     squares = new int[size][size];
     bombs = new ArrayList<>();
     if(size*size < bombCount) bombCount = size*size-1;
     int placed = 0;
     while(placed < bombCount){
        int randomR = (int)(Math.random() * size);
        int randomC = (int)(Math.random() * size);
        if(squares[randomR][randomC] == 0){
           squares[randomR][randomC] = -1;
           placed++;
           bombs.add(new Pair<Integer,Integer>(randomR,randomC));
        }
     }
     for(Pair<Integer,Integer> bomb : bombs){
        int r = bomb.a;
        int c = bomb.b;
        for(int r1 = -1;r1 <= 1;r1++){for(int c1 = -1;c1 <= 1;c1++){
           int r2 = r + r1;
           int c2 = c + c1;
           if(r2 < 0 || c2 < 0)continue;
           if(r2 >= size || c2 >= size)continue;
           if(r1 == 0 && c1 == 0)continue;
           if(squares[r2][c2] == -1)continue;
           squares[r2][c2]++;
        }}
     }
  }
  public static class BombFoundException extends RuntimeException{}
  public boolean uncover(int r, int c){
    if(r < 0 || c < 0)return false;
    if(r >= shown.length)return false;
    if(c >= shown[r].length)return false;
    if(shown[r][c] != -2)return false;
    shown[r][c] = squares[r][c];
    if(shown[r][c] == 0){
      for(int r1 = -1;r1 <= 1;r1++){
        for(int c1 = -1;c1 <= 1;c1++){
          if(r1 == 0 && c1 == 0)continue;
           uncover(r + r1,c + c1);
        }
      }
    }
    if(shown[r][c] == -1){
      throw new BombFoundException();
    }
    return true;

  }


  @Override public String toString(){
    StringBuilder builder = new StringBuilder();
    for(int r = 0;r < squares.length;r++){
      for(int c = 0;c < squares[r].length;c++){
        builder.append(fix(squares[r][c])).append(' ');
       }
       builder.append('\n');
    }
    return builder.toString();
  }

  public String toPresentableString(){
    StringBuilder builder = new StringBuilder();
    for(int r = 0;r < squares.length;r++){
      builder.append(r).append("|");
      for(int c = 0;c < squares[r].length;c++){
        builder.append(fixPreset(shown[r][c])).append(' ');
      }
      builder.append('\n');
    }
    builder.append(" |");
    for(int c = 0;c < squares[0].length;c++)
      builder.append("---");
    builder.append('\n').append(" | ");
    for(int c = 0;c < squares[0].length;c++){
      builder.append(c).append("  ");
    }
    return builder.toString();
  }

  private String fix(int i){
    String str = "" + i;
    if(str.length() == 1)str = " " + str;
    if(i == 0)return "  ";
    return str;
  }

  private String fixPreset(int i){
    if(i == -2)return " |";
    if(i == -1)return " B";
    return fix(i);
  }
   public boolean complete(){
     int count = 0;
     for(int r = 0;r < shown.length;r++){
       for(int c = 0;c < shown[r].length;c++){
         if(shown[r][c] == -2)//if not shown yet
           count++;
       }
     }
     return count == bombs.size();
   }
}
