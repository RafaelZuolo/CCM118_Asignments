// Marco Lázaro Sousa Batista
// Rafael Zuolo Coppini Lima
//  
//Gerador de labirintos perfeitos pelo metodo Divide and Conquest
//
//  Execução: java MazeGenerator <int> <int>
// Args[0] = largura, args[1] = altura do labirinto
//  
//  dependencias: StdDraw, StdRandom, StdOut



public class MazeGenerator{  
  
  public static void chamber(int iX, int iY, int fX, int fY, double penradius){
  
    if(fX-iX <=1 || fY-iY <=1) return;
    else{
      int random_X = StdRandom.uniform(iX+1, fX);
      int random_Y = StdRandom.uniform(iY+1, fY);
      
      StdDraw.setPenColor(StdDraw.BLACK);              // traçar as duas paredes principais
      StdDraw.line(iX, random_Y, fX, random_Y);
      StdDraw.line(random_X, iY, random_X, fY);
      
      int r = StdRandom.uniform(4);                 // selecionar 3 paredes para ter buraco = selecionar uma para nao ter
      
      StdDraw.setPenColor(StdDraw.WHITE);
      
      if(r!=0){                                                           // parede sul
        int p = StdRandom.uniform(iY, random_Y);
        StdDraw.line(random_X, p + penradius, random_X, p+1 - penradius);
      }
      if(r!=1){                                                          // parede leste
        int p = StdRandom.uniform(random_X, fX);
        StdDraw.line(p + penradius, random_Y, p+1 - penradius, random_Y);
      }
      if(r!=2){                                                          // parede norte
        int p = StdRandom.uniform(random_Y, fY);
        StdDraw.line(random_X, p + penradius, random_X, p+1 - penradius);
      }
      if(r!=3){                                                          // parede oeste 
        int p = StdRandom.uniform(iX, random_X);
        StdDraw.line(p + penradius, random_Y, p+1 - penradius, random_Y);
      }
    
      chamber(iX, iY, random_X, random_Y, penradius);
      chamber(random_X, iY, fX, random_Y, penradius);
      chamber(random_X, random_Y, fX, fY, penradius);
      chamber(iX, random_Y, random_X, fY, penradius);
    }
  }
  
  public static void main(String[] args){
    
    int max_X = Integer.parseInt(args[0]);
    int max_Y = Integer.parseInt(args[1]);    
    double penradius = .1;                    // esse pen radius é usado para corrigir pequenos erros
                                              // quando a função chamber pinta uma parede de branco
    StdDraw.setCanvasSize(max_X*10, max_Y*10);
    StdDraw.setXscale(0, max_X);
    StdDraw.setYscale(0, max_Y);
    StdDraw.rectangle(((double)max_X)/2, ((double)max_Y)/2, ((double)max_X)/2, ((double)max_Y)/2);
    
    chamber(0, 0, max_X, max_Y, penradius);
    
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(0, penradius, max_X, penradius);
    StdDraw.line(max_X - penradius, 0, max_X - penradius, max_Y);
    StdOut.println("Labirinto gerado");
  }
}