/* Marco Lázaro Sousa Batista
 * Rafael Zuolo Coppini Lima
 * 
 * MSB = leftmost bit;
 * 
 * operacao -> MSB xor TAP = new LSB
 * 
 *  
 */

public class LSFR{
  
  private String register, msb, tap;
  private int T, N;
  
  public LSFR(String seed, int tap){
    register = seed;
    T = tap;
    N = seed.length();
  }
  
  public int step(){
    msb = register.substring(0, 1);
    tap = register.substring(N - T - 1, N - T);
 
    if(msb.equals(tap)){
      register = register.substring( 1, N) + "0";
      return 0;
    }
    else{
      register = register.substring( 1, N) + "1";
      return 1;
    }
  }
  
  public int generate(int k){
    int soma = 0;
    
    for(int i=0; i<k; i++){
      soma = 2*soma + this.step();
    }
    return soma;
  }
  
  public String toString(){
    return register;
  }
  
  public static void main(String[] args){
    LSFR teste = new LSFR(args[0], Integer.parseInt(args[1]));
    int b;
    
    b = teste.generate(5);
    System.out.println(teste + "\n" + b);
    
    b = teste.generate(5);
    System.out.println(teste + "\n" + b);
    
     b = teste.generate(5);
    System.out.println(teste + "\n" + b);
  }
}