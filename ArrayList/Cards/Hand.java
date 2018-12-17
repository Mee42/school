package systems.carson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    private final List<Card> cards;
    public Hand(){
        this.cards = new ArrayList<>();
    }

    public Hand(Card...cards){
        //varargs input
        this.cards = new ArrayList<>(Arrays.asList(cards));
    }

    public int size(){
        return cards.size();
    }

    public Card get(int i){
        return cards.get(i);//this will do do index validation for us, no need to handle it yet.
    }

    public Card remove(int i){
        return cards.remove(i);
    }

    public boolean containsNumber(Number number){
        return cards.stream().anyMatch(it -> it.number == number);
        //fun stuff with streams.
    }

    public boolean containsSuite(Suite suite){
        return cards.stream().anyMatch(it -> it.suite == suite);
    }

    public void insert(Card card){
        if(cards.contains(card))
            throw new Card.CardAlreadyExistsExceptions("Card already exists within hand");
        cards.add(card);
    }

    @Override
    public String toString(){
        return "Hand(" + Arrays.toString(cards.toArray()) + ")";
    }

}
