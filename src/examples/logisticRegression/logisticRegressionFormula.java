package examples.logisticRegression;

import java.lang.Math;

import examples.logisticRegression.MLR;
import examples.logisticRegression.dataSet;;

public class logisticRegressionFormula {

    dataSet dataset = new dataSet();
    double x[][] = dataset.getX();
    double y[][] = dataset.getY();
    
    double p = 0.0;

    public void calculateprobability() {
        MLR mlr = new MLR();
        mlr.calcularBetas(x, y);

        //p = 1 / (1 + Math.exp(-(mlr.beta0 + mlr.beta1 * x[0][1] + mlr.beta2 * x[0][2] + mlr.beta3 * x[0][3]-1)));
        //p = 1 / (1 + Math.exp(-(mlr.beta0 + mlr.beta1 * x[6][1] + mlr.beta2 * x[6][2] + mlr.beta3 * x[6][3]-1)));
        p = 1 / (1 + Math.exp(-(mlr.beta0 + mlr.beta1 * 700 + mlr.beta2 * 4.0 + mlr.beta3 * 4.0 - 1)));
        
        System.out.println("Probablity = " + p);
    }

}
