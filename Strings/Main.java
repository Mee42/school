
import java.util.Scanner;

/**
 * @author Carson Graham
 * Date: 2018-11-13
 *
 * This is a driver class for all of the methods and such in the Strings labs
 * testXYZ() methods will throw exceptions if the tests fail, but otherwise they print nothing
 * runXYZ() methods will be the interactive methods, or the methods that print something
 * test() runs all tests, if it runs successfully then everything is correct
 */
public class Main {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        testSentence();
        testEmail();
        testPassword();
        testISBN();
    }

    private static void testSentence() {
        Sentence sentence = new Sentence("Edmund Lau");
        if(!sentence.toString().equals("" +
                "Length of the sentence:  10\n" +
                "Number of words:  2\n" +
                "Average word length:  2")) {
            throw new RuntimeException("got:" + sentence.toString());
        }
    }

    private static void runSentence() {
        Scanner scan = new Scanner(System.in);
        System.out.print("> ");
        Sentence sentence = new Sentence(scan.nextLine());
        System.out.println(sentence);
    }


    private static void drivePalindrome(){
        Scanner console = new Scanner (System.in);
        for (int k = 1; k < 8; k++) {
            System.out.print("Enter a string: ");
            String str = console.nextLine();
            if (Palindrome.check(str))//== true? why?
                System.out.println(str + " is a palindrome\n\n");
            else
                System.out.println(str + " is NOT a palindrome\n\n");
        }
    }

    private static void testEmail() {
        for(String emailString : Raw.emails){
            Email email = new Email(emailString);
            if(!email.toString().equals(emailString)){
                throw new RuntimeException(emailString + ":" + email.toString());//pause so debugging can happen
            }
        }
    }

    private static void testPassword(){
        for(Raw.Pair<String, Password.Strength> pair : Raw.passwords) {
            if(pair.b != Password.testPassword(pair.a)){
                throw new RuntimeException("Excpeted " + pair.b + " but got " + Password.testPassword(pair.a) + "  password:" + pair.a);
            }
        }
    }

    private static void runPassword() {
        for (Raw.Pair<String, Password.Strength> pair : Raw.passwords)
            System.out.println("The password '" + pair.a + "' is a " + Password.testPassword(pair.a) + " password.");
    }


    private static void testISBN(){
        for(String isbn : Raw.isbn){
            if(!ISBN.isValid(isbn))
                throw new RuntimeException(isbn + " is invalid when it is actually valid");
        }
    }
}
