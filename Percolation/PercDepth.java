public class PercDepth {

    // given an N-by-N matrix of open sites, return an N-by-N matrix
    // of sites reachable from the top
    public static boolean[][] flow(boolean[][] open) {
        int N = open.length;
        boolean[][] full = new boolean[N][N];
        for (int j = 0; j < N; j++) {
            flow(open, full, 0, j);
        }
        return full;
    }

    // determine set of full sites using depth first search
    public static void flow(boolean[][] open, boolean[][] full, int i, int j) {
        int N = open.length;

        // base cases
        if (i < 0 || i >= N) return;    // invalid row
        if (j < 0 || j >= N) return;    // invalid column
        if (!open[i][j]) return;        // not an open site
        if (full[i][j]) return;         // already marked as full

        // mark i-j as full
        full[i][j] = true;

        flow(open, full, i+1, j);   // down
        flow(open, full, i, j+1);   // right
        flow(open, full, i, j-1);   // left
        flow(open, full, i-1, j);   // up
    }


    // how much the system percolates?
    public static int depth(boolean[][] open) {
      int N = open.length;
      boolean[][] full = flow(open);
      for(int i=N-1; i>=0; i--)
        for (int j = 0; j < N; j++) {
          if (full[i][j]) return i;
      }
      return -1;
    }

    // draw the N-by-N boolean matrix to standard draw
    public static void show(boolean[][] a, boolean which) {
        int N = a.length;
        StdDraw.setXscale(-1, N);
        StdDraw.setYscale(-1, N);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (a[i][j] == which)
                    StdDraw.filledSquare(j, N-i-1, .5);
    }

    // return a random N-by-N boolean matrix, where each entry is
    // true with probability p
    public static boolean[][] random(int N, double p) {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = StdRandom.bernoulli(p);
        return a;
    }

    // test client
    public static void main(String[] args) {
        boolean[][] open = StdArrayIO.readBoolean2D();
        StdArrayIO.print(flow(open));
        StdOut.println(depth(open));
    }

}