package systems.carson;

/**
 * @author Carson Graham
 * Date: 2018-12-17
 * Notes: This was pretty much the same as the StandardDeck lab, except with less cards. A better lab would be something that let StandardDeck
 * deal out cards to a new hand and other interations between the two
 *
 * Edit: turns out I only used streams in the lab. well, whatever.
 *
 */
public class ArrayListLabTwo {
    public static void main(String[] args) {
        Hand hand = new Hand();
        System.out.println("new hand:" + hand);
        hand = new Hand(new Card(Suite.SPADES,Number.ACE),
                        new Card(Suite.CLUBS,Number.TWO),
                        new Card(Suite.DIAMONDS,Number.KING));
        System.out.println("hand with ace:" + hand);
        System.out.println("size:" + hand.size());
        System.out.println("get(1):" + hand.get(1));
        Card remove = hand.remove(1);
        System.out.println("remove(1):" + remove);
        System.out.println("new Hand:" + hand);
        hand.insert(remove);
        System.out.println("Added back remove:" + hand);
        System.out.println("Contains " + Suite.SPADES + ":" + hand.containsSuite(Suite.SPADES));
        System.out.println("Contains " + Suite.HEARTS + ":" + hand.containsSuite(Suite.HEARTS));

        System.out.println("Contains " + Number.ACE + ":" + hand.containsNumber( Number.ACE ));
        System.out.println("Contains " + Number.ONE + ":" + hand.containsNumber( Number.ONE ));

    }
}
/*
new hand:Hand([])
hand with ace:Hand([♠ACE, ♣TWO, ♦KING])
size:3
get(1):♣TWO
remove(1):♣TWO
new Hand:Hand([♠ACE, ♦KING])
Added back remove:Hand([♠ACE, ♦KING, ♣TWO])
Contains SPADES:true
Contains HEARTS:false
Contains ACE:true
Contains ONE:false

Process finished with exit code 0

 */