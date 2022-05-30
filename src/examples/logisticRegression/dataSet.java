package examples.logisticRegression;

public class dataSet {

    double x[][] = {
            { 1, 780, 4, 3 },
            { 1, 750, 3.9, 4 },
            { 1, 690, 3.3, 3 },
            { 1, 710, 3.7, 5 },
            { 1, 680, 3.9, 4 },
            { 1, 730, 3.7, 6 },
            { 1, 690, 2.3, 1 },
            { 1, 720, 3.3, 4 },
            { 1, 740, 3.3, 5 }

    };

    double y[][] = {
            { 1 },
            { 1 },
            { 0 },
            { 1 },
            { 0 },
            { 1 },
            { 0 },
            { 1 },
            { 1 }
    };

    public double[][] getX() {
        return x;
    }

    public double[][] getY() {
        return y;
    }
}
