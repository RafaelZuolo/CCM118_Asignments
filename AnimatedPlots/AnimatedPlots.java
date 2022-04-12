// colocar segundo argumento do programa como 0 para ser Bars ou 1 para ser Lines
public class AnimatedPlots  {

    public static void main(String[] args) {
      
      int N=Integer.parseInt(args[0]), T=10;
      double[] vet=new double[N];

      StdDraw.setYscale(0,10);
      
      while(!StdIn.isEmpty())
      {       
        vet[N-1] = StdIn.readDouble();  
      
        StdDraw.setPenColor(StdDraw.BLACK);
        if(Integer.parseInt(args[1])==0) StdStats.plotBars(vet);
        else                             StdStats.plotLines(vet);
        StdDraw.show(T);
        
        StdDraw.clear(StdDraw.WHITE);
        
        for(int i=0; i<N-1; i++)
        {
          vet[i]=vet[i+1];
        }
      }
    }
}
