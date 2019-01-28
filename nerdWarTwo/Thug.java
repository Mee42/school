class Thug extends Warrior{
    @Override
    StatsData generateStats(){ return new StatsData(60,90,80,100); }
    @Override
    String getName(){
        return "Thug";
    }
}