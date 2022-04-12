public class ConnectFourMC {
// Programa gerador da matriz
    public static void main(String[] args) {
      
      int N = Integer.parseInt (args[0]);
      char[][] grid = new char[N][N];
      
      for(int i=0; i<N; i++)
        for(int j=0; j<N; j++){
           double rand = Math.random()*3;
           if(rand<1)      grid[i][j]=' ';
           else if(rand<2) grid[i][j]='X';
           else if(rand<3) grid[i][j]='O';
        }
      for(int i=0; i<N; i++){
        for(int j=0; j<N; j++)
          System.out.print(grid[i][j]+" ");
        System.out.print("\n");
      }
     
/***************Aqui foi gerada a matriz********************/    
      
    }
}
