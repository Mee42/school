package systems.carson;


public class Card{
    static class CardAlreadyExistsExceptions extends RuntimeException{
        public CardAlreadyExistsExceptions(String s) {
            super(s);
        }
    }//I couldn't find any better exceptions for this specific cass
    public final Suite suite;
    public final Number number;

    public Card(Suite suite, Number number) {
        this.suite = suite;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suite == card.suite && number == card.number;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "suite=" + suite +
//                ", number=" + number +
//                '}';
        return suite.symbol + "" + number;
    }
}
