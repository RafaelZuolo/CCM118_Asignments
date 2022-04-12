public class MinimainPermuta_parte_um {
    // Programa que calcula o MinimaPerutacoes de um vetor de tamanho N
    public static void main(String[] args) {
      
      int N = Integer.parseInt(args[0]);
      
      int[] per = new int[N];
      
      
        
        for(int i=0; i<N; i++)
        per[i]=i;
// inicializando o vetor
        for(int i=0; i<N-1; i++){
          int k = per[i];
          int rand =(int) (i + Math.random()*(N-i));
          per[i]=per[rand];
          per[rand]=k;
        }
        
//vetor foi "embaralhado" aki
        for(int i=0; i<N; i++)
          System.out.print(" " + per[i]);
//Printando o vetor permutado
        int MiP = 1;
        int minimo=per[0];      
        for(int i=1; i<N; i++){
          if(minimo>per[i]){
            minimo=per[i];
            MiP++;
          }            
        }
       
      System.out.println("\nA Minima permutacaos do vetor de tamanho "+N+ " foi: " +MiP);
    }
}
