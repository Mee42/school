
public abstract class Warrior {
    public final int iq;
    public final int strength;
    
    Warrior(){
      StatsData stats = generateStats();
      iq = random(stats.iqMin,stats.iqMax);
      strength = random(stats.strengthMin,stats.strengthMax);
    }
    
    abstract StatsData generateStats();

    abstract String getName();
    
    public Warrior fight(Warrior other){
       if(iq - 20 > other.iq){ 
            return this;
        }
        if(other.iq - 20 > iq){
            return other;
        }
        if(strength> other.strength){
            return this;
        }
        if(other.strength > strength){
            return other;
        }
        return ((int)(Math.random() * 2) == 1) ? this : other;//neither warrior wins, pick one at random
    }
        
    private int random(int min, int max){
        return (int)(Math.random()*(max-min)+min);
    }
    
    @Override
    public String toString(){
         return "{ name: " + getName() + ", iq:" + iq + ", strength:" + strength + " }";    
    }
    
}
