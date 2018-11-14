
/**
 * @author Carson Graham
 * Date: 2018-11-14
 * Notes: no notes
 */
public class Sentence {
    private final String sentence;
    private final int length;
    private final int words;
    private final double wordLength;

    public Sentence(String sentence) {
        this.sentence = sentence;
        this.length = sentence.length();
        this.words = sentence.split(" ").length;
        this.wordLength = (double)length / words;
    }

    public String getSentence() {
        return sentence;
    }

    public int getWords() {
        return words;
    }

    public double getWordLength() {
        return wordLength;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString(){
        return "" +
                "Length of the sentence:  " + length + "\n" +
                "Number of words:  " + words + "\n" +
                "Average word length:  " + words;
    }
}
/*
output:{@see Main.runSentence()}
> Edmund Lau
Length of the sentence:  10
Number of words:  2
Average word length:  2
 */
