package examples.Gradient;

import java.util.*;
import java.math.BigDecimal;
import examples.Gradient.dataSet;
import examples.Gradient.dataSet;

public class GradiantFunction {
    //dataSet dataset = new dataSet();
    //int[] x = dataset.getX();
    //int[] y = dataset.getX();

    int x[] = { 23, 26, 30, 34, 43, 48, 52, 57, 58 };
    int y[] = { 651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518 };
    double alpha = 0.0005;
    double beta0 = 0.0;
    double beta1 = 0.0;
    double n = x.length;
    double sigma = 0.9;

    public void calculateError() {
        double sum = 0.0;
        for(int i = 0; i < n; i++){
            sum = sum + (y[i] - (beta0 + (beta1*x[i])));
        }
        sigma = (sum*sum) * (1.0/n);
    }

    public void recalculateBetas() {
        double beta0Temp = 0.0;
        double beta1Temp = 0.0;

        for(int i = 0; i < n; i++){
            beta0Temp = beta0Temp + (y[i] - (beta0 + beta1 * x[i]));
            beta1Temp = beta1Temp + ((y[i] - (beta0 + beta1 * x[i])) * x[i]);
        }
        beta0Temp = beta0Temp * (-2/n);
        beta1Temp = beta1Temp * (-2/n);

        beta0 = beta0 - (alpha * beta0Temp);
        beta1 = beta1 - (alpha * beta1Temp);
    }

    public void isErrorOptime() {
       while(sigma > 0.0001){
           recalculateBetas();
           calculateError();
       }
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
