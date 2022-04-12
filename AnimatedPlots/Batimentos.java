// Experimente colocar no args[1] valores como 1, 2 e 0.5
public class Batimentos {

  public static void main(String[] args) {
    
    int T = Integer.parseInt(args[0]);
    double s = Double.parseDouble(args[1]);
    for (double i = 0; i < T; i+=0.01) {
      double x = 5 + (Math.sin(30*i*s) + Math.sin(33*i*s));
      StdOut.println(x);
    }
  }
}