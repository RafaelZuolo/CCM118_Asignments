// Enganando a receita federal simulando a lei de Benford
// para termos as probabilidades usamos as frequencias do primeiro digito dos
// numeros de fibonacci
// obs: nao entendi como usar aquele extractCSV.java
public class IRFfoiler {

  public static int intRandom(int a){        // gera um numero aleatorio [0,a[
    return ((int) (a*Math.random()));
  }

  public static int geraBenford(int x){     // como sao poucos numeros, podemos ficar gerando numeros ate
    int a = intRandom(1000), Ben=a;         // termos um que comece com o digito desejado
    while(a!=x){
      a = intRandom(1000);
      Ben = a;
      while(a>10) a/=10;
    }
    return Ben;
  }

  public static void main(String[] args){
    int N = 1000;//(int)(Math.random()*1000);    //quantidade aleatoria (1 a 999) de numeros aleatorios serao gerados

    for(int i=0; i<N; i++){
      double prob = Math.random();

      if     (prob<0.301) StdOut.print(geraBenford(1)+" \n");    // prob digito 1
      else if(prob<0.477) StdOut.print(geraBenford(2)+" \n");    // prob 2
      else if(prob<0.602) StdOut.print(geraBenford(3)+" \n");    // prob 3
      else if(prob<0.699) StdOut.print(geraBenford(4)+" \n");    // prob 4
      else if(prob<0.778) StdOut.print(geraBenford(5)+" \n");    // prob 5
      else if(prob<0.845) StdOut.print(geraBenford(6)+" \n");    // prob 6
      else if(prob<0.903) StdOut.print(geraBenford(7)+" \n");    // prob 7
      else if(prob<0.953) StdOut.print(geraBenford(8)+" \n");    // prob 8
      else if(prob<0.999) StdOut.print(geraBenford(9)+" \n");    // prob 9
    }
  }
}
