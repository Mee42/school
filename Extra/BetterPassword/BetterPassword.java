import java.util.*;
import java.security.spec.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * @author Carson Graham
 * Date: 2018-12-1
 * Notes can be found in BetterPassword.md
 *
 */
public class BetterPassword{
    enum Type{
        LOWERCASE("abcdefghijklmnopqrstuvwxyz"),
        UPPERCASE("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        SPECIAL("~!@#$%^&*()_+{}-=[]:;<>?,./'|\\"),
        NUMBER("0123456789");
//        SPACE(" ");

        public final String value;
        Type(String value){
            this.value = value;
        }
    }

    enum HashFunction{
        PKB((factory,spec,digest) -> {
            try {
                factory.generateSecret(spec);
            } catch (InvalidKeySpecException e) { e.printStackTrace(); }
        },"PBKDF2 @ 65536 iterations"),
        SHA((factory,spec,digest) -> {
            digest.digest("password".getBytes());
        },"SHA-256");
        Hashes h;
        String desc;
        double cache = -1;
        HashFunction(Hashes h,String desc){
            this.h = h;
            this.desc = desc;
        }
        interface Hashes{
            void hash(SecretKeyFactory factory,KeySpec sec,MessageDigest digest);
        }
    }

    private static HashFunction hash = HashFunction.PKB;


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Computer:" + computerInfo());
        while(true){
            System.out.print(">");
            String in = scan.nextLine();
            switch(in.toLowerCase()){
                case "help":
                    System.out.println("======help=============");
                    System.out.println("help   :   print this");
                    System.out.println("sha    :   switch to sha");
                    System.out.println("pbk    :   switch to pbk");
                    System.out.println("exit   :   exit");
                    System.out.println("=======================");
                    break;
                case "sha":
                    hash = HashFunction.SHA;
                    System.out.println("Changed hash function to SHA");
                    break;
                case "pbk": case "pkb":
                    hash = HashFunction.PKB;
                    System.out.println("Changed hash function to PBKDF2");
                    break;
                case "exit":
                    return;
                default:
                    runPasswordAnalysis(in);
            }

        }
    }

    private static void runPasswordAnalysis(String in) {
        List<Type> types = generateGroups(in);
        for(Type type : types)System.out.print(type + "  ");
        System.out.println();
        System.out.println("Entropy:" + generateEntropy(types));
        long hashesToBreak = (long)Math.pow(generateEntropy(types),in.length());
        double timeToBreak = hashesToBreak / hashesPerSecond();
        System.out.println(hash.desc +" Running on four low-priority threads, on the JVM, on your computer");
        System.out.println("Hashes to break:" + hashesToBreak);
        System.out.printf("Seconds to break:%.10f\n",timeToBreak);
        double days = timeToBreak / 60 / 60 / 24;
        System.out.printf("Days to break:%.10f\n",days);
        System.out.printf("Years to crack:%.1f\n",(days / 365));
        System.out.println("\n");
    }

    private static List<Type> generateGroups(String in){
        List<Type> types = new ArrayList<>();
        for(char c : in.toCharArray()){
            for(Type type : Type.values()){
                if(types.contains(type))continue;
                if(type.value.contains(c + ""))
                    types.add(type);
            }
        }
        return types;
    }

    private static double hashesPerSecond(){
        if(hash.cache != -1)return hash.cache;
        System.out.print("processing...");
        System.out.flush();
        long l = System.currentTimeMillis();
        new BetterPassword().runThreads();
        l = System.currentTimeMillis() - l;
        hash.cache = (double)(hashes*iters) / (l/1000.0);
        System.out.printf("done. hashes per second:%.10f\n",hash.cache);
        return hashesPerSecond();
    }

    private static int generateEntropy(List<Type> types){
        int total = 0;
        for(Type type : types)
            total+=type.value.length();
        return total;
    }

    private static String computerInfo(){
        return System.getProperty("os.name") + " Version " + System.getProperty("os.version") +
                " Architecture:"  +  System.getProperty("os.arch") +
                " - Cores:" + Runtime.getRuntime().availableProcessors();

    }

    private static int hashes;
    private static int iters = 16;
    /* this needs to be a instance  method ran with `new Main().runThreads()` due to threading issues*/
    private void runThreads(){
        hashes = (hash == HashFunction.PKB)?1_000 : 1_000_000;
        List<Runner> runners = new ArrayList<>();

        for(int c = 0;c<4;c++){
            runners.add(new Runner(iters/4));
        }
        List<Thread> threads = new ArrayList<>();

        for(Runner r : runners)threads.add(r.execute());

        while(true){
            boolean e = true;
            for(Thread t : threads){
                if(t.isAlive()){
                    e = false;
                    break;
                }
            }
            if(e) return;

        }

    }

    static class Runner implements Runnable{
        int iters;

        public Runner(int iters) {
            this.iters = iters;
            try {
                factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                digest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        public Thread execute(){
            Thread t = new Thread(this);
            t.start();
            return t;
        }


        //Needed to be kept per-thread to fix volatile issues
        private byte[] salt = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};//non-random salt
        private SecretKeyFactory factory;
        private KeySpec spec = new PBEKeySpec("password".toCharArray(),salt,65536,128);
        private MessageDigest digest;

        @Override
        public void run() {
            for(int iter = 0;iter<iters;iter++) {
                for (int i = 0; i < hashes; i++)
                    hash.h.hash(factory,spec,digest);
                System.out.print(".");
                System.out.flush();
            }
        }
    }

}



/*output


>password
LOWERCASE
Entropy:26
processing...................done. hashes per second:46.1889764234
PBKDF2 @ 65536 iterations Running on four low-priority threads, on the JVM, on your computer
Hashes to break:208827064576
Seconds to break:4521145103.1450080000
Days to break:52328.0683234376
Years to crack:143.4


>P@ssW0rd!
UPPERCASE  SPECIAL  LOWERCASE  NUMBER
Entropy:92
PBKDF2 @ 65536 iterations Running on four low-priority threads, on the JVM, on your computer
Hashes to break:472161363286556672
Seconds to break:10222382045409568.0000000000
Days to break:118314607007.0551900000
Years to crack:324149608.2


>sha
Changed hash function to SHA
>password
LOWERCASE
Entropy:26
processing...................done. hashes per second:6736842.1052631580
SHA-256 Running on four low-priority threads, on the JVM, on your computer
Hashes to break:208827064576
Seconds to break:30997.7673980000
Days to break:0.3587704560
Years to crack:0.0


>P@ssW0rd!
UPPERCASE  SPECIAL  LOWERCASE  NUMBER
Entropy:92
SHA-256 Running on four low-priority threads, on the JVM, on your computer
Hashes to break:472161363286556672
Seconds to break:70086452362.8482500000
Days to break:811185.7912366696
Years to crack:2222.4


>help
======help=============
help   :   print this
sha    :   switch to sha
pbk    :   switch to pbk
exit   :   exit
=======================
>
 */