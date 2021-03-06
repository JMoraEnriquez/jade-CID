package examples.multiplelinearregression;

public class DataSet {

    double x[][] = {
            {1, 23 },
            {1, 26 },
            {1, 30 },
            {1, 34 },
            {1, 43 },
            {1, 48 },
            {1, 52 },
            {1, 57 },
            {1, 58 },
    };

    double y[][] = {
            { 651 },
            { 762 },
            { 856 },
            { 1063 },
            { 1190 },
            { 1298 },
            { 1421 },
            { 1440 },
            { 1518 },
    };
    
/*
    double x[][] = {
            { 1, 41.9, 29.1 },
            { 1, 43.4, 29.3 },
            { 1, 43.9, 29.5 },
            { 1, 44.5, 29.7 },
            { 1, 47.3, 29.9 },
            { 1, 47.5, 30.3 },
            { 1, 47.9, 30.5 },
            { 1, 50.2, 30.7 },
            { 1, 52.8, 30.8 },
            { 1, 53.2, 30.9 },
            { 1, 56.7, 31.5 },
            { 1, 57.0, 31.7 },
            { 1, 63.5, 31.9 },
            { 1, 65.3, 32.0 },
            { 1, 71.1, 32.1 },
            { 1, 77.0, 32.5 },
            { 1, 77.8, 32.9 },
    };

    double y[][] = {
            { 251.3 },
            { 251.3 },
            { 248.3 },
            { 267.5 },
            { 273.0 },
            { 276.5 },
            { 270.3 },
            { 274.9 },
            { 285.0 },
            { 290.0 },
            { 297.0 },
            { 302.5 },
            { 304.5 },
            { 309.3 },
            { 321.7 },
            { 330.7 },
            { 349.0 },
    };
*/
    public double[][] getX() {
        return x;
    }

    public double[][] getY() {
        return y;
    }
}