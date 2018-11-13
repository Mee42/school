/**
  *@author Carson Graham
  *Date: 2018-9-25
  *very simple class, really no point in having it
  */
public class Dice {
    private int side = 1;

    public Dice() {}

    public void roll(){
        side = (int)(Math.random()*6)+1;
    }
    public int currentSide() {
        return side;
    }
}
