class Nerd extends Warrior{
    @Override
    StatsData generateStats(){ return new StatsData(120,180,20,80); }
    @Override
    String getName(){
        return "Nerd";
    }
}