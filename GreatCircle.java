//uma milha náutica = 1,852 quilômetros
// são paulo até o rio = -23.5635 -46.647 -22.871 -43.236 = 356.7 km aprox
// são paulo até tokyo = -23.5635 -46.647 35.700 139.744 = 18519.4 km aprox
public class GreatCircle {

    public static void main(String[] args) {

      if(args.length > 0)
      {
        double degrees = Double.parseDouble(args[0]);
        double x1 = Math.toRadians(degrees);

        degrees = Double.parseDouble(args[1]);
        double y1 = Math.toRadians(degrees);
        
        degrees = Double.parseDouble(args[2]);
        double x2 = Math.toRadians(degrees);

        degrees = Double.parseDouble(args[3]);
        double y2 = Math.toRadians(degrees);

        double distance = 1.852 * 60 * Math.toDegrees(Math.acos(Math.sin(x1)*Math.sin(x2) +
                                   Math.cos(x1)*Math.cos(x2)*Math.cos(y1-y2)));
        
        System.out.println(distance + " Pela Lei dos cossenos");
        
        double a = Math.pow(Math.sin((x2-x1)/2),2) + Math.cos(x1)*Math.cos(x2)*Math.pow(Math.sin((y2-y1)/2),2);
        distance = 1.852 * 60 * Math.toDegrees( 2 * Math.asin(Math.min(1,Math.sqrt(a))));
        
        System.out.println(distance + " Pelo Havensine");
        
      }
      else
        System.out.println("sao paulo ate Rio = 356.7 km aprox \nSao Paulo ate Tokyo = 18519.4 km aprox");
    }
}
