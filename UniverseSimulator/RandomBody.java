public class RandomBody{
  private Body myBody;
  
  public RandomBody(int a){
//  decides if it will be a big body or not
    if(a == 0){ //big body
      double dMass = StdRandom.gaussian(2e30, 5e25);
      double dSpeed = 0*StdRandom.gaussian(0, 1e1);
      double dPosition = StdRandom.gaussian (0, 1e1);
      double dAngleSp = StdRandom.uniform(0, 2.0);
      double dAnglePo = StdRandom.uniform(0, 2.0);
      myBody = new Body(new Vector(new double[]{Math.sin(dAnglePo*Math.PI)*dPosition, Math.cos(dAnglePo*Math.PI)*dPosition}),
                        new Vector(new double[]{Math.sin(dAngleSp*Math.PI)*dSpeed, Math.cos(dAngleSp*Math.PI)*dSpeed}), dMass);
    }
    else{ //small body
      double dMass = StdRandom.gaussian(5e26, 1e26);
      double dSpeed = StdRandom.gaussian(3e6, 3e5);
      double dPosition = StdRandom.gaussian (1e7, 8e6);
      double dAngleSp = StdRandom.uniform(0, 2.0);
      double dAnglePo = StdRandom.uniform(0, 2.0);
      myBody = new Body(new Vector(new double[]{Math.sin(dAnglePo*Math.PI)*dPosition, Math.cos(dAnglePo*Math.PI)*dPosition}),
   new Vector(new double[]{Math.sin(dAngleSp*Math.PI)*dSpeed, Math.cos(dAngleSp*Math.PI)*dSpeed}), dMass);
    }
  }
  
  public void move(Vector f, double dt){
    myBody.move(f, dt);
  }
  
  public Vector forceFromRandom(RandomBody b){
    return myBody.forceFrom(b.toBody());
  }
  
  public void draw(){
    myBody.draw();
  }
  
  public Body toBody(){
    return myBody;
 }
  
  public static void main(String[] args){
    int N = Integer.parseInt(args[0]);
    StdDraw.setScale(-10e6, 10e6);
    for(int i=0; i < N; i++){
      RandomBody b = new RandomBody(0);
      b.draw();
    }
    StdOut.println(N);
  }  
}

