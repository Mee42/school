/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: no notes
  */
public class DiceTester {
    public static void main(String[] args) {
        Dice d = new Dice();
        System.out.println(d.currentSide());
        for(int i = 0;i<5;i++){
            d.roll();
            System.out.println("current side:" + d.currentSide());
        }
    }
}
