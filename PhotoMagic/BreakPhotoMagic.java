// Marco Lázaro Sousa Batista
// Rafael Zuolo Coppini Lima
//
// execução:
//            java-introcs BreakPhotoMagic <imagem (String)> < Tamanho da Senha (int)>
//
// Dependencias: Color.java; Picture.java; LSFR.java; 
// 

import java.awt.Color;

public class BreakPhotoMagic{
  
  public static void main(String[] args){
    String name = args[0];
    Picture photo = new Picture (name);
    int max_senha = Integer.parseInt(args[1]), teste_tap, breaked_tap = 0;
    int n_colunas = 1;                                              // para deixar o programa mais rapido decodificamos 
    double max_desvio = 0;                                          // apenas uma coluna da foto para extrair o desvio de cores
    String senha = new String(), breaked = new String();
    
    for(int k = 0; k < Math.pow(2,max_senha); k++){                 // gera as senhas para decodificar
      
      senha = Integer.toBinaryString(k);
      
      while(senha.length() < max_senha)                            // colocar os zeros a esquerda para acertar o tamanho da senha
        senha = "0".concat(senha);
      
      System.out.println(senha);
      for(int l = 0; l < max_senha; l++){                         // permuta os taps possíveis
      
        teste_tap = l;        
        LSFR xor = new LSFR(senha, teste_tap);
        double freq = 0;
        
        for(int i = 0; i < n_colunas; i++){
          for(int j = 0; j < photo.height(); j++){
            Color pixel = photo.get( i, j);
            pixel = new Color(pixel.getRed() ^ xor.generate(8), pixel.getGreen() ^ xor.generate(8), pixel.getBlue() ^ xor.generate(8));
            freq = freq + (pixel.getRed() + pixel.getGreen() + pixel.getBlue())/3;
          }
        }
        freq = freq/(n_colunas*photo.height());         // faz a média das medias  dos pixels

        if(max_desvio < Math.abs(freq-128)){
          max_desvio = Math.abs(freq-128);
          breaked = senha;
          breaked_tap = teste_tap;
        }
      }
    }
    StdOut.println("A senha pode ter sido quebrada!\n ela deve ser: " + breaked + " com tap: " + breaked_tap);
  }
}