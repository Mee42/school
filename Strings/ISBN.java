
/**
 * @author Carson Graham
 * Date: 2018-11-14
 * Notes: basiclly the credit card checker lab, but more complex. It's shorter though, that's interesting. I probably made some mistakes on the credit card lab
 */
public class ISBN {
    public static char getCheck(String isbn){
        isbn = isbn.replace("-","");
        int index = 0;
        int total = 0;
        for(int i = 10;i>=2;i--) {
            total += Integer.parseInt(String.valueOf(isbn.charAt(index++))) * i;
        }
        total%= 11;
        total = 11 - total;
        if(total ==10)
            return 'X';
        return String.valueOf(total).charAt(0);//parse to string and then take the first number
    }
    public static boolean isValid(String isbn){
        return isbn.charAt(isbn.length() -1) == getCheck(isbn);
    }


}

/*
no output. {@see Main.testISBN()}
*/
