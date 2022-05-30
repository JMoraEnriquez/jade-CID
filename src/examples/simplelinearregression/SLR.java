package examples.simplelinearregresion;

public class SLR {
  double beta0;
  double beta1;

  public SLR() {
    beta0 = 0;
    beta1 = 0;
  }

  public void calcularB0(double sumatoriaX, double sumatoriaY) {
    beta0 = (sumatoriaY - beta1 * sumatoriaX) / 9;
  }

  public void calcularB1(double sumatoriaX, double sumatoriaY, double sumatoriaXY, double sumatoriaXX) {
    beta1 = (sumatoriaXY - sumatoriaX * sumatoriaY) / (sumatoriaXX - sumatoriaX * sumatoriaX);
  }

  public void displayar() {
    System.out.println(beta0 + " + " + beta1 + " * X");
  }

  public void pronosticar(double valor) {
    double respuesta = 0;
    respuesta = beta0 + beta1 * valor;
    System.out.println(respuesta);
  }
}
