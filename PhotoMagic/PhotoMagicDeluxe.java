// Marco Lázaro Sousa Batista
// Rafael Zuolo Coppini Lima
//
// ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/
// o i-ésimo termo dessa sequencia de caracteres eh o i em binario no password
// execução identica ao PhotoMagic, mas o TAP deve ser um intero entre "0" e "(6 * o numero de caracteres)-1"
// mesmas dependencias que o PhotoMagic

import java.awt.Color;
  
public class PhotoMagicDeluxe{
  
  public static String toByte(String in){
    char[] ch = in.toCharArray();
    String mascara = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    String out = new String();
    int index = 0;
    
    for(int i = 0; i < in.length(); i++){
      index = mascara.indexOf(ch[i]);
      String bit = Integer.toBinaryString(index);
      while(bit.length() < 6)
        bit = "0".concat(bit);
      out = out.concat(bit);
    }
    return out;
  }
  
  public static void main(String[] args){
    String name = args[0];
    String password = toByte(args[1]);
    
    Picture photo = new Picture(name);
    int altura = photo.height(), largura = photo.width();
    LSFR xor = new LSFR( password, Integer.parseInt(args[2]));
    
    for(int i = 0; i < largura; i++){
      for(int j = 0; j < altura; j++){
        Color pixel = photo.get( i, j);
        pixel = new Color(pixel.getRed() ^ xor.generate(8), pixel.getGreen() ^ xor.generate(8), pixel.getBlue() ^ xor.generate(8));
        photo.set( i, j, pixel);
      }
    }
    name = "X" + name;
      photo.save(name);
      photo.show();
  }
}