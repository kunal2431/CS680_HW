package umbcs680.colorfilter;

public class Images{

   public Images(){ }

   public static Image transform(Image image, ColorAdjuster adjuster){
       Image adjusted = new Image(image.getHeight(), image.getWidth());
       for(int i=0; i<adjusted.getHeight();i++){
           for(int j=0; j< adjusted.getWidth(); j++){
               adjusted.setColor(i, j, adjuster.adjust(image.getColor(i, j)));
           }
       }
       return adjusted;
   }

}