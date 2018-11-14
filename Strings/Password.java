
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author carson
 * Date: 2018-11-14
 * Notes: Enum used to return value, the string value of them is stored in each enum as an instance variable.
 * Many weaker passwords will return Strength#INVALID because the specs is not very inclusive
 */
public class Password {
    enum Strength{
        WEAK1("very weak"),
        WEAK2("weak"),
        STRONG1("strong"),
        STRONG2("very strong"),
        INVALID("INVALID");
        private final String str;
        Strength(String str) {
            this.str = str;
        }
        @Override
        public String toString(){
            return str;
        }
    }


    private static final List<Character> letters = "abcdefghijklmnopqrstuvwxyz"
            .chars()//convert to a IntStream
            .mapToObj(i-> (char) i)//convert to char
            .collect(Collectors.toList());//convert to a list

    private static final List<Character> numbers = "0123456789".chars().mapToObj(i->(char)i).collect(Collectors.toList());


    /**
     * Will return Strength#INVALID if password does not fit in any category(ie, alphanumeric && less-then 8 chars)
     */
    public static Strength testPassword(String password){
        if(password.length() < 8){
            boolean number = false;
            boolean letter = false;
            for(char c : password.toCharArray()){
                if(letters.contains(c))
                    letter = true;
                else if(numbers.contains(c))
                    number = true;
            }
            if(number && !letter)
                return Strength.WEAK1;
            if(letter && !number)
                return Strength.WEAK2;
            return Strength.INVALID;
        }else{
            boolean letter = false;
            boolean number = false;
            boolean special = false;
            for(char c : password.toCharArray()){
                if(numbers.contains(c))
                    number = true;
                else if(letters.contains(c))
                    letter = true;
                else //if not number or letter
                    special = true;
            }
            if(letter && number && special)
                return Strength.STRONG2;
            if(letter && number)
                return Strength.STRONG1;
            return Strength.INVALID;
        }
    }

}
/*
output: {@see Main.runPassword()}

The password 'hello' is a weak password.
The password '1234' is a very weak password.
The password 'abc123xyz' is a strong password.
The password '1337h@xor!' is a very strong password.
*/
