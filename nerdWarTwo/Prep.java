class Prep extends Warrior{
    @Override
    StatsData generateStats(){ return new StatsData(90,150,40,90); }
    @Override
    String getName(){
        return "Prep";
    }
} 