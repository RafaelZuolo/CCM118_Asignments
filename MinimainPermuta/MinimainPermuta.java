public class MinimainPermuta {
    // Programa que calcula a media de M vetores de tamanho N
    public static void main(String[] args) {
      
      int M = Integer.parseInt(args[0]);
      double media=0;
      int N = Integer.parseInt (args[1]);
      int[] per = new int[N];
      
      for(int j=0; j<M; j++){
        
        for(int i=0; i<N; i++)
        per[i]=i;
        
        for(int i=0; i<N-1; i++){
          int k = per[i];
          int rand =(int) (i + Math.random()*(N-i));
          per[i]=per[rand];
          per[rand]=k;
        }
        
        int MiP = 1;
        int minimo=per[0];      
        for(int i=1; i<N; i++){
          if(minimo>per[i]){
            minimo=per[i];
            MiP++;
          }            
        }
        media+=MiP;
      }
      media=media/M;
      System.out.println("A media de "+M+" permutacoes de um vetor de tamanho "+N+ " eh: " +media);
    }
}
