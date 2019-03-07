//Imutable. 

// See:
// - https://stackoverflow.com/questions/6044923/generic-pair-class
// - https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html

class Pair<A,B>{
  public final A a;
  public final B b;
  public Pair(A a,B b){
    this.a = a;
    this.b = b;
  }
}
