public class RemoveRepete {

    public static void main(String[] args) {
          
      int a = StdIn.readInt(), b;
           
      StdOut.print(a);
      while(!StdIn.isEmpty()){   
        b=StdIn.readInt();
        if(b!=a)
          StdOut.print(" "+ b);
        a=b;
      }      
    }
}