/* Precismos de N>10
* lembrar que também pecisamos de um numero suficiente de links para que nenhum
* site tenha zero links, o que atrapalharia na geração da matriz de transição
* (dividir po zero).
* Consideramos entao que os hubs tem um link deles para outra pagina aleatoria.
* e que as authorities recebem um link de uma pagina aleatoria para eles.
*
* Dessa forma fica óbvio que os Hubs vao crescer em rank mais rapido, pois recebem
* mais links e serao mais acessados pelo surfista aleatorio.
*/
public class Hubs {

  public static int IntRandom(int a){   //devolve inteiro entre [0,a[
    double x = a * Math.random();
    return((int)x);
  }

  public static boolean elemento_igual(int a, int[] vet){
    for(int i=0; i< a; i++){
      if(i==a) continue;
      if(vet[a]==vet[i]) return true;
    }
    return false;
  }

  public static void main(String[] args){

    int N=StdIn.readInt(), M=StdIn.readInt(), Hubs=StdIn.readInt(), Aut=StdIn.readInt();
    StdOut.print((N+Hubs+Aut) + "\n");

    for(int i=0; i<M; i++){
      StdOut.println(IntRandom(N)+" "+IntRandom(N));// geramos os M links aleatorios
    }

    // vamos começar a gerar os Hubs
    for(int i=0; i<Hubs; i++)
      StdOut.println((N+i)+" "+IntRandom(N));  //adicionando um link em cada hubs

    for(int i=0; i<Hubs; i++){
      int[] link = new int[N/10];                // lembrar que precisamos de mais de 10 links
      link[0]=IntRandom(N);
      StdOut.println(link[0]+" "+ (N+i));        //já colocar o caso inicial facilita a logica
                                                // para gerar os 10% das paginas distintas
      for(int j=1; j<N/10;){
        link[j]=IntRandom(N);

        if(elemento_igual(j, link)) continue;

        StdOut.println(link[j] + " " + (N+i));
        j++;
      }
    }
    // Agora vamos fazer as Authoritys
    for(int i=0; i<Aut; i++)
      StdOut.println(IntRandom(N) + " " + (N+Hubs+i));  //adicionando um link para cada Aut

    for(int i=0; i<Aut; i++){
      int[] link = new int[N/10];                // lembrar que precisamos de mais de 10 links
      link[0]=IntRandom(N);                      //já colocar o caso inicial facilita a logica
      StdOut.println((N+Hubs+i) + " " + link[0]);  // para gerar os 10% das paginas distintas

      for(int j=1; j<Aut;){
        link[j]=IntRandom(N);

        if(elemento_igual(j, link)) continue;

        StdOut.println((N+Hubs+i) + " " + link[j]);
        j++;
      }
    }
  }
}
