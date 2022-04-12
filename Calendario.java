public class Calendario {
    public static void main(String[] args) { 
        
      int mes = Integer.parseInt(args[0]);
      int ano = Integer.parseInt(args[1]);
      boolean eh_bissesto = (ano%4 == 0 && ano%100 !=0 || ano%400 == 0);
      
      boolean mes31 = false;  
      if(mes== 1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes== 12) mes31=true;
      
      int ano0 = ano - (14 - mes) / 12;
      int x = ano0 + ano0/4 - ano0/100 + ano0/400;
      int mes0 = mes + 12 * ((14 - mes) / 12) - 2;
      int d0 = (1 + x + (31*mes0)/12) % 7;
        
      String[] nome_mes = {" ", "Janeiro ", "Fevereiro ", "Marco ", "Abril ", "Maio ", "Junho ", "Julho ", "Agosto ",
        "Setembro ", "Outubro ", "Novembro ", "Dezembro "};
      
      System.out.println(nome_mes[mes] + ano + "\n\n D  S  T  Q  Q  S  S\n");
      
      for(x=d0; x > 0; x--)
        System.out.print("   ");
      
      for(x=1; x<32; x++){
       
        if(d0==7){
          System.out.print("\n");
          d0=0;
        }
        if(x<10) System.out.print(" " + x + " ");
        else     System.out.print(" " + x);
        if(mes==2 && eh_bissesto && x==29) x=33;
        if(mes==2 && !eh_bissesto && x==28) x=33;
        if(!mes31 && x==30) x=33;
        d0++;
      }
      System.out.print("\n");
    }
}