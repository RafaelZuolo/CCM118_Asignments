

public class Depth_eval {

    // do M trials and return fraction that percolate
    public static double eval(int N, double p, int M) {
        int m = 0;
        for (int k = 0; k < M; k++) {
            boolean[][] open = PercDepth.random(N, p);            
            m += PercDepth.depth(open);
        }
        return (double) m / M;
    }


    public static void main(String[] args) {
        int    N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        int    M = Integer.parseInt(args[2]);
        double q = eval(N, p, M);
        StdOut.println(q);
    }
}