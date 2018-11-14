
/**
 * @author Carson Graham
 * Date: 2018-11-14
 * Notes: pretty easy, nothing special here.
 */
public class Palindrome {
    public static boolean check(String str){
        str = str.replace(" ","").toLowerCase();//will strip whitespace and special characters
        int index1 = 0;
        int index2 = str.length() - 1;
        while(index1 < index2){
            if(str.charAt(index1) != str.charAt(index2))
                return false;
            index1++;
            index2--;
        }
        return true;
    }
}
/*
output: {@see Main.drivePalindrome()}
Enter a string: racecar
racecar is a palindrome


Enter a string: RACE    CAR
RACE    CAR is a palindrome


Enter a string: A Toyota
A Toyota is a palindrome


Enter a string: asdf
asdf is NOT a palindrome


Enter a string: asdffdsa
asdffdsa is a palindrome


Enter a string: aa toyota
aa toyota is NOT a palindrome

 */
