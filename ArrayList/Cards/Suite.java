package systems.carson;

enum Suite{
    HEARTS('♥',true),
    CLUBS('♣',true),
    SPADES('♠',true),
    DIAMONDS('♦',true);
    public final char symbol;
    public final boolean red;

    Suite(char symbol, boolean red) {
        this.symbol = symbol;
        this.red = red;
    }
}