public class Ordercheck {

    public static void main(String[] args) {
      
      double x0=Double.parseDouble(args[0]);
      double x1=Double.parseDouble(args[1]);
      double x2=Double.parseDouble(args[2]);
      System.out.print((x0<x1) && (x1<x2));
    }
}