package systems.carson;

import java.util.*;

public class StandardDeck {
    private List<Card> cards;
    public StandardDeck(){
        cards = new ArrayList<>();
        resetDeck();
    }

    public Card drawCard(){//the bottom of the list is going to be
        if(size() == 0)
            throw new IndexOutOfBoundsException();
        Card card = cards.get(cards.size() - 1);
        cards.remove(card);
        return card;
    }

    public StandardDeck shuffle(){
        Collections.shuffle(cards);//going to be much more random then anything I could write myself
        return this;//so stacked calls work. for example: StandardDeck desk = new StandardDesk().shuffle()
    }

    public int size(){
        return cards.size();
    }

    public void insertCardAtBottom(Card card) {
        if(cards.contains(card))
            throw new Card.CardAlreadyExistsExceptions("Card already exists within deck");
        cards.add(0,card);
    }

    public StandardDeck resetDeck() {
        cards.clear();
        for(Suite suite : Suite.values()){
            for(Number number : Number.values()){
                cards.add(new Card(suite,number));
            }
        }
        return this;
        //shuffle()//User implementation may want the cards unshuffled; use `desk.resetDeck().shuffle() if needed
    }

    @Override
    public String toString() {
        return "StandardDeck{" +
                "cards=" + Arrays.toString(cards.toArray()) +
                "size=" + size() +
                '}';
    }
}
