public class ConnectFour {

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
      
      int MAX_ant = 0, MAX = 0;

//Contar as sequencias nas linhas
      
      for(int i=0; i<N; i++){
        
        MAX_ant = 0;
        
        for(int j=0; j<N; j++){
          if(grid[i][j]=='X') 
            MAX_ant++;
          else{            
            if(MAX_ant > MAX) MAX=MAX_ant;
            MAX_ant=0;
          }          
        }
        if(MAX_ant > MAX)
          MAX=MAX_ant;                 
      }
      
//Contar as sequencias nas colunas       
      
      for(int i=0; i<N; i++){
       
        MAX_ant = 0;
        
        for(int j=0; j<N; j++){
          if(grid[j][i]=='X') 
            MAX_ant++;
          else{            
            if(MAX_ant > MAX) MAX=MAX_ant;
            MAX_ant=0;
          }          
        }
        if(MAX_ant > MAX)
          MAX=MAX_ant;          
      }
      
//Contar as sequencias nas diagonais principais
      
      { 
        int diag=0;
      
        while(diag<N){
          MAX_ant=0;
          int i=diag,j;
          for(j=0; i<N && j<N ;){          
            if(grid[i][j]=='X') 
              MAX_ant++;
            else{            
              if(MAX_ant > MAX) MAX=MAX_ant;
              MAX_ant=0;
            }
            i++;
            j++;                    
          }
          if(MAX_ant > MAX){
            MAX=MAX_ant;
            MAX_ant=0;
          }
          diag++;
        }
        
        diag=1;
       
        while(diag<N){
         
          MAX_ant=0;
          int i,j=diag;
          
          for(i=0; i<N && j<N ;){            
            if(grid[i][j]=='X') 
              MAX_ant++;
            else{            
              if(MAX_ant > MAX) MAX=MAX_ant;
              MAX_ant=0;
            }
            i++;
            j++;                    
          }
          if(MAX_ant > MAX){
            MAX=MAX_ant;
            MAX_ant=0;
          }
          diag++;
        }
      }
      
//Contar as sequencias nas diagonais secundárias
      
      {
        int diag=0;
        
        while(diag<N){
          
          int i=diag, j;
          
          for(j=N-1; j>=0 && i<N;){
            if(grid[i][j]=='X')
              MAX_ant++;
            else{
              if(MAX_ant>MAX)
                MAX=MAX_ant;
              MAX_ant=0;
            }
            i++;
            j--;
          }
          diag++;
          if(MAX_ant>MAX)
            MAX=MAX_ant;
          MAX_ant=0;
        }
      }
      {
        int diag=N-1;
     
        while(diag>=0){
         
          int i=0, j;
          
          for(j=diag; j>=0 && i<N;){
            if(grid[i][j]=='X')
              MAX_ant++;
            else{
              if(MAX_ant>MAX)
                MAX=MAX_ant;
              MAX_ant=0;
            }
            i++;
            j--;        
          }
          diag--;
          if(MAX_ant>MAX)
            MAX=MAX_ant;
          MAX_ant=0;
        }
      } 
      System.out.println("A maior sequencia de X eh: "+MAX);
    }
}
