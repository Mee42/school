/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: not sure why the example wanted to use javaMachine, but whatever
  */
public class VendingMachine {
    private int sodaCans;
    private int tokens;

    public VendingMachine(int sodaCans) {
        this.sodaCans = sodaCans;
    }

    public VendingMachine() {
        this(10);
    }

    public void insertToken(){
        if(sodaCans <= 0){
            System.out.println("No more soda cans");
            return;
        }
        sodaCans--;
        tokens++;
    }

    public void addCans(int i){
        sodaCans+=i;
    }

    @Override
    public String toString() {
        return super.toString() + " cans:" + sodaCans + "  tokens:" + tokens;
    }

    public static void main (String [] args) {
        VendingMachine machine = new VendingMachine();
        VendingMachine javaMachine = new VendingMachine (20);
        machine.addCans (20);
        machine.insertToken();
        machine.insertToken();
        System.out.println (machine);
        System.out.println (javaMachine);
    }

}

