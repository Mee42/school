/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: Test method was included in this class instead of a seperate class because there was no reason to split it in a project this small
  */
public class RoachPopulation {
    private int roaches;

    public RoachPopulation(int roaches) {
        this.roaches = roaches;
    }

    public int waitForDoubling(){
        roaches*=2;
        return roaches;
    }

    public int spray(){
        roaches = (int)(roaches * 0.9);
        return roaches;
    }

    public int getRoaches() {
        return roaches;
    }

    @Override
    public String toString() {
        return "Roaches:" + roaches;
    }


    public static void main(String[] args) {
        RoachPopulation kitchen = new RoachPopulation(10);
        for(int i = 0;i<=3;i++){
            kitchen.waitForDoubling();
            kitchen.spray();
            System.out.println(kitchen);
        }
    }
}

