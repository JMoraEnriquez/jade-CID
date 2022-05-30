package examples.multiplelinearregression;

public class MatrixHelper{

    public double[][] multiply(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
  
        if (a[0].length == b.length) {// se comprueba si las matrices se pueden multiplicar
          for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
              for (int k = 0; k < a[0].length; k++) {
                c[i][j] += a[i][k] * b[k][j];// aquí se multiplica la matriz
              }
            }
          }
        }
        return c;
      }
  
      public double[][] matrizTranspuesta(double[][] matriz) {
        double[][] transpuesta = new double[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
          for (int j = 0; j < matriz[i].length; j++) {
            transpuesta[j][i] = matriz[i][j];
          }
        }
        return transpuesta;
      }
  
      public double [][] inverse(double [][] matriz){
        double matrizInversa[][] = new double [matriz.length][matriz[0].length];
        double pivote, aux;

        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                matrizInversa[i][j] = 0;
                if(i == j){
                    matrizInversa[i][j] = 1;
                }
            }
        }

        for(int i=0; i<matriz.length; i++){
            pivote = matriz[i][i];

            for(int k=0; k<matriz.length; k++){
                matriz[i][k] = matriz[i][k]/pivote;
                matrizInversa[i][k] = matrizInversa[i][k]/pivote;
            }

            for(int j=0; j<matriz.length; j++){
                if(i != j){
                    aux = matriz[j][i];

                    for(int k=0; k<matriz.length; k++){
                        matriz[j][k] = matriz[j][k] - aux * matriz[i][k];
                        matrizInversa[j][k] = matrizInversa[j][k] - aux * matrizInversa[i][k];
                    }
                }
            }
        }

        return matrizInversa;
    }
    
      public double[][] matrizInversa(double[][] matriz) {
        double det = 1 / determinante(matriz);       
        double[][] nmatriz = matrizAdjunta(matriz);
        multiplicarMatriz(det, nmatriz);
        return nmatriz;
      }
  
      public double determinante(double[][] matriz) {
        double det;
        if (matriz.length == 2) {
          det = (matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]);
          return det;
        }
        double suma = 0;
        for (int i = 0; i < matriz.length; i++) {
          double[][] nm = new double[matriz.length - 1][matriz.length - 1];
          for (int j = 0; j < matriz.length; j++) {
            if (j != i) {
              for (int k = 1; k < matriz.length; k++) {
                int indice = -1;
                if (j < i)
                  indice = j;
                else if (j > i)
                  indice = j - 1;
                nm[indice][k - 1] = matriz[j][k];
              }
            }
          }
          if (i % 2 == 0)
            suma += matriz[i][0] * determinante(nm);
          else
            suma -= matriz[i][0] * determinante(nm);
        }
        return suma;
      }
  
      public double[][] matrizAdjunta(double[][] matriz) {
        return matrizTranspuesta(matrizCofactores(matriz));
      }
  
      public void multiplicarMatriz(double n, double[][] matriz) {
        for (int i = 0; i < matriz.length; i++)
          for (int j = 0; j < matriz.length; j++)
            matriz[i][j] *= n;
      }
  
      public double[][] matrizCofactores(double[][] matriz) {
        double[][] nm = new double[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
          for (int j = 0; j < matriz.length; j++) {
            double[][] det = new double[matriz.length - 1][matriz.length - 1];
            double detValor;
            for (int k = 0; k < matriz.length; k++) {
              if (k != i) {
                for (int l = 0; l < matriz.length; l++) {
                  if (l != j) {
                    int indice1 = k < i ? k : k - 1;
                    int indice2 = l < j ? l : l - 1;
                    det[indice1][indice2] = matriz[k][l];
                  }
                }
              }
            }
            detValor = determinante(det);
            nm[i][j] = detValor * (double) Math.pow(-1, i + j + 2);
          }
        }
        return nm;
      }
      
    
}