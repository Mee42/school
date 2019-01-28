class Freak extends Warrior{
    @Override
    StatsData generateStats(){ return new StatsData(60,180,1,100); }
    
    @Override
    String getName(){
        return "Freak";
    }
}