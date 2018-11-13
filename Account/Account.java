/**
  *@Author Carson Graham
  *Date: 2018-9-25
  *Notes: would have liked to use junit for tests, but did not want to add additional dependencies
  */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public Account() {
        this.balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public int add(int amount){
        balance+=amount;
        return balance;
    }

    public int withdraw(int amount){
        if(amount>balance){
            System.err.println("Can't withdraw more then you have");
            return balance;
        }
        balance-=amount;
        return balance;
    }


    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Account))return false;
        Account obj = (Account)o;
        return obj.getBalance() == balance;
    }


    @Override
    public String toString() {
        return super.toString() + ":" + balance;
    }


    public static void main(String[] args) {
        if(!runTests()){
            System.err.println("=====  failed tests");
        }else{
            System.out.println("=====  passed all tests");
        }
    }

    private static boolean runTests() {
        Account one = new Account();
        Object o = new Byte("10");
        Account three = new Account(1000);
        Account two = new Account(10);
        if(one.getBalance() != 0)return false;
        if(one.add(10) != 10)return false;
        if(one.withdraw(100) != 10)return false;
        System.out.println("string value:" + one.toString());
        if(!one.equals(two))return false;
        if(one.equals(three))return false;
        if(one.equals(o))return false;
        return true;
    }

}
