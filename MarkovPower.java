// ele da print da probabilidade do elemento args[1], e fala a posição dele em relacao as outras paginas;
// args [0] é o numero de iteracoes do Markov Power Method
// lembrar de usar o < arquivo.txt para ele ler o input
// ateh agora se vc adicionar um link da sua pagina 23 para a 11, ou para o 47, ela vai para o ranking 3
public class MarkovPower { 
  public static void main(String[] args) {
    int N = StdIn.readInt(); // # number of pages
    int count=0;
    int rank = 0;

    double[][] matriz = new double[N][N]; // #a matriz de probabilidades
    double[] auto_vetor = new double[N]; // # o autovetor das probabilidades
    double[] temp = new double[N];       // um vetor temporário
    auto_vetor[0] = 1.0;
    
    int[][] counts = new int[N][N]; // # links from page i to j
    int[] outDegree = new int[N]; // # links from page
    // accumulate link counts
    while (!StdIn.isEmpty()) {
      int i = StdIn.readInt();
      int j = StdIn.readInt();
      outDegree[i]++;
      counts[i][j]++;
    }
    // get transition matrix
    StdOut.println(N);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        matriz[i][j] = .90*counts[i][j]/outDegree[i] + .10/N;        
      }
    }
    
    // começa as iterações do vetor com a matriz
    while(count < Integer.parseInt(args[0]))
    {
      for(int i=0; i<N; i++)
        temp[i]=auto_vetor[i];
      
      for (int i=0; i<N; i++){
        double soma = 0;
      
      for(int j=0; j<N; j++){        
        soma += temp[j]*matriz[j][i];
      }   
      auto_vetor[i]=soma;      
      }
      count ++;
    }
    
    StdOut.println(N);
    count = Integer.parseInt(args[1]);
    StdOut.println(auto_vetor[count]);
    for(int i=0; i<N; i++)
      if(auto_vetor[i]>=auto_vetor[count])
        rank++;
       
    StdOut.print("O rank " + count + " eh " + rank);  
    
  }
}