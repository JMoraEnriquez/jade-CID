package examples.simplelinearregresion;

public class SumHelper{

    public double sumatoriaXY(int[] x, int[] y){
        double respuesta = 0;
        for(int i=0; i<9; i++){
          respuesta = respuesta + (9 * x[i] * y[i]);
        }
        //System.out.println("sumatoriaXY = " + respuesta);
        return respuesta; 
      }
  
      public double sumatoriaX(int[] x){
        double respuesta = 0;
        for(int i=0; i<9; i++){
          respuesta = respuesta + x[i];
        }
        //System.out.println("sumatoriaX = " + respuesta);
        return respuesta; 
      }
  
      public double sumatoriaY(int[] y){
        double respuesta = 0;
        for(int i=0; i<9; i++){
          respuesta = respuesta + y[i];
        }
        //System.out.println("sumatoriaY = " + respuesta);
  
        return respuesta; 
      }
  
      public double sumatoriaXX(int[] x){
        double respuesta = 0;
        for(int i=0; i<9; i++){
          respuesta = respuesta + (9 * (x[i] * x[i]));
        }
        //System.out.println("sumatoriaXX = " + respuesta);
  
        return respuesta; 
      }
}