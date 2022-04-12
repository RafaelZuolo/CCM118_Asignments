public class MatrizEquals {

  public static boolean eq(int[] a, int[] b) {

        // same length?
        if (a.length != b.length) return false;

        // check each corresponding pair
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }

        // all elements must be equal
        return true;
  }

  public static boolean Meq(int[][] a, int[][] b){

    if(a.length != b.length) return false;

    for(int i=0; i < a.length; i++){
      if(!eq(a[i], b[i])) return false;
    }
    // metodo parecido com o eq
    return true;
  }

  public static void main(String[] args){
    int M=10, N=15;
    int[][] Ma = new int[M][N];
    int[][] Mb = new int[M][N];
    int[][] Mc = new int[M+1][N];

    for(int i=0; i<M; i++){
      for(int j=0; j<N; j++){
        Ma[i][j]=10*i+j;
        Mb[i][j]=Ma[i][j];
      }
    }

    StdOut.println(Meq(Ma, Mb));
    StdOut.println(Meq(Ma, Mc));
    StdOut.println(Meq(Mc, Mc));
  }
}
