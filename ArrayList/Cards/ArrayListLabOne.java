package systems.carson;

public class ArrayListLabOne {
    public static void main(String[] args) {
        StandardDeck deck = new StandardDeck();
        System.out.println("start:" + deck);

        Card card = deck.drawCard();
        System.out.println("drew card:" + card);
        System.out.println("decK:" + deck);
        System.out.println("shuffled:" + deck.shuffle());
        System.out.println("adding card:" + card);
        deck.insertCardAtBottom(card);
        System.out.println("deck:" + deck);
        Card random = new Card(Suite.CLUBS,Number.ONE);
        System.out.println("adding card:" + random);
        try{
            deck.insertCardAtBottom(random);
        }catch(Throwable e){
            e.printStackTrace(System.out);
        }
        System.out.println("deck:" + deck);
        deck.resetDeck();
        System.out.println("reset:" + deck);
    }
}
/*


start:StandardDeck{cards=[♥ONE, ♥TWO, ♥THREE, ♥FOUR, ♥FIVE, ♥SIX, ♥SEVEN, ♥EIGHT, ♥NINE, ♥TEN, ♥JACK, ♥QUEEN, ♥KING, ♥ACE, ♣ONE, ♣TWO, ♣THREE, ♣FOUR, ♣FIVE, ♣SIX, ♣SEVEN, ♣EIGHT, ♣NINE, ♣TEN, ♣JACK, ♣QUEEN, ♣KING, ♣ACE, ♠ONE, ♠TWO, ♠THREE, ♠FOUR, ♠FIVE, ♠SIX, ♠SEVEN, ♠EIGHT, ♠NINE, ♠TEN, ♠JACK, ♠QUEEN, ♠KING, ♠ACE, ♦ONE, ♦TWO, ♦THREE, ♦FOUR, ♦FIVE, ♦SIX, ♦SEVEN, ♦EIGHT, ♦NINE, ♦TEN, ♦JACK, ♦QUEEN, ♦KING, ♦ACE]size=56}
drew card:♦ACE
decK:StandardDeck{cards=[♥ONE, ♥TWO, ♥THREE, ♥FOUR, ♥FIVE, ♥SIX, ♥SEVEN, ♥EIGHT, ♥NINE, ♥TEN, ♥JACK, ♥QUEEN, ♥KING, ♥ACE, ♣ONE, ♣TWO, ♣THREE, ♣FOUR, ♣FIVE, ♣SIX, ♣SEVEN, ♣EIGHT, ♣NINE, ♣TEN, ♣JACK, ♣QUEEN, ♣KING, ♣ACE, ♠ONE, ♠TWO, ♠THREE, ♠FOUR, ♠FIVE, ♠SIX, ♠SEVEN, ♠EIGHT, ♠NINE, ♠TEN, ♠JACK, ♠QUEEN, ♠KING, ♠ACE, ♦ONE, ♦TWO, ♦THREE, ♦FOUR, ♦FIVE, ♦SIX, ♦SEVEN, ♦EIGHT, ♦NINE, ♦TEN, ♦JACK, ♦QUEEN, ♦KING]size=55}
shuffled:StandardDeck{cards=[♠THREE, ♦KING, ♦QUEEN, ♦ONE, ♣SIX, ♣ONE, ♦SEVEN, ♦JACK, ♣EIGHT, ♣FOUR, ♣SEVEN, ♦TWO, ♠FIVE, ♥FIVE, ♥KING, ♠JACK, ♦FIVE, ♥THREE, ♣KING, ♣NINE, ♥FOUR, ♣QUEEN, ♣TWO, ♠SEVEN, ♣THREE, ♦EIGHT, ♠TEN, ♥ACE, ♣JACK, ♥NINE, ♠QUEEN, ♣TEN, ♥TEN, ♣FIVE, ♥JACK, ♠TWO, ♥SIX, ♥TWO, ♠EIGHT, ♦FOUR, ♥ONE, ♦SIX, ♥SEVEN, ♦NINE, ♠ONE, ♣ACE, ♥EIGHT, ♦TEN, ♠SIX, ♠FOUR, ♦THREE, ♠KING, ♠ACE, ♥QUEEN, ♠NINE]size=55}
adding card:♦ACE
deck:StandardDeck{cards=[♦ACE, ♠THREE, ♦KING, ♦QUEEN, ♦ONE, ♣SIX, ♣ONE, ♦SEVEN, ♦JACK, ♣EIGHT, ♣FOUR, ♣SEVEN, ♦TWO, ♠FIVE, ♥FIVE, ♥KING, ♠JACK, ♦FIVE, ♥THREE, ♣KING, ♣NINE, ♥FOUR, ♣QUEEN, ♣TWO, ♠SEVEN, ♣THREE, ♦EIGHT, ♠TEN, ♥ACE, ♣JACK, ♥NINE, ♠QUEEN, ♣TEN, ♥TEN, ♣FIVE, ♥JACK, ♠TWO, ♥SIX, ♥TWO, ♠EIGHT, ♦FOUR, ♥ONE, ♦SIX, ♥SEVEN, ♦NINE, ♠ONE, ♣ACE, ♥EIGHT, ♦TEN, ♠SIX, ♠FOUR, ♦THREE, ♠KING, ♠ACE, ♥QUEEN, ♠NINE]size=56}
adding card:♣ONE
javax.management.openmbean.KeyAlreadyExistsException: Card already exists within deck
	at systems.carson.StandardDeck.insertCardAtBottom(StandardDeck.java:32)
	at systems.carson.ArrayListLabOne.main(ArrayListLabOne.java:18)
deck:StandardDeck{cards=[♦ACE, ♠THREE, ♦KING, ♦QUEEN, ♦ONE, ♣SIX, ♣ONE, ♦SEVEN, ♦JACK, ♣EIGHT, ♣FOUR, ♣SEVEN, ♦TWO, ♠FIVE, ♥FIVE, ♥KING, ♠JACK, ♦FIVE, ♥THREE, ♣KING, ♣NINE, ♥FOUR, ♣QUEEN, ♣TWO, ♠SEVEN, ♣THREE, ♦EIGHT, ♠TEN, ♥ACE, ♣JACK, ♥NINE, ♠QUEEN, ♣TEN, ♥TEN, ♣FIVE, ♥JACK, ♠TWO, ♥SIX, ♥TWO, ♠EIGHT, ♦FOUR, ♥ONE, ♦SIX, ♥SEVEN, ♦NINE, ♠ONE, ♣ACE, ♥EIGHT, ♦TEN, ♠SIX, ♠FOUR, ♦THREE, ♠KING, ♠ACE, ♥QUEEN, ♠NINE]size=56}
reset:StandardDeck{cards=[♥ONE, ♥TWO, ♥THREE, ♥FOUR, ♥FIVE, ♥SIX, ♥SEVEN, ♥EIGHT, ♥NINE, ♥TEN, ♥JACK, ♥QUEEN, ♥KING, ♥ACE, ♣ONE, ♣TWO, ♣THREE, ♣FOUR, ♣FIVE, ♣SIX, ♣SEVEN, ♣EIGHT, ♣NINE, ♣TEN, ♣JACK, ♣QUEEN, ♣KING, ♣ACE, ♠ONE, ♠TWO, ♠THREE, ♠FOUR, ♠FIVE, ♠SIX, ♠SEVEN, ♠EIGHT, ♠NINE, ♠TEN, ♠JACK, ♠QUEEN, ♠KING, ♠ACE, ♦ONE, ♦TWO, ♦THREE, ♦FOUR, ♦FIVE, ♦SIX, ♦SEVEN, ♦EIGHT, ♦NINE, ♦TEN, ♦JACK, ♦QUEEN, ♦KING, ♦ACE]size=56}


 */