/**
  *@author Carson Graham
  *Date: 2018-9-25
  *Notes: converting the enum to an advanced enum with a min-max iq and strength value, I could have eliminated some code. 
  * something like:
  *   enum Type{
  *     private final int iqMin;
  *     private final int iqMax;//and so on
  *     private Type(int iqMin, int iqMax //and so on){}
  *     NERD(120,180,20,80)
  *   }
  *   then generating states would be cleaner
  */
public class Warrior {
    private final String name;
    private final Type type;
    enum Type{
        NERD,JOCK,PREP,THUG,FREAK
    }
    private final int iq;
    private final int strength;

    public Warrior(String name, Type type) {
        this.name = name;
        this.type = type;
        switch (type){
            case NERD:
                iq = random(120,180);
                strength = random(20,80);
                break;
            case JOCK:
                iq = random(80,140);
                strength = random(50,100);
                break;
            case PREP:
                iq = random(90,150);
                strength = random(40,90);
                break;
            case THUG:
                iq = random(60,90);
                strength = random(80,100);
                break;
            case FREAK:
                iq = random(60,180);
                strength = random(1,100);
                break;
            default:
                throw new AssertionError("Default after all enum values checked");
        }
    }


    @Override
    public String toString() {
        return "Name:" + name + " Clique:" + type + "  IQ:" + iq + " Strength:" + strength;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getIq() {
        return iq;
    }

    public int getStrength() {
        return strength;
    }

    private int random(int min, int max){
        return (int)(Math.random()*(max-min)+min);
    }

    public boolean fight(Warrior opp){
        if(getIq() - 20 > opp.getIq()){
            System.out.println(getName() + " wins against " + opp.getName() + " by IQ");
            return true;
        }
        if(opp.getIq() - 20 > getIq()){
            System.out.println(opp.getName() + " wins against " + getName() + " by IQ");
            return false;
        }
        if(getStrength()> opp.getStrength()){
            System.out.println(getName() + " wins against " + opp.getName() + " by Strength");
            return true;
        }
        if(opp.getStrength() > getStrength()){
            System.out.println(opp.getName() + " wins against " + getName() + " by Strength");
            return true;
        }
        System.out.println("The two opponents are equal");
        return false;
    }


    public static void main(String[] args) {
        Warrior lau = new Warrior ("Lau",Type.FREAK);
        Warrior pete = new Warrior ("Peter",Type.PREP);
        System.out.println (lau);
        System.out.println (pete);
        lau.fight(pete);
    }
    /*output:

    Name:Lau Clique:NERD  IQ:127 Strength:52
    Name:Peter Clique:JOCK  IQ:90 Strength:79
    Lau wins against Peter by IQ

    Name:Lau Clique:NERD  IQ:123 Strength:69
    Name:Peter Clique:JOCK  IQ:108 Strength:94
    Peter wins against Lau by Strength

    Name:Lau Clique:NERD  IQ:132 Strength:21
    Name:Peter Clique:NERD  IQ:120 Strength:31
    Peter wins against Lau by Strength

    Name:Lau Clique:FREAK  IQ:179 Strength:70
    Name:Peter Clique:PREP  IQ:96 Strength:61
    Lau wins against Peter by IQ

    Name:Lau Clique:FREAK  IQ:69 Strength:68
    Name:Peter Clique:PREP  IQ:124 Strength:42
    Peter wins against Lau by IQ
     */
}

