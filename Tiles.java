//programa funciona com as cores: azul, verde, preto, branco, cinza, vermelho, laranja, ciano
//preguiça de colocar mais cores :P

/* o primeiro args N (int) define a matriz NxN do piso;
 * o segundo args(String) define se é xadrez ou nao: escreva "xadrez" ou qualquer outra coisa para nao-xadrez;
 * os quatro próximos args definem as cores da tile (3 primeiros) e a cor do xadrez (ultimo)
 * o sétimo e último arg le um int entre 0 e 3 e define qual tile entre as 4 disponíveis vai ser usada
 * 
 * exemplo do que foi colocado para executar:
 * 
 * java-introcs Tiles 8 xadrez azul verde cinza verde 3
 * 
 * java-introcs Tiles 8 naoxadrez azul verde cinza verde 3
 * 
 * java-introcs Tiles 8 asçlfkdçlkfds azul verde cinza verde 3
 * 
 * java-introcs Tiles 8 xadrez azul verde cinza azul 1
 */

public class Tiles {
  public static void main(String[] args) {  
    
    java.awt.Color A=StdDraw.BLUE, B=StdDraw.GRAY, C=StdDraw.WHITE, X=StdDraw.BLACK;
    double Escala = Double.parseDouble(args[0])*4.0;
    
    int NX=0, NY=0;
    
    StdDraw.setXscale(0.0, Escala);
    StdDraw.setYscale(0.0, Escala);    
     
    if(args[2] .equals("azul")) A=StdDraw.BLUE;
    if(args[2] .equals("verde")) A=StdDraw.GREEN;
    if(args[2] .equals("preto")) A=StdDraw.BLACK;
    if(args[2] .equals("branco")) A=StdDraw.WHITE;
    if(args[2] .equals("cinza")) A=StdDraw.GRAY;
    if(args[2] .equals("vermelho")) A=StdDraw.RED;
    if(args[2] .equals("laranja")) A=StdDraw.ORANGE;
    if(args[2] .equals("ciano")) A=StdDraw.CYAN;
    
    if(args[3] .equals("azul")) B=StdDraw.BLUE;
    if(args[3] .equals("verde")) B=StdDraw.GREEN;
    if(args[3] .equals("preto")) B=StdDraw.BLACK;
    if(args[3] .equals("branco")) B=StdDraw.WHITE;
    if(args[3] .equals("cinza")) B=StdDraw.GRAY;
    if(args[3] .equals("vermelho")) B=StdDraw.RED;
    if(args[3] .equals("laranja")) B=StdDraw.ORANGE;
    if(args[3] .equals("ciano")) B=StdDraw.CYAN;
    
    if(args[4] .equals("azul")) C=StdDraw.BLUE;
    if(args[4] .equals("verde")) C=StdDraw.GREEN;
    if(args[4] .equals("preto")) C=StdDraw.BLACK;
    if(args[4] .equals("branco")) C=StdDraw.WHITE;
    if(args[4] .equals("cinza")) C=StdDraw.GRAY;
    if(args[4] .equals("vermelho")) C=StdDraw.RED;
    if(args[4] .equals("laranja")) C=StdDraw.ORANGE;
    if(args[4] .equals("ciano")) C=StdDraw.CYAN;
    
    if(args[5] .equals("azul")) X=StdDraw.BLUE;
    if(args[5] .equals("verde")) X=StdDraw.GREEN;
    if(args[5] .equals("preto")) X=StdDraw.BLACK;
    if(args[5] .equals("branco")) X=StdDraw.WHITE;
    if(args[5] .equals("cinza")) X=StdDraw.GRAY;
    if(args[5] .equals("vermelho")) X=StdDraw.RED;
    if(args[5] .equals("laranja")) X=StdDraw.ORANGE;
    if(args[5] .equals("ciano")) X=StdDraw.CYAN;
     
    StdDraw.setPenColor(A);
    StdDraw.filledSquare(Escala/2, Escala/2, Escala/2);
    
    
    for(NY=0; NY<Escala; NY+=4)
      for(NX=0; NX<Escala; NX+=4)
    {      
      
      if(Integer.parseInt(args[6])==0)
      {
// Desenha o losango cinza do meio
        {
          StdDraw.setPenColor(B);
          
          double[] PolX = {2.0 + NX, 4.0 + NX, 2.0 + NX, 0.0 + NX};
          double[] PolY = {0.0 + NY, 2.0 + NY, 4.0 + NY, 2.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }
        //Desnha os triangulos brancos
        {
          StdDraw.setPenColor(C);
          
          double[] PolX = {1.0 + NX, 1.0 + NX, 0.0 + NX};
          double[] PolY = {0.0 + NY, 1.0 + NY, 1.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }
        {
          double[] PolX = {3.0 + NX, 4.0 + NX, 3.0 + NX};
          double[] PolY = {0.0 + NY, 1.0 + NY, 1.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }
        {
          double[] PolX = {3.0 + NX, 4.0 + NX, 3.0 + NX};
          double[] PolY = {3.0 + NY, 3.0 + NY, 4.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }
        {
          double[] PolX = {0.0 + NX, 1.0 + NX, 1.0 + NX};
          double[] PolY = {3.0 + NY, 3.0 + NY, 4.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }    
      }
    //outra opção de Tile (se fosse que nem C dava para usar função ao inves de colar aki uma a uma
      if(Integer.parseInt(args[6])==1)
      {
        //Desenha os retângulos brancos
        {
          StdDraw.setPenColor(B);
          
          double[] PolX = {1.0 + NX, 4.0 + NX, 3.0 + NX, 0.0 + NX};
          double[] PolY = {0.0 + NY, 3.0 + NY, 4.0 + NY, 1.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }
        {
          double[] PolX = {3.0 + NX, 0.0 + NX, 1.0 + NX, 4.0 + NX};
          double[] PolY = {0.0 + NY, 3.0 + NY, 4.0 + NY, 1.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }
// Desenha o losango cinza do meio
        {
          StdDraw.setPenColor(C);
          
          double[] PolX = {2.0 + NX, 4.0 + NX, 2.0 + NX, 0.0 + NX};
          double[] PolY = {0.0 + NY, 2.0 + NY, 4.0 + NY, 2.0 + NY};
          
          StdDraw.filledPolygon(PolX, PolY);
        }
      }
      //outra opçao de Tile
      if(Integer.parseInt(args[6])==2)
      {
        //Desnha os quadrados brancos
      StdDraw.setPenColor(C);
      StdDraw.filledSquare(0.0 + NX, 0.0 + NY, 1);//um truque para tirar as linhas de divisao
      StdDraw.filledSquare(0.0 + NX, 4.0 + NY, 1);// de cada Tile
      StdDraw.filledSquare(4.0 + NX, 4.0 + NY, 1);
      StdDraw.filledSquare(4.0 + NX, 0.0 + NY, 1); 
    
// Desenha o losango cinza do meio
      {
        StdDraw.setPenColor(B);
        
        double[] PolX = {2.0 + NX, 4.0 + NX, 2.0 + NX, 0.0 + NX};
        double[] PolY = {0.0 + NY, 2.0 + NY, 4.0 + NY, 2.0 + NY};
        
        StdDraw.filledPolygon(PolX, PolY);
      }
    }
    //A ultima opção de Tile (ufa)
    if(Integer.parseInt(args[6])==3)
    {
      //Desnha os retângulos brancos
      {
        StdDraw.setPenColor(C);
        
        double[] PolX = {1.0 + NX, 4.0 + NX, 3.0 + NX, 0.0 + NX};
        double[] PolY = {0.0 + NY, 3.0 + NY, 4.0 + NY, 1.0 + NY};
        
        StdDraw.filledPolygon(PolX, PolY);
      }
      {
        double[] PolX = {3.0 + NX, 0.0 + NX, 1.0 + NX, 4.0 + NX};
        double[] PolY = {0.0 + NY, 3.0 + NY, 4.0 + NY, 1.0 + NY};
        
        StdDraw.filledPolygon(PolX, PolY);
      }
// Desenha o losango cinza do meio
      {
        StdDraw.setPenColor(B);
        
        double[] PolX = {2.0 + NX, 4.0 + NX, 2.0 + NX, 0.0 + NX};
        double[] PolY = {0.0 + NY, 2.0 + NY, 4.0 + NY, 2.0 + NY};
        
        StdDraw.filledPolygon(PolX, PolY);
      }
// Desenha os quadrados dos cantos usando o truque para tirar as linhas de divisao
      StdDraw.filledSquare(0.0 + NX, 0.0 + NY, 1);
      StdDraw.filledSquare(0.0 + NX, 4.0 + NY, 1);
      StdDraw.filledSquare(4.0 + NX, 4.0 + NY, 1);
      StdDraw.filledSquare(4.0 + NX, 0.0 + NY, 1); 
    }
    }
    
    if(args[1].equals("xadrez")){
      StdDraw.setPenColor(X);
      int inicio=0;
      for(NY=0; NY<Escala; NY+=4){
        if(NY%8==0)inicio=4;
        else inicio=0;
        for(NX=inicio; NX<Escala; NX+=8)
          StdDraw.filledSquare(2.0+NX, 2.0+NY, 2.0);
      }
    }
    
  }
} 