//Definição, true = fechado; false = aberto

public class Lockers {

    public static void main(String[] args) {
      
      int N = 100;
      boolean[] cofre = new boolean[N];
      
      for(int i=2; i<=N; i++)
        for(int j=0; j<N; j++)
           if((j+1)%i==0)
             cofre[j]=!cofre[j];
      for(int j=0; j<N; j++)
        if(!cofre[j]) System.out.println("cofre "+(j+1)+" esta aberto");
    }
}
/*Apenas os cofres que são quadrados perfeitos ficam abertos
 * porque esse números tem uma quantidade par de divisores
 * maiores que 1, e voltam a ficar abertos, enquanto os nao quadrados perfeitos tem uma quantidade
 * impar de divisores, e terminam fechados, ex: m{6}=2, 3, 6 - 3 divisores; m{16}=2, 4, 8, 16 - 4 divisores*/