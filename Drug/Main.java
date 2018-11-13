/**
  *@author Carson Graham
  *Date: 2018-9-19
  *Notes: produces slightly different outputs from the example. Interesting.
  *   Maybe floating point operations are handled by the processer,
  *   and therfore it varries between machines?
  */
public class Main{
  public static void main(String[] args){
    double effectiveness = 1;
    double lose = 1-0.04;
    int month =0;
    System.out.print("Month: 0    effectivness: 100.0");//cause I mixed up my loop
    while(effectiveness>.5){
      System.out.print("\nMonth: " + ++month);
      effectiveness*=lose;
      System.out.print("    effectivness: " + effectiveness*100);
    }
    System.out.println("  DISCARD");
  }
}

/*
Month: 0    effectivness: 100.0
Month: 1    effectivness: 96.0
Month: 2    effectivness: 92.16
Month: 3    effectivness: 88.47359999999999
Month: 4    effectivness: 84.934656
Month: 5    effectivness: 81.53726976
Month: 6    effectivness: 78.2757789696
Month: 7    effectivness: 75.144747810816
Month: 8    effectivness: 72.13895789838335
Month: 9    effectivness: 69.25339958244801
Month: 10    effectivness: 66.48326359915009
Month: 11    effectivness: 63.82393305518408
Month: 12    effectivness: 61.270975732976716
Month: 13    effectivness: 58.820136703657646
Month: 14    effectivness: 56.46733123551133
Month: 15    effectivness: 54.20863798609088
Month: 16    effectivness: 52.040292466647244
Month: 17    effectivness: 49.95868076798135  DISCARD
*/






