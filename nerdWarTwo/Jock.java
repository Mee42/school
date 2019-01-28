class Jock extends Warrior{
    @Override
    StatsData generateStats(){ return new StatsData(80,140,50,100); }
    @Override
    String getName(){
        return "Jock";
    }
}
