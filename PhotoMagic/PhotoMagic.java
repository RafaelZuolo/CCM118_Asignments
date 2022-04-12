// Marco Lázaro Sousa Batista
// Rafael Zuolo Coppini Lima

//  Modo de execucao:
//    
//  java-introcs PhotoMagic <nome do arquivo> <senha(String de "0" e "1")> <tap da senha(int entre 0 e numero de bits menos um)>
//  dependencias: Color.java; Picture.java; LSFR.java; 
//    
    
import java.awt.Color;
  
public class PhotoMagic{
  
  public static void main(String[] args){
    String name = args[0];
    Picture photo = new Picture (name);
    LSFR xor = new LSFR(args[1], Integer.parseInt(args[2]));
    
    for(int i = 0; i < photo.width(); i++){  // passar por todos os pixels
      for(int j = 0; j < photo.height(); j++){
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