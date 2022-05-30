package examples.logisticRegression;

import examples.logisticRegression.MatrixHelper;

public class MLR extends MatrixHelper {
  double beta0;
  double beta1;
  double beta2;
  double beta3;

  public MLR() {
    beta0 = 0;
    beta1 = 0;
    beta2 = 0;
    beta3 = 0;
  }

  public void calcularBetas(double[][] x, double[][] y) {
    double[][] betas = multiply(inverse(multiply(matrizTranspuesta(x), x)), multiply(matrizTranspuesta(x), y));
    beta0 = betas[0][0];
    beta1 = betas[1][0];
    beta2 = betas[2][0];
    beta2 = betas[3][0];
  }

  public void displayar() {
    System.out.println(beta0 + " + " + beta1 + " * X1 + " + beta2 + " * X2");
  }

  public void pronosticar(double X1, double X2) {
    double respuesta = 0;
    respuesta = beta0 + beta1 * X1 + beta2 * X2;
    System.out.println(respuesta);
  }

  public void pronosticar(double X1) {
    double respuesta = 0;
    respuesta = beta0 + beta1 * X1;
    System.out.println(respuesta);
  }

}