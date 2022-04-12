//  forma de usar:
//    java-introcs RandomUniverse <A> <B>
//    onde A é o numero de corpos e B é o dT
//    recomendamos .5 de dT
//    o primeiro corpo a ser gerado é sempre uma estrela de massa grande, e os restantes sao planetas de massa menor
//    isso proprociona uma maior estabilidade dos sistemas

public class RandomUniverse{
  
  private final double radius;           // radius of universe
  private final int N;                   // Number of RandomBodies
  private final RandomBody[] orbs;       // array of N random bodies
  
  // read universe from standard input
  public RandomUniverse(int a) {      
    
    N = a;
    // the set scale for drawing on screen
   radius = 1e8; 
   StdDraw.setXscale(-radius, +radius); 
   StdDraw.setYscale(-radius, +radius);
   
   orbs = new RandomBody[N]; 
   
   // read in the N bodies   
   for (int i = 0; i < N; i++) {  
     orbs[i] = new RandomBody(i); 
   } 
  } 
  
  // increment time by dt units, assume forces are constant in given interval
  public void increaseTime(double dt) {
    
    // initialize the forces to zero
    Vector[] f = new Vector[N];
    for (int i = 0; i < N; i++) {
      f[i] = new Vector(new double[2]);
    }
    
    // compute the forces
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
       if (i != j) {
         f[i] = f[i].plus(orbs[i].forceFromRandom(orbs[j]));
       }
      }
    }
    
    // move the bodies
    for (int i = 0; i < N; i++) {
      orbs[i].move(f[i], dt);
   }
  }
  
  // draw the N bodies
  public void draw() {
    for (int i = 0; i < N; i++) {
     orbs[i].draw();
    }
  } 
  
  
  // client to simulate a universe
  public static void main(String[] args) {
    RandomUniverse newton = new RandomUniverse(Integer.parseInt(args[0]));
    double dt = Double.parseDouble(args[1]);
    while (true) {
      StdDraw.clear();
      newton.increaseTime(dt);
      newton.draw(); 
      StdDraw.show(10); 
    } 
  } 
}
