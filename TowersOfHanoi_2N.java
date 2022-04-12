public class TowersOfHanoi_2N {
  
  public static void moves_L(int n, boolean left) {  //Mover a pilha de discos para a esquerda
    if (n == 0) return;                              
    moves_L(n-1, !left);
    if (left) StdOut.println(n + " L");
    else      StdOut.println(n + " R");
    moves_L(n-1, !left);
  }
  
  public static void moves_R(int n, boolean right) {  //Mover a pilha de discos para a direita 
    if (n == 0) return;                             
    moves_R(n-1, !right);
    if (right) StdOut.println(n + " R");
    else       StdOut.println(n + " L");
    moves_R(n-1, !right);
  }
  
  public static void main(String[] args) {
    
    int N = Integer.parseInt(args[0]);
    
    for(int i=1; i < 2*N - 1; i++){
      if(i%2==0) moves_R(i, true);
      else       moves_L(i, true);        
    }  
    
    moves_L(2*N-2, true);                 // montamos todos os discos 2N-2 no pino da direita, em cima do 2N
    StdOut.println((2*N-1) + " R");       // mover o disco 2N-1 para o pino do meio para montar a pilha em cima dele
    moves_L(2*N-2, true);
    StdOut.println(2*N + " R");           // colocando o disco 2N no pino da esquerda
    moves_R(2*N-1, true);                 // movendo a pilha com 2N-1 discos para o pino da direita
    
    for(int i=2*N-2; i>0; i--){
      if(i%2==0) moves_R(i, true);
      else       moves_L(i, true);
    }
  }
}