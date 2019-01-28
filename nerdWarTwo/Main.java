import java.util.List;
import java.util.ArrayList;

/**
  *@author Carson Graham
  *Date: 2019-1-28
  *Notes:
  * Nowhere in the instructins did it say to add warriors to the list, so I had to add that in myself (lines 15-19)
  * I don't belive abstract classes are the best way to do this because they do not **extend** functionality. All the subclasses define is
  * the min/max of iq and strength. A factory class might be a better way, something like
  *
  * class WarriorFactory{
  *   static Warrior makeNerd(){
  *     return new Warrior(){
  *       @Override
  *          StatsData generateStats(){ return new StatsData(120,180,20,80); }
  *     }
  *   }
  * }
  * 
  * And then instanciate new objects with
  * Warrior nerd = WarriorFactory.makeNerd();
  *
  * Of course, it would make more sense to just pass the StatsData to a warrior object via the constructor, which would make the factory method
  * look like this:
  *
  * static Warrior makeNerd() {
  *   return new Warrior(new StatsData(120,180,20,80));
  * }
  *
  * or even redifine the warrior constructor to accept four ints and bypass the StatsData object entirely
  *
  * static Warrior makeNerd() {
  *   return new Warrior(120,180,20,80);
  * }
  *
  * I also added a getName() method to Warrior so I could print it in the toString() method.
  */

public class Main {
    public static void main(String[] args) {
       List<Warrior> warriors = new ArrayList<Warrior>();
       warriors.add(new Freak());
       warriors.add(new Jock());
       warriors.add(new Nerd());
       warriors.add(new Prep());
       warriors.add(new Thug());
       while(warriors.size() != 1){
           Warrior one = warriors.remove((int)(Math.random()*warriors.size()));//remove so there be no duplicates
           Warrior two = warriors.remove((int)(Math.random()*warriors.size()));
           Warrior winner = one.fight(two);
           System.out.println("Winner: " + winner);
           warriors.add(winner);//add the winner back, so it remains in the list
       }
       System.out.println("Final winner: " + warriors.get(0));
    }
}
